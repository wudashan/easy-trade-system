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
}
