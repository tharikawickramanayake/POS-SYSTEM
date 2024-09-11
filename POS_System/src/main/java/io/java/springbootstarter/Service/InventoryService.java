package io.java.springbootstarter.Service;

import io.java.springbootstarter.DTO.CustomerDTO;
import io.java.springbootstarter.DTO.InventoryDTO;
import io.java.springbootstarter.DTO.ProductDTO;
import io.java.springbootstarter.Model.Customer;
import io.java.springbootstarter.Model.Inventory;
import io.java.springbootstarter.Model.Product;
import io.java.springbootstarter.Repository.InventoryRepository;
import io.java.springbootstarter.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Convert Inventory Entity to DTO
    private InventoryDTO convertToDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setInventory_id(inventory.getInventory_id());
        inventoryDTO.setQuantityAvailable(inventory.getQuantityAvailable());
        inventoryDTO.setLastUpdated(inventory.getLastUpdated());

        // Convert Product entity to ProductDTO
        ProductDTO productDTO = new ProductDTO();
        Product product = inventory.getProduct();
        productDTO.setProduct_id(product.getProduct_id());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setSku(product.getSku());
        productDTO.setQuantityInStock(product.getQuantityInStock());
        productDTO.setCreatedDate(product.getCreatedDate());

        inventoryDTO.setProduct(productDTO);
        return inventoryDTO;
    }

    // Convert DTO to Inventory Entity
    private Inventory convertToEntity(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setInventory_id(inventoryDTO.getInventory_id());
        inventory.setQuantityAvailable(inventoryDTO.getQuantityAvailable());
        inventory.setLastUpdated(inventoryDTO.getLastUpdated());

        // Fetch the Product entity from the database
        if (inventoryDTO.getProduct() != null) {
            Optional<Product> product = productRepository.findById(inventoryDTO.getProduct().getProduct_id());
            if (product.isPresent()) {
                inventory.setProduct(product.get());
            } else {
                // Handle the case where the product is not found
                throw new RuntimeException("Product not found");
            }
        }

        return inventory;
    }

    // Get all Inventory records
    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get a single Inventory by ID
    public InventoryDTO getInventoryById(Long id) {
        return inventoryRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    // Add a new Inventory
	public InventoryDTO addInventory(InventoryDTO inventoryDTO) {
		 Inventory inventory = convertToEntity(inventoryDTO);//takes the customertDTO object and converts it into a customer entity.
		 Inventory savedInventory = inventoryRepository.save(inventory); //Save the Customer to the Database
		 return convertToDTO(savedInventory);//Convert the Saved Customer Back to CustomerDTO
	}
	

    // Update an existing Inventory
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);

        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            inventory.setQuantityAvailable(inventoryDTO.getQuantityAvailable());
            inventory.setLastUpdated(inventoryDTO.getLastUpdated());

            // Fetch and set the Product entity if provided in DTO
            if (inventoryDTO.getProduct() != null) {
                Optional<Product> product = productRepository.findById(inventoryDTO.getProduct().getProduct_id());
                if (product.isPresent()) {
                    inventory.setProduct(product.get());
                } else {
                    // Handle the case where the product is not found
                    throw new RuntimeException("Product not found");
                }
            }

            Inventory updatedInventory = inventoryRepository.save(inventory);
            return convertToDTO(updatedInventory);
        }

        return null;
    }

    // Delete an Inventory
    public void deleteInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new RuntimeException("Inventory item not found");
        }
        inventoryRepository.deleteById(id);
    }
}
