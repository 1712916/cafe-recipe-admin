package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.InventoryTransaction;
import com.vinhnt.caferecipeadmin.data.repository.InventoryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryTransactionService {
    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public List<InventoryTransaction> findAll() {
        return inventoryTransactionRepository.findAll();
    }

    public Optional<InventoryTransaction> findById(Long id) {
        return inventoryTransactionRepository.findById(id);
    }

    public InventoryTransaction save(InventoryTransaction transaction) {
        return inventoryTransactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        inventoryTransactionRepository.deleteById(id);
    }
}