package io.java.springbootstarter.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootstarter.DTO.ProductDTO;
import io.java.springbootstarter.Model.Category;
import io.java.springbootstarter.Model.Product;
import io.java.springbootstarter.Repository.CategoryRepository;
import io.java.springbootstarter.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    // Method to convert Product entity to ProductDTO
    private ProductDTO convertToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setSku(product.getSku());
        dto.setQuantityInStock(product.getQuantityInStock());
        
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getCategory_id());
        }
        
        dto.setCreatedDate(product.getCreatedDate());
        dto.setLastUpdated(product.getLastUpdated());
        return dto;
    }

    // Method to convert ProductDTO to Product entity
    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSku(dto.getSku());
        product.setQuantityInStock(dto.getQuantityInStock());
        product.setCreatedDate(dto.getCreatedDate());
        product.setLastUpdated(dto.getLastUpdated());

        // Set category
        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                                                  .orElse(null);
            product.setCategory(category);
        }

        return product;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long product_id) {
        return productRepository.findById(product_id).map(this::convertToDto).orElse(null);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setSku(productDTO.getSku());
            product.setQuantityInStock(productDTO.getQuantityInStock());

            if (productDTO.getCategoryId() != null) {
                Category category = categoryRepository.findById(productDTO.getCategoryId())
                                                      .orElse(null);
                product.setCategory(category);
            }

            Product updatedProduct = productRepository.save(product);
            return convertToDto(updatedProduct);
        }).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
