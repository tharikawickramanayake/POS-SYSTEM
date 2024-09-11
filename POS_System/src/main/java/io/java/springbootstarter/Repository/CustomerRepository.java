package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
