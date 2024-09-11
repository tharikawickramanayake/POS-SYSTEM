package io.java.springbootstarter.Model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	private String name;
	private String description;
	private LocalDateTime createdDate;
	
    @OneToMany(mappedBy = "category")
	private Set<Product> products;
    
    public Category() {
    	
    }

	public Category(String name, String description, LocalDateTime createdDate,
			Set<Product> products) {
		super();
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.products = products;
	}

	public Long getCategory_id() {
		return category_id;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void setCategory_id(Long category_id2) {
		// TODO Auto-generated method stub
		
	}

 
    
    
	
	
}
