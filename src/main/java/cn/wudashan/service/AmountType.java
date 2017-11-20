package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum AmountType {

    // 美元
    USD("USD"),

    // 港币
    HKD("HKD"),

    // 人民币
    RMB("RMB");

    private final String value;

    AmountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
