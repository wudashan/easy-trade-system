package cn.wudashan.domain;

import javax.persistence.*;

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
    private Double foreignAmount;

    @Column(nullable = false)
    private String foreignAmountType;

    @Column(nullable = false)
    private Double rmbAmount;

    @Column(nullable = false)
    private Double exchangeRate;

    @Column(nullable = false)
    private String foreignTradeDirection;

    @Column(nullable = false)
    private String status;

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

    public Double getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(Double foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public String getForeignAmountType() {
        return foreignAmountType;
    }

    public void setForeignAmountType(String foreignAmountType) {
        this.foreignAmountType = foreignAmountType;
    }

    public Double getRmbAmount() {
        return rmbAmount;
    }

    public void setRmbAmount(Double rmbAmount) {
        this.rmbAmount = rmbAmount;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
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
}
