package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum AmountType {

    USD("USD"), HKD("HKD"), RMB("RMB");

    private final String value;

    AmountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
