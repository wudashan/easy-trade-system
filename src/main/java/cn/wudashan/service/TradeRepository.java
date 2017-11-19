package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import org.springframework.data.repository.Repository;

/**
 * @author wuzhaofeng
 */
public interface TradeRepository extends Repository<Trade, Long> {

    void save(Trade trade);

}
