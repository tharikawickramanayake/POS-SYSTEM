package io.java.springbootstarter.Controller;
import io.java.springbootstarter.DTO.PaymentDTO;
import io.java.springbootstarter.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

	@RestController
	@RequestMapping("/api/payments")
	public class PaymentController {

	    @Autowired
	    private PaymentService paymentService;

	    // Create Payment
	    @PostMapping
	    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
	        PaymentDTO createdPayment = paymentService.createPayment(paymentDTO);
	        return ResponseEntity.ok(createdPayment);
	    }

	    // Get Payment by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
	        PaymentDTO paymentDTO = paymentService.getPaymentById(id);
	        return ResponseEntity.ok(paymentDTO);
	    }

	    // Get All Payments
	    @GetMapping
	    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
	        List<PaymentDTO> payments = paymentService.getAllPayments();
	        return ResponseEntity.ok(payments);
	    }

	    // Update Payment
	    @PutMapping("/{id}")
	    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
	        PaymentDTO updatedPayment = paymentService.updatePayment(id, paymentDTO);
	        return ResponseEntity.ok(updatedPayment);
	    }

	    // Delete Payment
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
	        paymentService.deletePayment(id);
	        return ResponseEntity.noContent().build();
	    }
	}


