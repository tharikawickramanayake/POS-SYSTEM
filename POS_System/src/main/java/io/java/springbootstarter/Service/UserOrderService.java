package io.java.springbootstarter.Service;
import io.java.springbootstarter.DTO.UserOrderDTO;
import io.java.springbootstarter.Model.*;
import io.java.springbootstarter.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

	@Service
	public class UserOrderService {

	    @Autowired
	    private UserOrderRepository userOrderRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private PaymentRepository paymentRepository;

	    // Create an Order
	    public UserOrderDTO createOrder(UserOrderDTO orderDTO) {
	        // Fetch related entities
	        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElseThrow();
	        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow();
	        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());

	        // Create and Save UserOrder
	        UserOrder order = new UserOrder(
	                orderDTO.getOrderDate(),
	                orderDTO.getStatus(),
	                orderDTO.getTotalAmount(),
	                customer,
	                user,
	                paymentRepository.findById(orderDTO.getPaymentId()).orElse(null),
	                products
	        );
	        order.setCreatedDate(orderDTO.getCreatedDate());
	        order.setLastUpdated(orderDTO.getLastUpdated());
	        userOrderRepository.save(order);

	        // Map saved order back to DTO
	        return mapToDTO(order);
	    }

	    // Get Order by ID
	    public UserOrderDTO getOrderById(Long id) {
	        UserOrder order = userOrderRepository.findById(id).orElseThrow();
	        return mapToDTO(order);
	    }

	    // Get All Orders
	    public List<UserOrderDTO> getAllOrders() {
	        List<UserOrder> orders = userOrderRepository.findAll();
	        return orders.stream().map(this::mapToDTO).collect(Collectors.toList());
	    }

	    // Update an Order
	    public UserOrderDTO updateOrder(Long id, UserOrderDTO orderDTO) {
	        UserOrder order = userOrderRepository.findById(id).orElseThrow();

	        // Fetch related entities
	        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElseThrow();
	        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow();
	        List<Product> products = productRepository.findAllById(orderDTO.getProductIds());

	        // Update fields
	        order.setOrderDate(orderDTO.getOrderDate());
	        order.setStatus(orderDTO.getStatus());
	        order.setTotalAmount(orderDTO.getTotalAmount());
	        order.setCustomer(customer);
	        order.setUser(user);
	        order.setPayment(paymentRepository.findById(orderDTO.getPaymentId()).orElse(null));
	        order.setProducts(products);
	        order.setLastUpdated(orderDTO.getLastUpdated());

	        userOrderRepository.save(order);
	        return mapToDTO(order);
	    }

	    // Delete an Order
	    public void deleteOrder(Long id) {
	        UserOrder order = userOrderRepository.findById(id).orElseThrow();
	        userOrderRepository.delete(order);
	    }

	 // Helper Method: Map UserOrder entity to DTO
	    private UserOrderDTO mapToDTO(UserOrder order) {
	        return new UserOrderDTO(
	            order.getId(),
	            order.getOrderDate(),
	            order.getStatus(),
	            order.getTotalAmount(),
	            order.getCustomer() != null ? order.getCustomer().getId() : null, // Null check for customer
	            order.getUser() != null ? order.getUser().getUserId() : null,         // Null check for user
	            order.getPayment() != null ? order.getPayment().getId() : null,   // Null check for payment
	            order.getProducts() != null ? order.getProducts().stream()
	                                         .map(Product::getProduct_id)
	                                         .collect(Collectors.toList()) : null, // Null check for products
	            order.getCreatedDate(),
	            order.getLastUpdated()
	        );
	    }

	    }
	


