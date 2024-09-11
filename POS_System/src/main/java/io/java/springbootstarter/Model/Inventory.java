package io.java.springbootstarter.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long inventory_id;
	 private int quantityAvailable;
	 private LocalDateTime lastUpdated;
	 
	 @OneToOne 
	 @JoinColumn(name = "product_id", nullable = false)
	 private Product product; // Updated to use Product entity
	 
	 public Inventory() {
		 
	 }

	public Inventory(Long inventory_id, int quantityAvailable, LocalDateTime lastUpdated, Product product) {
		super();
		this.inventory_id = inventory_id;
		this.quantityAvailable = quantityAvailable;
		this.lastUpdated = lastUpdated;
		this.product = product;
	}

	public Long getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Long inventory_id) {
		this.inventory_id = inventory_id;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
 
	 
	 
	 
}
