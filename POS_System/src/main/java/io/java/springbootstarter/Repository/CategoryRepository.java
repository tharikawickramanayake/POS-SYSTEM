package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
