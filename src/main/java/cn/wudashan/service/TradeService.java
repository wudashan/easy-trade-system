package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wuzhaofeng
 */
@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public String saveTrade() {
        String tradeId = UUID.randomUUID().toString();
        Trade trade = new Trade();
        trade.setTradeId(tradeId);
        tradeRepository.save(trade);
        return tradeId;
    }

}
