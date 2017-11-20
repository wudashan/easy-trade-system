package cn.wudashan.service;


import cn.wudashan.domain.Trade;
import cn.wudashan.dto.CancelTradeRequestDTO;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.service.exception.TradeNotFoundException;

import java.util.List;

/**
 * @author wuzhaofeng
 */
public interface TradeService {

    String saveTrade(TradeRequestDTO requestDTO);

    void cancelTrade(CancelTradeRequestDTO requestDTO) throws TradeNotFoundException;

    List<Trade> findByParamAndPage(TradeStatus tradeStatus, AmountType amountType, int page , int size);

    Long countAllByParam(TradeStatus tradeStatus, AmountType amountType);

    void updateAllByStatus(TradeStatus dstStatus, TradeStatus srcStatus);

}
