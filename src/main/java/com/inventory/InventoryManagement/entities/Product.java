package com.inventory.InventoryManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String productName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
}
