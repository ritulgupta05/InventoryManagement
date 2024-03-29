package com.inventory.InventoryManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gtin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gtinNumber;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
