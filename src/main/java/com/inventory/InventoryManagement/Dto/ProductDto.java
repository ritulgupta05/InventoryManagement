package com.inventory.InventoryManagement.Dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Long product_id;
    private String productName;
    private Date createdOn;
}
