package cn.wudashan.service;

import cn.wudashan.domain.Trade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wuzhaofeng
 */
public interface TradeRepository extends JpaRepository<Trade, Long> {

    Trade findByTradeIdAndUserIdAndStatus(String tradeId, String userId, String status);

    List<Trade> findAllByStatusAndForeignAmountType(String status, String foreignAmountType, Pageable pageable);

    Long countAllByStatusAndForeignAmountType(String status, String foreignAmountType);

    @Modifying
    @Transactional
    @Query("update Trade t set t.status = ?1 where t.status = ?2")
    void updateAllByStatus(String dstStatus, String srcStatus);

}
