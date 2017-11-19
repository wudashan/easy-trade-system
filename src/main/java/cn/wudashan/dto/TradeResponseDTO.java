package cn.wudashan.dto;

/**
 * @author wuzhaofeng
 */
public class TradeResponseDTO {

    private String tradeId;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TradeResponseDTO{");
        sb.append("tradeId='").append(tradeId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
