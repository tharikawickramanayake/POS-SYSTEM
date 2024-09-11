package io.java.springbootstarter.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;
    private String description;
    private double price;
    private String sku;
    private int quantityInStock;
    
    @ManyToOne
    @JoinColumn(name = "category_id" , nullable = false)
    private Category category;  // Updated to use Category entity

    private LocalDateTime createdDate;
    private LocalDateTime lastUpdated;
    
    // Constructors
    public Product() {}

    public Product(String name, String description, double price, String sku, int quantityInStock,
                   Category category, LocalDateTime createdDate, LocalDateTime lastUpdated) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sku = sku;
        this.quantityInStock = quantityInStock;
        this.category = category;  // Changed to use Category entity directly
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
