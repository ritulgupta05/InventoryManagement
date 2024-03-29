package com.inventory.InventoryManagement.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class BatchDto {

    private Long batchId;

    private Integer mrp;
    private Integer sp;
    private Integer purchasePrice;
    private Integer availableQuantity;
    private Date inwardedOn;
    private String gtinNumber;
}
