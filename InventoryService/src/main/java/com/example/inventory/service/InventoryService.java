package com.example.inventory.service;

import com.example.inventory.domain.Inventory;
import com.example.inventory.dto.InventoryRequest;
import com.example.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public void addToStock(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.getSkuCode())
                .inventory(inventoryRequest.getInventory())
                .build();
        inventoryRepository.save(inventory);
        log.info("Inventory updated {} {}", inventory.getSkuCode(), inventory.getInventory());
    }
    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}


