package com.vinhnt.caferecipeadmin.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InventoryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_transaction_type_id")
    private InventoryTransactionType inventoryTransactionType; // Liên kết tới InventoryTransactionType

    private LocalDateTime transactionDate;

    public InventoryTransaction() {
        this.transactionDate = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public InventoryTransactionType getInventoryTransactionType() {
        return inventoryTransactionType;
    }

    public void setInventoryTransactionType(InventoryTransactionType inventoryTransactionType) {
        this.inventoryTransactionType = inventoryTransactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}