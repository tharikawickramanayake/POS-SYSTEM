package io.java.springbootstarter.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootstarter.DTO.CategoryDTO;
import io.java.springbootstarter.Model.Category;
import io.java.springbootstarter.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    // Convert Category entity to CategoryDTO
    	private CategoryDTO convertToDto(Category category) {
    	    CategoryDTO dto = new CategoryDTO();
    	    dto.setCategory_id(category.getCategory_id());  // Set ID from entity
    	    dto.setName(category.getName());                // Set Name from entity
    	    dto.setDescription(category.getDescription());
    	    dto.setCreatedDate(category.getCreatedDate());// Set Description from entity
    	    return dto;
    	}

    
    
    // Convert CategoryDTO to Category entity
    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_id(categoryDTO.getCategory_id()); // Fix: Set ID (if updating)
        category.setName(categoryDTO.getName());              // Fix: Set Name
        category.setDescription(categoryDTO.getDescription()); 
        category.setCreatedDate(categoryDTO.getCreatedDate());// Fix: Set Description
        // Optionally set createdDate and other fields if necessary
        return category;
    }
    
    // Get all categories
    public List<CategoryDTO> getAllCategory(){
        return categoryRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());    
    }
    
    // Get a single category by ID
    public CategoryDTO getCategory(Long category_id){
        return categoryRepository.findById(category_id).map(this::convertToDto).orElse(null);
    }
    
    // Add a new category
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = convertToEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return convertToDto(savedCategory);
    }
    
    // Update an existing category
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            Category updatedCategory = categoryRepository.save(category);
            return convertToDto(updatedCategory);
        }).orElse(null);
    }
    
    // Delete a category
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
