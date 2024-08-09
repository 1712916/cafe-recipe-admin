package com.vinhnt.caferecipeadmin.aspect;

import com.vinhnt.caferecipeadmin.data.entity.Inventory;
import com.vinhnt.caferecipeadmin.data.entity.InventoryTransaction;
import com.vinhnt.caferecipeadmin.data.repository.InventoryRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class InventoryAspect {

    @Autowired
    private InventoryRepository inventoryRepository;

    @AfterReturning(pointcut = "execution(* com.vinhnt.caferecipeadmin.service.InventoryTransactionService.save(..))", returning = "transaction")
    public void updateInventory(InventoryTransaction transaction) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findByIngredientId(transaction.getIngredient().getId());

        if (inventoryOptional.isEmpty()) {
            // Nếu không tìm thấy inventory, bạn có thể tạo một bản ghi mới hoặc xử lý lỗi
            // Ví dụ: Log hoặc ném ngoại lệ
            throw new RuntimeException("Inventory not found for ingredient ID: " + transaction.getIngredient().getId());
        }

        Inventory inventory = inventoryOptional.get();

        switch (transaction.getInventoryTransactionType().getType()) {
            case IN:
                inventory.setQuantity(inventory.getQuantity() + transaction.getQuantity());
                break;
            case OUT:
                inventory.setQuantity(inventory.getQuantity() - transaction.getQuantity());
                break;
            case ADJUST:
                inventory.setQuantity(transaction.getQuantity()); // Hoặc điều chỉnh theo logic của bạn
                break;
        }

        inventoryRepository.save(inventory);
    }
}