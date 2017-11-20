package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum TradeStatus {

    // 默认状态
    DEFALUT("DEFAULT"),

    // 取消状态
    CANCEL("CANCEL"),

    // 已汇合状态
    AGGREGATED("AGGREGATED"),

    // 正在汇合状态
    AGGREGATING("AGGREGATING");

    private final String value;

    TradeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
