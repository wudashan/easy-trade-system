package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.domain.TradeStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wuzhaofeng
 */
@Service
public class TradeStatisticsService {

    private static final String PER_TEN_SECOND = "0/10 * * * * ?";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeStatisticsRepository tradeStatisticsRepository;

    @Scheduled(cron = PER_TEN_SECOND)
    public void statisticsTrade() {

        logger.info("start...");

        for (ForeignAmountType foreignAmountType : ForeignAmountType.values()) {

            List<Trade> trades = tradeService.findAll(TradeStatus.DEFALUT, foreignAmountType);
            if (trades.isEmpty()) {
                return;
            }
            for (Trade trade : trades) {
                trade.setStatus(TradeStatus.AGGREGATED.getValue());
            }
            tradeService.saveAll(trades);

            double money = 0;
            for (Trade trade : trades) {
                if (ForeignTradeDirection.BUY.getValue().equals(trade.getForeignTradeDirection())) {
                    money -= trade.getForeignAmount();
                }
                if (ForeignTradeDirection.SELL.getValue().equals(trade.getForeignTradeDirection())) {
                    money += trade.getForeignAmount();
                }
            }
            TradeStatistics tradeStatistics = new TradeStatistics();
            tradeStatistics.setAmountType(foreignAmountType.getValue());
            tradeStatistics.setAmount(money);
            tradeStatisticsRepository.save(tradeStatistics);

        }

        logger.info("end...");

    }

}
