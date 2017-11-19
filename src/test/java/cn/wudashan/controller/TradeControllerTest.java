package cn.wudashan.controller;

import cn.wudashan.JunitBaseTest;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.dto.TradeResponseDTO;
import cn.wudashan.service.ForeignAmountType;
import cn.wudashan.service.ForeignTradeDirection;
import cn.wudashan.util.JsonUtil;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TradeControllerTest extends JunitBaseTest {

    private static final String TRADE_URL = "/v1/trade";

    @Test
    public void test_trade() throws Exception {

        TradeRequestDTO requestDTO = new TradeRequestDTO();
        requestDTO.setUserId("123456789");
        requestDTO.setRmbAmount(125.0);
        requestDTO.setForeignTradeDirection(ForeignTradeDirection.BUY.getValue());
        requestDTO.setForeignAmount(100.0);
        requestDTO.setExchangeRate(0.8);
        requestDTO.setForeignAmountType(ForeignAmountType.HKD.getValue());

        ResultActions resultActions = mockMvc.perform(post(TRADE_URL)
            .content(JsonUtil.getInstance().convertObject2JsonString(requestDTO))
            .contentType(MediaType.APPLICATION_JSON_UTF8));

        resultActions.andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        TradeResponseDTO responseDTO = JsonUtil.getInstance().convertJsonString2Object(response, TradeResponseDTO.class);
        assertThat(responseDTO.getTradeId()).isNotEmpty();
    }

}
