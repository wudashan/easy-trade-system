package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum ForeignTradeDirection {

    // 买入外币
    BUY("buy"),

    // 卖出外币
    SELL("sell");

    private final String value;

    ForeignTradeDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
