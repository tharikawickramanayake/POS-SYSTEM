package io.java.springbootstarter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.java.springbootstarter.DTO.CategoryDTO;
import io.java.springbootstarter.Service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    // Get a single category by ID
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Long id) {
        CategoryDTO category = categoryService.getCategory(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    // Create a new category
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO addCategory = categoryService.addCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCategory);
    }

    // Update an existing category
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.notFound().build();
    }

    // Delete a category
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
