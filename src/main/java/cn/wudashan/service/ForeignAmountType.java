package cn.wudashan.service;

/**
 * @author wuzhaofeng
 */

public enum ForeignAmountType {

    USD("USD"), HKD("HKD");

    private final String value;

    ForeignAmountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
