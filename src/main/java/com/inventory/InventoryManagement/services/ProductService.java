package com.inventory.InventoryManagement.services;

import com.inventory.InventoryManagement.entities.Product;
import com.inventory.InventoryManagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        if(isValid(product)){
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    private Boolean isValid(Product product){
        return product.getProductName() != null;
    }
}
