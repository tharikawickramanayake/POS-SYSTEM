package io.java.springbootstarter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.java.springbootstarter.DTO.CustomerDTO;
import io.java.springbootstarter.Service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // GET: Retrieve all customers
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    // GET: Retrieve a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomer(id);
        if (customerDTO != null) {
            return ResponseEntity.ok(customerDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST: Add a new customer
    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO newCustomer = customerService.addCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    // PUT: Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
