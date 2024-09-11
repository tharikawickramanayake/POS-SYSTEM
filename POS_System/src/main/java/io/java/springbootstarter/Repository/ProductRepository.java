package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
