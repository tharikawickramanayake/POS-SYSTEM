package io.java.springbootstarter.Service;
import io.java.springbootstarter.DTO.PaymentDTO;
import io.java.springbootstarter.Model.Payment;
import io.java.springbootstarter.Repository.PaymentRepository;
import io.java.springbootstarter.Repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

	@Service
	public class PaymentService {

	    @Autowired
	    private PaymentRepository paymentRepository;

	    @Autowired
	    private UserOrderRepository userOrderRepository;

	    // Create Payment
	    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
	        Payment payment = new Payment(
	                paymentDTO.getAmount(),
	                paymentDTO.getPaymentMethod(),
	                paymentDTO.getPaymentStatus(),
	                paymentDTO.getPaymentDate(),
	                paymentDTO.getOrderId()
	        );
	        paymentRepository.save(payment);
	        return mapToDTO(payment);
	    }

	    // Get Payment by ID
	    public PaymentDTO getPaymentById(Long id) {
	        Payment payment = paymentRepository.findById(id).orElseThrow();
	        return mapToDTO(payment);
	    }

	    // Get All Payments
	    public List<PaymentDTO> getAllPayments() {
	        List<Payment> payments = paymentRepository.findAll();
	        return payments.stream().map(this::mapToDTO).collect(Collectors.toList());
	    }

	    // Update Payment
	    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
	        Payment payment = paymentRepository.findById(id).orElseThrow();

	        payment.setAmount(paymentDTO.getAmount());
	        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
	        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
	        payment.setPaymentDate(paymentDTO.getPaymentDate());
	        payment.setOrderId(paymentDTO.getOrderId());

	        paymentRepository.save(payment);
	        return mapToDTO(payment);
	    }

	    // Delete Payment
	    public void deletePayment(Long id) {
	        Payment payment = paymentRepository.findById(id).orElseThrow();
	        paymentRepository.delete(payment);
	    }

	    // Helper method: Map Payment to DTO
	    private PaymentDTO mapToDTO(Payment payment) {
	        return new PaymentDTO(
	                payment.getId(),
	                payment.getAmount(),
	                payment.getPaymentMethod(),
	                payment.getPaymentStatus(),
	                payment.getPaymentDate(),
	                payment.getOrderId()
	        );
	    }
	}


