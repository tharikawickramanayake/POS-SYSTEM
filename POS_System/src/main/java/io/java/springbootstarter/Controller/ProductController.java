package io.java.springbootstarter.Controller;
import io.java.springbootstarter.DTO.ProductDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.java.springbootstarter.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
	
	 @GetMapping("product/{id}")
	    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
	        ProductDTO productDTO = productService.getProduct(id);
	        return productDTO != null ? ResponseEntity.ok(productDTO) : ResponseEntity.notFound().build();
	    }
	 
	  @PostMapping("/product")
	    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
	        return ResponseEntity.ok(productService.createProduct(productDTO));
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
	        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
	        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
	    }
	  
	  @DeleteMapping("produuct/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }
}
