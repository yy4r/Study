
package com.example.base.myProcessor.common.constant;

public enum ProcessorTypeEnum {
    DISCOUNT("discount", "促销领域"),
    PRIZE("prize", "奖品领域"),
    VOUCHER("voucher", "优惠券领域");


    ProcessorTypeEnum(String type, String memo) {
        this.type = type;
        this.memo = memo;
    }

    public static ProcessorTypeEnum getByType(String type) {
        if (type == null) {
            return null;
        }
        for (ProcessorTypeEnum processorTypeEnum : values()) {
            if (type == processorTypeEnum.getType()) {
                return processorTypeEnum;
            }
        }
        return null;
    }

    private String type;

    private String memo;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
