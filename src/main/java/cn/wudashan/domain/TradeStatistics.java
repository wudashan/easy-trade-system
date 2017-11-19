package cn.wudashan.domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author wuzhaofeng
 */
@Entity
@Table(name = "trade_statistics")
public class TradeStatistics {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String amountType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private DateTime statisticsTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public DateTime getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(DateTime statisticsTime) {
        this.statisticsTime = statisticsTime;
    }
}
