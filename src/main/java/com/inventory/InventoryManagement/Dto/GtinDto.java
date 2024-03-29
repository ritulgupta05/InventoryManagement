package com.inventory.InventoryManagement.Dto;

import com.inventory.InventoryManagement.entities.Product;
import lombok.Data;

@Data
public class GtinDto {

    private Long id;
    private String gtin;
    private Product product;
}
