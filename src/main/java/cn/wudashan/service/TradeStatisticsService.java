package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.domain.TradeStatistics;
import org.joda.time.DateTime;
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

    private static final String PER_ONE_MINUTES = "0 0/1 * * * ?";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeStatisticsRepository tradeStatisticsRepository;

    @Scheduled(cron = PER_ONE_MINUTES)
    public void statisticsTrade() {

        logger.info("start...");

        DateTime statisticsTime = new DateTime();

        for (ForeignAmountType foreignAmountType : ForeignAmountType.values()) {

            List<Trade> trades = tradeService.findAll(TradeStatus.DEFALUT, foreignAmountType);
            if (trades.isEmpty()) {
                continue;
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
            tradeStatistics.setStatisticsTime(statisticsTime);
            tradeStatisticsRepository.save(tradeStatistics);

        }

        logger.info("end...");

    }

}
