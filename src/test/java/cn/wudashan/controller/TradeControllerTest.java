package cn.wudashan.controller;

import cn.wudashan.JunitBaseTest;
import cn.wudashan.domain.Trade;
import cn.wudashan.dto.CancelTradeRequestDTO;
import cn.wudashan.dto.CancelTradeResponseDTO;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.dto.TradeResponseDTO;
import cn.wudashan.service.AmountType;
import cn.wudashan.service.ForeignTradeDirection;
import cn.wudashan.service.TradeRepository;
import cn.wudashan.service.TradeStatus;
import cn.wudashan.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TradeControllerTest extends JunitBaseTest {

    private static final String TRADE_URL = "/v1/trade";

    private static final String CANCEL_TRADE_URL = "/v1/cancelTrade";

    @Autowired
    private TradeRepository tradeRepository;

    @Before
    public void before() throws Exception {
        tradeRepository.deleteAll();
    }



    @Test
    public void test_trade_success() throws Exception {

        // 构造条件
        TradeRequestDTO requestDTO = new TradeRequestDTO();
        requestDTO.setUserId(UUID.randomUUID().toString());
        requestDTO.setRmbAmount(new BigDecimal(125.0).setScale(3, RoundingMode.FLOOR));
        requestDTO.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        requestDTO.setForeignAmount(new BigDecimal(100.0).setScale(3, RoundingMode.FLOOR));
        requestDTO.setExchangeRate(new BigDecimal(0.8).setScale(6, RoundingMode.FLOOR));
        requestDTO.setForeignAmountType(AmountType.HKD.getValue());

        // 调用测试接口
        ResultActions resultActions = mockMvc.perform(post(TRADE_URL)
            .content(JsonUtil.getInstance().convertObject2JsonString(requestDTO))
            .contentType(MediaType.APPLICATION_JSON_UTF8));

        // 检查测试结果
        resultActions.andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        TradeResponseDTO responseDTO = JsonUtil.getInstance().convertJsonString2Object(response, TradeResponseDTO.class);
        assertThat(responseDTO.getTradeId()).isNotEmpty();

        List<Trade> trades = tradeRepository.findAll();
        assertThat(trades.size()).isEqualTo(1);
        Trade trade = trades.get(0);
        assertThat(trade.getForeignAmount().compareTo(requestDTO.getForeignAmount())).isEqualTo(0);
        assertThat(trade.getForeignTradeDirection()).isEqualTo(requestDTO.getForeignTradeDirection());
        assertThat(trade.getExchangeRate().compareTo(requestDTO.getExchangeRate())).isEqualTo(0);
        assertThat(trade.getForeignAmountType()).isEqualTo(requestDTO.getForeignAmountType());
        assertThat(trade.getRmbAmount().compareTo(requestDTO.getRmbAmount())).isEqualTo(0);
        assertThat(trade.getUserId()).isEqualTo(requestDTO.getUserId());
        assertThat(trade.getTradeId()).isEqualTo(responseDTO.getTradeId());
        assertThat(trade.getStatus()).isEqualTo(TradeStatus.DEFALUT.getValue());
    }

    @Test
    public void test_cancelTrade_success() throws Exception {

        // 构造条件
        Trade trade = new Trade();
        trade.setUserId(UUID.randomUUID().toString());
        trade.setTradeId(UUID.randomUUID().toString());
        trade.setStatus(TradeStatus.DEFALUT.getValue());
        trade.setRmbAmount(new BigDecimal(125.0).setScale(3, RoundingMode.FLOOR));
        trade.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        trade.setForeignAmount(new BigDecimal(100.0).setScale(3, RoundingMode.FLOOR));
        trade.setExchangeRate(new BigDecimal(0.8).setScale(6, RoundingMode.FLOOR));
        trade.setForeignAmountType(AmountType.HKD.getValue());
        tradeRepository.save(trade);

        CancelTradeRequestDTO requestDTO = new CancelTradeRequestDTO();
        requestDTO.setUserId(trade.getUserId());
        requestDTO.setTradeId(trade.getTradeId());

        // 调用测试接口
        ResultActions resultActions = mockMvc.perform(post(CANCEL_TRADE_URL)
                .content(JsonUtil.getInstance().convertObject2JsonString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // 检查测试结果
        resultActions.andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        CancelTradeResponseDTO responseDTO = JsonUtil.getInstance().convertJsonString2Object(response, CancelTradeResponseDTO.class);
        assertThat(responseDTO.getResult()).isEqualTo("Success");
        assertThat(responseDTO.getResultDetail()).isNull();

        List<Trade> trades = tradeRepository.findAll();
        assertThat(trades.size()).isEqualTo(1);
        Trade dbTrade = trades.get(0);
        assertThat(dbTrade.getForeignAmount().compareTo(trade.getForeignAmount())).isEqualTo(0);
        assertThat(dbTrade.getForeignTradeDirection()).isEqualTo(trade.getForeignTradeDirection());
        assertThat(dbTrade.getExchangeRate().compareTo(trade.getExchangeRate())).isEqualTo(0);
        assertThat(dbTrade.getForeignAmountType()).isEqualTo(trade.getForeignAmountType());
        assertThat(dbTrade.getRmbAmount().compareTo(trade.getRmbAmount())).isEqualTo(0);
        assertThat(dbTrade.getUserId()).isEqualTo(trade.getUserId());
        assertThat(dbTrade.getTradeId()).isEqualTo(trade.getTradeId());
        assertThat(dbTrade.getStatus()).isEqualTo(TradeStatus.CANCEL.getValue());

    }

    @Test
    public void test_cancelTrade_failed() throws Exception {

        // 构造条件
        Trade trade = new Trade();
        trade.setUserId(UUID.randomUUID().toString());
        trade.setTradeId(UUID.randomUUID().toString());
        trade.setStatus(TradeStatus.DEFALUT.getValue());
        trade.setRmbAmount(new BigDecimal(125.0).setScale(3, RoundingMode.FLOOR));
        trade.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        trade.setForeignAmount(new BigDecimal(100.0).setScale(3, RoundingMode.FLOOR));
        trade.setExchangeRate(new BigDecimal(0.8).setScale(6, RoundingMode.FLOOR));
        trade.setForeignAmountType(AmountType.HKD.getValue());
        tradeRepository.save(trade);

        CancelTradeRequestDTO requestDTO = new CancelTradeRequestDTO();
        requestDTO.setUserId(trade.getUserId() + "_wrong_test");
        requestDTO.setTradeId(trade.getTradeId() + "_wrong_test");

        // 调用测试接口
        ResultActions resultActions = mockMvc.perform(post(CANCEL_TRADE_URL)
                .content(JsonUtil.getInstance().convertObject2JsonString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // 检查测试结果
        resultActions.andExpect(status().isBadRequest());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        CancelTradeResponseDTO responseDTO = JsonUtil.getInstance().convertJsonString2Object(response, CancelTradeResponseDTO.class);
        assertThat(responseDTO.getResult()).isEqualTo("Failed");
        assertThat(responseDTO.getResultDetail()).isEqualTo("Can not find or cancel trade!");

        List<Trade> trades = tradeRepository.findAll();
        assertThat(trades.size()).isEqualTo(1);
        Trade dbTrade = trades.get(0);
        assertThat(dbTrade.getForeignAmount().compareTo(trade.getForeignAmount())).isEqualTo(0);
        assertThat(dbTrade.getForeignTradeDirection()).isEqualTo(trade.getForeignTradeDirection());
        assertThat(dbTrade.getExchangeRate().compareTo(trade.getExchangeRate())).isEqualTo(0);
        assertThat(dbTrade.getForeignAmountType()).isEqualTo(trade.getForeignAmountType());
        assertThat(dbTrade.getRmbAmount().compareTo(trade.getRmbAmount())).isEqualTo(0);
        assertThat(dbTrade.getUserId()).isEqualTo(trade.getUserId());
        assertThat(dbTrade.getTradeId()).isEqualTo(trade.getTradeId());
        assertThat(dbTrade.getStatus()).isEqualTo(TradeStatus.DEFALUT.getValue());

    }

}
