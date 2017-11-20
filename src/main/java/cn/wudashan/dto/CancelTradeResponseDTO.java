package cn.wudashan.dto;

/**
 * @author wuzhaofeng
 */
public class CancelTradeResponseDTO {

    private String result;

    private String resultDetail;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CancelTradeResponseDTO{");
        sb.append("result='").append(result).append('\'');
        sb.append(", resultDetail='").append(resultDetail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
