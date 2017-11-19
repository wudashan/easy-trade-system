package cn.wudashan.domain;

import javax.persistence.*;

/**
 * @author wuzhaofeng
 */
@Entity
@Table(name = "tradeStatistics")
public class TradeStatistics {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String amountType;

    @Column(nullable = false)
    private Double amount;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
