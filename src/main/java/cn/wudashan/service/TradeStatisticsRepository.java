package cn.wudashan.service;

import cn.wudashan.domain.TradeStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeStatisticsRepository extends JpaRepository<TradeStatistics, Long> {
}
