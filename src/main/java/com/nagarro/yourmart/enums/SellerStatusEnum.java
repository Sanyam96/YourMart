package com.nagarro.yourmart.enums;

/**
 * @author Sanyam Goel created on 30/10/18
 */
public enum SellerStatusEnum {

    NEED_APPROVAL(1),

    NON_REGISTERED(2),

    REJECTED(3);

    private long value;

    SellerStatusEnum(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
