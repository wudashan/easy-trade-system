package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuzhaofeng
 */
public interface TradeRepository extends JpaRepository<Trade, Long> {

    Trade findByTradeIdAndStatus(String tradeId, String status);

    List<Trade> findAllByStatusAndForeignAmountType(String status, String foreignAmountType);


}
