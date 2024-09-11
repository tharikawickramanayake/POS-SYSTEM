package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
