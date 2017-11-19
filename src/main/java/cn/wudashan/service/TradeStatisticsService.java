package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.domain.TradeStatistics;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wuzhaofeng
 */
@Service
public class TradeStatisticsService {

    private static final String PER_TEN_MINUTES = "0 0/10 * * * ?";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeStatisticsRepository tradeStatisticsRepository;

    @Scheduled(cron = PER_TEN_MINUTES)
    public void statisticsTrade() {

        logger.info("start...");

        DateTime statisticsTime = new DateTime();

        BigDecimal rmbMoney = new BigDecimal(0);
        for (AmountType amountType : AmountType.values()) {

            List<Trade> trades = tradeService.findAll(TradeStatus.DEFALUT, amountType);
            if (trades.isEmpty()) {
                continue;
            }
            for (Trade trade : trades) {
                trade.setStatus(TradeStatus.AGGREGATED.getValue());
            }
            tradeService.saveAll(trades);

            BigDecimal foreignMoney = new BigDecimal(0);
            for (Trade trade : trades) {
                if (ForeignTradeDirection.BUY.getValue().equals(trade.getForeignTradeDirection())) {
                    foreignMoney = foreignMoney.subtract(trade.getForeignAmount());
                    rmbMoney = rmbMoney.subtract(trade.getRmbAmount());
                }
                if (ForeignTradeDirection.SELL.getValue().equals(trade.getForeignTradeDirection())) {
                    foreignMoney = foreignMoney.add(trade.getForeignAmount());
                    rmbMoney = rmbMoney.add(trade.getRmbAmount());
                }
            }
            TradeStatistics tradeStatistics = new TradeStatistics();
            tradeStatistics.setAmountType(amountType.getValue());
            tradeStatistics.setAmount(foreignMoney);
            tradeStatistics.setStatisticsTime(statisticsTime);
            tradeStatisticsRepository.save(tradeStatistics);

        }

        TradeStatistics tradeStatistics = new TradeStatistics();
        tradeStatistics.setAmountType(AmountType.RMB.getValue());
        tradeStatistics.setAmount(rmbMoney);
        tradeStatistics.setStatisticsTime(statisticsTime);
        tradeStatisticsRepository.save(tradeStatistics);

        logger.info("end...");

    }

}
