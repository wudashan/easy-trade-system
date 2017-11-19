package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.dto.CancelTradeRequestDTO;
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
        trade.setStatus(TradeStatus.DEFALUT.getValue());
        tradeRepository.save(trade);
        return tradeId;

    }

    public boolean cancelTrade(CancelTradeRequestDTO requestDTO) {

        Trade trade = tradeRepository.findByTradeIdAndStatus(requestDTO.getTradeId(), TradeStatus.DEFALUT.getValue());
        if (trade == null) {
            return false;
        }
        trade.setStatus(TradeStatus.CANCEL.getValue());
        tradeRepository.save(trade);
        return true;

    }

}
