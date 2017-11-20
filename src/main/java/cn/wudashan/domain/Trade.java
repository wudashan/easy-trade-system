package cn.wudashan.domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author wuzhaofeng
 */
@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String tradeId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private BigDecimal foreignAmount;

    @Column(nullable = false)
    private String foreignAmountType;

    @Column(nullable = false)
    private BigDecimal rmbAmount;

    @Column(nullable = false)
    private BigDecimal exchangeRate;

    @Column(nullable = false)
    private String foreignTradeDirection;

    @Column(nullable = false)
    private String status;

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

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(BigDecimal foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public String getForeignAmountType() {
        return foreignAmountType;
    }

    public void setForeignAmountType(String foreignAmountType) {
        this.foreignAmountType = foreignAmountType;
    }

    public BigDecimal getRmbAmount() {
        return rmbAmount;
    }

    public void setRmbAmount(BigDecimal rmbAmount) {
        this.rmbAmount = rmbAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getForeignTradeDirection() {
        return foreignTradeDirection;
    }

    public void setForeignTradeDirection(String foreignTradeDirection) {
        this.foreignTradeDirection = foreignTradeDirection;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
