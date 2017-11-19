package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.dto.TradeRequestDTO;
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

    public String saveTrade(TradeRequestDTO requestDTO) {

        String tradeId = UUID.randomUUID().toString();

        Trade trade = new Trade();
        trade.setTradeId(tradeId);
        trade.setUserId(requestDTO.getUserId());
        trade.setForeignAmount(requestDTO.getForeignAmount());
        trade.setForeignAmountType(requestDTO.getForeignAmountType());
        trade.setForeignTradeDirection(requestDTO.getForeignTradeDirection());
        trade.setRmbAmount(requestDTO.getRmbAmount());
        trade.setExchangeRate(requestDTO.getExchangeRate());
        tradeRepository.save(trade);
        return tradeId;

    }

}
