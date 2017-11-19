package cn.wudashan.service;

import cn.wudashan.domain.TradeStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuzhaofeng
 */
public interface TradeStatisticsRepository extends JpaRepository<TradeStatistics, Long> {
}
