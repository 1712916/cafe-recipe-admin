package com.vinhnt.caferecipeadmin.controller;

import com.vinhnt.caferecipeadmin.data.entity.Inventory;
import com.vinhnt.caferecipeadmin.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    // Lấy tất cả Inventory
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.findAll();
    }

    // Lấy Inventory theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Optional<Inventory> inventory = inventoryService.findById(id);
        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo hoặc cập nhật Inventory
    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }

    // Xóa Inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        Optional<Inventory> inventory = inventoryService.findById(id);
        if (inventory.isPresent()) {
            inventoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm Inventory theo Ingredient ID
    @GetMapping("/ingredient/{ingredientId}")
    public ResponseEntity<Inventory> getInventoryByIngredientId(@PathVariable Long ingredientId) {
        Optional<Inventory> inventory = inventoryService.findByIngredientId(ingredientId);
        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}