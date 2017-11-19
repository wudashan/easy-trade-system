package cn.wudashan.controller;

import cn.wudashan.dto.TradeRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class TradeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/v1/trade", method= RequestMethod.POST)
    public ResponseEntity<Void> trade(@RequestBody @Valid TradeRequestDTO requestDTO) {
        logger.info("request:{}", requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
