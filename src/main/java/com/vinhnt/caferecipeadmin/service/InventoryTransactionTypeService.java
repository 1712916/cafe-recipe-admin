package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.InventoryTransactionType;
import com.vinhnt.caferecipeadmin.data.repository.InventoryTransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryTransactionTypeService {
    @Autowired
    private InventoryTransactionTypeRepository inventoryTransactionTypeRepository;

    public List<InventoryTransactionType> findAll() {
        return inventoryTransactionTypeRepository.findAll();
    }

    public Optional<InventoryTransactionType> findById(Long id) {
        return inventoryTransactionTypeRepository.findById(id);
    }

    public InventoryTransactionType save(InventoryTransactionType transactionType) {
        return inventoryTransactionTypeRepository.save(transactionType);
    }

    public void deleteById(Long id) {
        inventoryTransactionTypeRepository.deleteById(id);
    }
}