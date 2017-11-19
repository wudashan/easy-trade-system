package cn.wudashan.dto;

public class TradeRequestDTO {

    private Long userId;

    private Double foreignAmount;

    private String foreignAmountType;

    private Double rmbAmount;

    private Double exchangeRate;

    private String tradeDirection;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(String tradeDirection) {
        this.tradeDirection = tradeDirection;
    }

}
