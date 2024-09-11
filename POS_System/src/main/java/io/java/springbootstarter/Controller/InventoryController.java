package io.java.springbootstarter.Controller;

import io.java.springbootstarter.DTO.InventoryDTO;
import io.java.springbootstarter.Service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Get all Inventory items
    @GetMapping
    public ResponseEntity<List<InventoryDTO>> getAllInventory() {
        List<InventoryDTO> inventoryList = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }

    // Get Inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Long id) {
        InventoryDTO inventoryDTO = inventoryService.getInventoryById(id);
        if (inventoryDTO != null) {
            return new ResponseEntity<>(inventoryDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add new Inventory
    @PostMapping
    public ResponseEntity<InventoryDTO> addInventory(@RequestBody InventoryDTO inventoryDTO) {
        try {
            InventoryDTO savedInventory = inventoryService.addInventory(inventoryDTO);
            return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Handle cases where product ID is null or invalid
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            // Handle cases where the product is not found
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing Inventory
    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO) {
        try {
            InventoryDTO updatedInventory = inventoryService.updateInventory(id, inventoryDTO);
            if (updatedInventory != null) {
                return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            // Handle cases where product ID is null or invalid
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            // Handle cases where the product is not found
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Inventory by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        try {
            inventoryService.deleteInventory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            // Handle cases where the inventory item does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
