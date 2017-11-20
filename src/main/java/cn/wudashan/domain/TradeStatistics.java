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
    private DateTime gmtCreate;

    @Column(nullable = false)
    private DateTime gmtModified;

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

    public DateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(DateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public DateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(DateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
