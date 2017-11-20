package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import cn.wudashan.dto.CancelTradeRequestDTO;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.service.exception.TradeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 * @author wuzhaofeng
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
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

    @Override
    public void cancelTrade(CancelTradeRequestDTO requestDTO) throws TradeNotFoundException {

        Trade trade = tradeRepository.findByTradeIdAndUserIdAndStatus(requestDTO.getTradeId(), requestDTO.getUserId(),
            TradeStatus.DEFALUT.getValue());
        if (trade == null) {
            throw new TradeNotFoundException();
        }

        trade.setStatus(TradeStatus.CANCEL.getValue());
        tradeRepository.save(trade);

    }

    @Override
    public List<Trade> findByParamAndPage(TradeStatus tradeStatus, AmountType amountType, int page , int size) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return tradeRepository.findAllByStatusAndForeignAmountType(tradeStatus.getValue(), amountType.getValue(), pageable);
    }

    @Override
    public Long countAllByParam(TradeStatus tradeStatus, AmountType amountType) {
        return tradeRepository.countAllByStatusAndForeignAmountType(tradeStatus.getValue(), amountType.getValue());
    }

    @Override
    public void updateAllByStatus(TradeStatus dstStatus, TradeStatus srcStatus) {
        tradeRepository.updateAllByStatus(dstStatus.getValue(), srcStatus.getValue());
    }

}
