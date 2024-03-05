package com.legacy.model.entities.enums;

public enum Category {
    SMARTPHONES(1),
    NOTEBOOKS(2),
    COMPUTERS(3),
    TABLETS(4);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

