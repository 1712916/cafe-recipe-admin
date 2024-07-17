package com.vinhnt.caferecipeadmin.data.entity;

import jakarta.persistence.*;

@Entity
public class InventoryTransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InventoryTransactionTypeEnum type; // Sử dụng enum

    private String reason;

    public InventoryTransactionTypeEnum getType() {
        return type;
    }

    // Getters and setters
}