package io.java.springbootstarter.DTO;

import java.time.LocalDateTime;

public class CategoryDTO {

	    private Long category_id;
	    private String name;
	    private String description;
	    private LocalDateTime createdDate;
	    

	    public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		// Constructors, getters, and setters
	    public CategoryDTO() {}

	    public Long getCategory_id() {
	        return category_id;
	    }

	    public void setCategory_id(Long category_id) {
	        this.category_id = category_id;
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
	}


