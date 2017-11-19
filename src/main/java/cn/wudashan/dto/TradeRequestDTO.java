package cn.wudashan.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author wuzhaofeng
 */
public class TradeRequestDTO {

    @NotNull
    @Size(min = 1, max = 64)
    private String userId;

    @NotNull
    private Double foreignAmount;

    @NotNull
    @Pattern(regexp = "USD|HKD")
    private String foreignAmountType;

    @NotNull
    private Double rmbAmount;

    @NotNull
    private Double exchangeRate;

    @NotNull
    @Pattern(regexp = "buy|sell")
    private String foreignTradeDirection;

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
