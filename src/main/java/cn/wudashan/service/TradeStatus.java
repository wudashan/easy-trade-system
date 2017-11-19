package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum TradeStatus {

    DEFALUT("DEFAULT"), CANCEL("CANCEL");

    private final String value;

    TradeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
