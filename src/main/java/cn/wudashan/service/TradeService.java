package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.dto.CancelTradeRequestDTO;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.service.exception.TradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void cancelTrade(CancelTradeRequestDTO requestDTO) throws TradeNotFoundException {

        Trade trade = tradeRepository.findByTradeIdAndUserIdAndStatus(requestDTO.getTradeId(), requestDTO.getUserId(),
            TradeStatus.DEFALUT.getValue());
        if (trade == null) {
            throw new TradeNotFoundException();
        }

        trade.setStatus(TradeStatus.CANCEL.getValue());
        tradeRepository.save(trade);

    }

    public List<Trade> findAll(TradeStatus tradeStatus, ForeignAmountType foreignAmountType) {
        return tradeRepository.findAllByStatusAndForeignAmountType(tradeStatus.getValue(), foreignAmountType.getValue());
    }

    public List<Trade> saveAll(List<Trade> trades) {
        return tradeRepository.save(trades);
    }

}
