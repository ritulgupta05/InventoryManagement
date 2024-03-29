package com.inventory.InventoryManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long batchId;

    private Integer mrp;
    private Integer sp;
    private Integer purchasePrice;
    private Integer availableQuantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date inwardedOn;

    @ManyToOne
    @JoinColumn(name = "gtin")
    private Gtin gtin;
}
