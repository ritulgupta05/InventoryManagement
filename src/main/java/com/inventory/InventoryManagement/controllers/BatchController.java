package com.inventory.InventoryManagement.controllers;

import com.inventory.InventoryManagement.Dto.BatchDto;
import com.inventory.InventoryManagement.entities.Batch;
import com.inventory.InventoryManagement.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class BatchController {
    @Autowired
    private BatchService batchService;


    @PostMapping()
    public ResponseEntity<?> createBatch(@RequestBody BatchDto batchDto) {
        Batch batch1 = batchService.createBatch(batchDto);
        if (batch1 == null) {
            return ResponseEntity.status(500).body("Failed to add Batch given invalid GTIN or Batch ID already exists");
        }
        return ResponseEntity.ok(batch1);
    }

    @GetMapping("/positive-available-and-latest-negative-or-zero-batch")
    public ResponseEntity<?> getGtinsWithPositiveAvailableQuantityAndLatestNegativeOrZeroBatchGtins() {
        List<Batch> batchesWithPositiveAvailableQuantity = batchService.getAllBatchesForPositiveQuantityAndLatestForNonPositive();
        if (batchesWithPositiveAvailableQuantity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No GTINs with positive available quantity found");
        }
            return ResponseEntity.ok(batchesWithPositiveAvailableQuantity);
    }
}
