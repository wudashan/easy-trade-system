package cn.wudashan.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wuzhaofeng
 */
public class CancelTradeRequestDTO {

    @NotNull
    @Size(min = 1, max = 64)
    private String tradeId;

    @NotNull
    @Size(min = 1, max = 64)
    private String userId;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CancelTradeRequestDTO{");
        sb.append("tradeId='").append(tradeId).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
