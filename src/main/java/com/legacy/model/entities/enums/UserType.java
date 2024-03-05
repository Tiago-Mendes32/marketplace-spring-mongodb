package com.legacy.model.entities.enums;

public enum UserType {
    SELLER(1),
    BUYER(2),
    SUPPORT(3);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
