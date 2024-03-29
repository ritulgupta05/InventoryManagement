package com.inventory.InventoryManagement.controllers;
import com.inventory.InventoryManagement.entities.Gtin;
import com.inventory.InventoryManagement.services.GtinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gtins")
public class GtinController {
    @Autowired
    private GtinService gtinService;

    // API to get GTINs by GTIN
    @GetMapping("/search/{gtin}")
    public ResponseEntity<?> getGtins(@PathVariable String gtin) {
        List<Gtin> gtins = gtinService.searchGtin(gtin);
        if(gtins.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No GTIN found");
        }
        return ResponseEntity.ok(gtins);
    }

    // API to create GTIN
    @PostMapping()
    public ResponseEntity<?> createGtin(@RequestBody Gtin gtin) {
        Gtin gtin1 = gtinService.createGtin(gtin);
        if (gtin1 == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Gtin");
        }
        return ResponseEntity.ok(gtin1);
    }

}
