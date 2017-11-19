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

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CancelTradeRequestDTO{");
        sb.append("tradeId='").append(tradeId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
