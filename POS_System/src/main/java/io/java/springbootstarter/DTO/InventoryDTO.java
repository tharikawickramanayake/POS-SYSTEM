package io.java.springbootstarter.DTO;

import java.time.LocalDateTime;

public class InventoryDTO {

	    private Long inventory_id;
	    private int quantityAvailable;
	    private LocalDateTime lastUpdated;
	    private ProductDTO product;
	    
	    
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
		public ProductDTO getProduct() {
			return product;
		}
		public void setProduct(ProductDTO product) {
			this.product = product;
		} 
	    
	    
}
