package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Inventory;
import com.vinhnt.caferecipeadmin.data.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    // Lấy tất cả các Inventory
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    // Lấy Inventory theo ID
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    // Lưu Inventory
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Xóa Inventory theo ID
    public void deleteById(Long id) {
        inventoryRepository.deleteById(id);
    }

    // Tìm Inventory theo Ingredient ID
    public Optional<Inventory> findByIngredientId(Long ingredientId) {
        return inventoryRepository.findByIngredientId(ingredientId);
    }
}