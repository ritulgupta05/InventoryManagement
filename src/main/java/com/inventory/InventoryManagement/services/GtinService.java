package com.inventory.InventoryManagement.services;

import com.inventory.InventoryManagement.entities.Gtin;
import com.inventory.InventoryManagement.entities.Product;
import com.inventory.InventoryManagement.repositories.GtinRepository;
import com.inventory.InventoryManagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GtinService {

    @Autowired
    private GtinRepository gtinRepository;

    @Autowired
    private ProductRepository productRepository;


    public Gtin createGtin(Gtin gtin) {
//        Product product = productRepository.findById(gtin.getProduct().getProduct_id()).orElse(null);
//        if (product == null) {
//            return null;
//        }
        return gtinRepository.save(gtin);
    }

    public List<Gtin> searchGtin(String gtin) {
        List<Gtin> gtins = gtinRepository.findAll();
        List<Gtin> finalGtins = new ArrayList<>();

        for(Gtin g : gtins) {
            if(g.getGtinNumber().contains(gtin)) { // This is simple search, we can use regex for more complex search
                finalGtins.add(g);
            }
        }
        return finalGtins;
    }

    public Gtin findByGtinNumber(String gtinNumber) {
        List<Gtin> gtins = gtinRepository.findAll();

        for(Gtin g : gtins) {
            if(g.getGtinNumber().equals(gtinNumber)) {
                return g;
            }
        }
        return null;
    }
}
