package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
