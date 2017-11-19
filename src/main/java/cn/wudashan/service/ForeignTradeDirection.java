package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum ForeignTradeDirection {

    BUY("buy"), SELL("sell");

    private final String value;

    ForeignTradeDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
