package io.java.springbootstarter.Controller;

import io.java.springbootstarter.DTO.UserOrderDTO;
import io.java.springbootstarter.Service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;	 

	@RestController
	@RequestMapping("/api/orders")
	public class UserOrderController {

	    @Autowired
	    private UserOrderService userOrderService;

	    // Create an Order
	    @PostMapping
	    public ResponseEntity<UserOrderDTO> createOrder(@RequestBody UserOrderDTO userOrderDTO) {
	        UserOrderDTO createdOrder = userOrderService.createOrder(userOrderDTO);
	        return ResponseEntity.ok(createdOrder);
	    }

	    // Get Order by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<UserOrderDTO> getOrderById(@PathVariable Long id) {
	        UserOrderDTO orderDTO = userOrderService.getOrderById(id);
	        return ResponseEntity.ok(orderDTO);
	    }

	    // Get All Orders
	    @GetMapping
	    public ResponseEntity<List<UserOrderDTO>> getAllOrders() {
	        List<UserOrderDTO> orders = userOrderService.getAllOrders();
	        return ResponseEntity.ok(orders);
	    }

	    // Update an Order
	    @PutMapping("/{id}")
	    public ResponseEntity<UserOrderDTO> updateOrder(@PathVariable Long id, @RequestBody UserOrderDTO userOrderDTO) {
	        UserOrderDTO updatedOrder = userOrderService.updateOrder(id, userOrderDTO);
	        return ResponseEntity.ok(updatedOrder);
	    }

	    // Delete an Order
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	        userOrderService.deleteOrder(id);
	        return ResponseEntity.noContent().build();
	    }
	}


