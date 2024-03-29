package com.inventory.InventoryManagement.repositories;

import com.inventory.InventoryManagement.entities.Gtin;
import com.inventory.InventoryManagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Long> {

}
