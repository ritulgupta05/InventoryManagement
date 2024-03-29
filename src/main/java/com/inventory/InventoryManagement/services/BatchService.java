package com.inventory.InventoryManagement.services;

import com.inventory.InventoryManagement.Dto.BatchDto;
import com.inventory.InventoryManagement.entities.Batch;
import com.inventory.InventoryManagement.entities.Gtin;
import com.inventory.InventoryManagement.repositories.BatchRepository;
import com.inventory.InventoryManagement.repositories.GtinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;

    private final GtinService gtinService;

    public Batch createBatch(BatchDto dto) {
        Gtin gtin =  gtinService.findByGtinNumber(dto.getGtinNumber());
        if(gtin == null) {
            return null;
        }
        Batch batch = new Batch();
        batch.setBatchId(dto.getBatchId());
        batch.setMrp(dto.getMrp());
        batch.setSp(dto.getSp());
        batch.setPurchasePrice(dto.getPurchasePrice());
        batch.setAvailableQuantity(dto.getAvailableQuantity());
        batch.setInwardedOn(dto.getInwardedOn());
        batch.setGtin(gtin);
        return batchRepository.save(batch);
    }


    public List<Batch> getAllBatchesForPositiveQuantityAndLatestForNonPositive() {
        List<Batch> batches = batchRepository.findAll();
        if(batches.isEmpty()) {
            return batches;
        }
        List<Batch> finalBatches = new ArrayList<>();

        Map<Long, List<Batch>> gtinToBatches = (batches).stream().collect(
                Collectors.groupingBy(batch -> batch.getGtin().getId()));

        for(Map.Entry<Long, List<Batch>> entry : gtinToBatches.entrySet()) {
            List<Batch> batchesForGtin = entry.getValue();
            List<Batch> positiveAvailableQuantityBatches = batchesForGtin.stream()
                    .filter(batch -> batch.getAvailableQuantity() > 0)
                    .collect(Collectors.toList());
            List<Batch> nonPositiveAvailableQuantityBatches = batchesForGtin.stream()
                    .filter(batch -> batch.getAvailableQuantity() <= 0)
                    .collect(Collectors.toList());
            sortBatchesBasedOnInwardedOn(positiveAvailableQuantityBatches);
            sortBatchesBasedOnInwardedOn(nonPositiveAvailableQuantityBatches);
            finalBatches.addAll(positiveAvailableQuantityBatches);
            if(!nonPositiveAvailableQuantityBatches.isEmpty()) {
                finalBatches.add(nonPositiveAvailableQuantityBatches.get(nonPositiveAvailableQuantityBatches.size() - 1));
            }
        }

        return finalBatches;
    }

    private static void sortBatchesBasedOnInwardedOn(List<Batch> batches) {
        Collections.sort(batches, new Comparator<Batch>() {
            @Override
            public int compare(Batch o1, Batch o2) {
                return o1.getInwardedOn().compareTo(o2.getInwardedOn());
            }
        });
    }
}
