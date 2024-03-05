package com.legacy.model.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    AWAITING_SHIPMENT(2),
    IN_DELIVERING(3),
    COMPLETE(4),
    CANCELLED(5);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }}