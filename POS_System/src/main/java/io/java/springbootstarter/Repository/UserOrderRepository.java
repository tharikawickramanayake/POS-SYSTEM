package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder,Long>{

}
