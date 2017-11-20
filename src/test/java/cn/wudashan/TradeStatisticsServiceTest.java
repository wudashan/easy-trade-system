package cn.wudashan;

import cn.wudashan.domain.Trade;
import cn.wudashan.domain.TradeStatistics;
import cn.wudashan.service.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TradeStatisticsServiceTest extends JunitBaseTest  {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private TradeStatisticsService tradeStatisticsService;

    @Autowired
    private TradeStatisticsRepository tradeStatisticsRepository;

    @Before
    public void before() throws Exception {
        tradeRepository.deleteAll();
        tradeStatisticsRepository.deleteAll();
    }

    @Test
    public void test_statisticsTrade_success() throws Exception {

        // 构造条件
        Trade trade1 = new Trade();
        trade1.setUserId(UUID.randomUUID().toString());
        trade1.setRmbAmount(new BigDecimal(125));
        trade1.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        trade1.setForeignAmount(new BigDecimal(100));
        trade1.setExchangeRate(new BigDecimal(0.8));
        trade1.setForeignAmountType(AmountType.HKD.getValue());
        trade1.setStatus(TradeStatus.DEFALUT.getValue());
        trade1.setTradeId(UUID.randomUUID().toString());
        tradeRepository.save(trade1);

        Trade trade2 = new Trade();
        trade2.setUserId(UUID.randomUUID().toString());
        trade2.setRmbAmount(new BigDecimal(100));
        trade2.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        trade2.setForeignAmount(new BigDecimal(20));
        trade2.setExchangeRate(new BigDecimal(0.2));
        trade2.setForeignAmountType(AmountType.USD.getValue());
        trade2.setStatus(TradeStatus.DEFALUT.getValue());
        trade2.setTradeId(UUID.randomUUID().toString());
        tradeRepository.save(trade2);

        Trade trade3 = new Trade();
        trade3.setUserId(UUID.randomUUID().toString());
        trade3.setRmbAmount(new BigDecimal(800));
        trade3.setForeignTradeDirection(ForeignTradeDirection.SELL.getValue());
        trade3.setForeignAmount(new BigDecimal(100));
        trade3.setExchangeRate(new BigDecimal(8));
        trade3.setForeignAmountType(AmountType.USD.getValue());
        trade3.setStatus(TradeStatus.DEFALUT.getValue());
        trade3.setTradeId(UUID.randomUUID().toString());
        tradeRepository.save(trade3);


        // 调用测试接口
        tradeStatisticsService.statisticsTrade();

        // 检查测试结果
        List<Trade> trades = tradeRepository.findAll();
        assertThat(trades.size()).isEqualTo(3);
        Trade dbTrade1 = trades.get(0);
        assertThat(dbTrade1.getStatus()).isEqualTo(TradeStatus.AGGREGATED.getValue());
        Trade dbTrade2 = trades.get(0);
        assertThat(dbTrade2.getStatus()).isEqualTo(TradeStatus.AGGREGATED.getValue());
        Trade dbTrade3 = trades.get(0);
        assertThat(dbTrade3.getStatus()).isEqualTo(TradeStatus.AGGREGATED.getValue());

        List<TradeStatistics> tradeStatistics = tradeStatisticsRepository.findAll();
        assertThat(tradeStatistics.size()).isEqualTo(3);
        TradeStatistics tradeStatistics1 = tradeStatistics.get(0);
        assertThat(tradeStatistics1.getAmount().compareTo(new BigDecimal(80))).isEqualTo(0);
        assertThat(tradeStatistics1.getAmountType()).isEqualTo(AmountType.USD.getValue());

        TradeStatistics tradeStatistics2 = tradeStatistics.get(1);
        assertThat(tradeStatistics2.getAmount().compareTo(new BigDecimal(-100))).isEqualTo(0);
        assertThat(tradeStatistics2.getAmountType()).isEqualTo(AmountType.HKD.getValue());

        TradeStatistics tradeStatistics3 = tradeStatistics.get(2);
        assertThat(tradeStatistics3.getAmount().compareTo(new BigDecimal(575))).isEqualTo(0);
        assertThat(tradeStatistics3.getAmountType()).isEqualTo(AmountType.RMB.getValue());

    }

}
