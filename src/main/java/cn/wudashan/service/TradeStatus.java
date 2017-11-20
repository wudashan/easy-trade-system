package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum TradeStatus {

    DEFALUT("DEFAULT"), CANCEL("CANCEL"), AGGREGATED("AGGREGATED"), AGGREGATING("AGGREGATING");

    private final String value;

    TradeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
