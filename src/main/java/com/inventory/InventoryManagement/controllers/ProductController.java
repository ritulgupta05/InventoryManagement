package com.inventory.InventoryManagement.controllers;

import com.inventory.InventoryManagement.entities.Product;
import com.inventory.InventoryManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product product1 = productService.createProduct(product);
        if(product1 == null) {
            return ResponseEntity.status(500).body("Failed to create product");
        }
        return ResponseEntity.ok(product1);

    }
}

