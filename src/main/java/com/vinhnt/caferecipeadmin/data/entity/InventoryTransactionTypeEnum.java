package com.vinhnt.caferecipeadmin.data.entity;

public enum InventoryTransactionTypeEnum {
    IN("IN"),
    OUT("OUT"),
    ADJUST("ADJUST");

    private final String type;

    InventoryTransactionTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}