package io.java.springbootstarter.DTO;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

public class ProductDTO {

	private Long product_id;
	private String name;
	private String description;
	private double  price;
	private String sku;
	private int quantityInStock;
	private Long categoryId;
	private LocalDateTime createdDate;
	private LocalDateTime lastUpdated;
	private CategoryDTO category;
	
	
	public CategoryDTO getCategory() {
		return category;
	}
	

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
