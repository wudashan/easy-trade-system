package cn.wudashan.controller;

import cn.wudashan.dto.CancelTradeRequestDTO;
import cn.wudashan.dto.CancelTradeResponseDTO;
import cn.wudashan.dto.TradeRequestDTO;
import cn.wudashan.dto.TradeResponseDTO;
import cn.wudashan.service.TradeService;
import cn.wudashan.service.exception.TradeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author wuzhaofeng
 */
@RestController
public class TradeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradeService tradeService;

    @RequestMapping(path = "/v1/trade", method= RequestMethod.POST)
    public ResponseEntity<TradeResponseDTO> trade(@RequestBody @Valid TradeRequestDTO requestDTO) {

        logger.info("request:{}", requestDTO);

        String tradeId = tradeService.saveTrade(requestDTO);

        TradeResponseDTO responseDTO = new TradeResponseDTO();
        responseDTO.setTradeId(tradeId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/v1/cancelTrade", method= RequestMethod.POST)
    public ResponseEntity<CancelTradeResponseDTO> cancelTrade(@RequestBody @Valid CancelTradeRequestDTO requestDTO) {

        logger.info("request:{}", requestDTO);

        CancelTradeResponseDTO responseDTO = new CancelTradeResponseDTO();
        try {
            tradeService.cancelTrade(requestDTO);
        } catch (TradeNotFoundException e) {
            logger.warn("can not find trade");
            responseDTO.setResult("Failed");
            responseDTO.setResultDetail("Can not find or cancel trade!");
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        responseDTO.setResult("Success");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
