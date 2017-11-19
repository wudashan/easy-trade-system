package cn.wudashan.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author wuzhaofeng
 */
public class TradeRequestDTO {

    @NotNull
    @Size(min = 1, max = 64)
    private String userId;

    @NotNull
    @Digits(integer=10, fraction=3)
    private BigDecimal foreignAmount;

    @NotNull
    @Pattern(regexp = "USD|HKD")
    private String foreignAmountType;

    @NotNull
    @Digits(integer=10, fraction=3)
    private BigDecimal rmbAmount;

    @NotNull
    @Digits(integer=10, fraction=6)
    private BigDecimal exchangeRate;

    @NotNull
    @Pattern(regexp = "buy|sell")
    private String foreignTradeDirection;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TradeRequestDTO{");
        sb.append("userId=").append(userId);
        sb.append(", foreignAmount=").append(foreignAmount);
        sb.append(", foreignAmountType='").append(foreignAmountType).append('\'');
        sb.append(", rmbAmount=").append(rmbAmount);
        sb.append(", exchangeRate=").append(exchangeRate);
        sb.append(", foreignTradeDirection='").append(foreignTradeDirection).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
