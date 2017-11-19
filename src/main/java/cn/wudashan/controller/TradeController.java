package cn.wudashan.controller;

import cn.wudashan.dto.TradeRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TradeController {

    @RequestMapping(path = "/v1/trade", method= RequestMethod.POST)
    public ResponseEntity<Void> trade(@RequestBody TradeRequestDTO requestDTO) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
