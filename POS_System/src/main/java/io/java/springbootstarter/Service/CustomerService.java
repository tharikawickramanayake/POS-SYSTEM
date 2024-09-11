package io.java.springbootstarter.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootstarter.DTO.CustomerDTO;
import io.java.springbootstarter.Model.Customer;
import io.java.springbootstarter.Model.Product;
import io.java.springbootstarter.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerReppository;
	
	//Method to convert Customer Entity to CustomerDTO
	private CustomerDTO convertToDto(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		 dto.setId(customer.getId());
	        dto.setFirstName(customer.getFirstName());
	        dto.setLastName(customer.getLastName());
	        dto.setEmail(customer.getEmail());
	        dto.setPhoneNumber(customer.getPhoneNumber());
	        dto.setAddress(customer.getAddress());
	        dto.setDateOfBirth(customer.getDateOfBirth());
	        dto.setCreatedDate(customer.getCreatedDate());
	        dto.setLastUpdated(customer.getLastUpdated());
	        return dto;
	}
	
	//Method to convert CustomerDTO to Customer Entity
	private Customer convertToEntity(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAddress(dto.getAddress());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setCreatedDate(dto.getCreatedDate());
        customer.setLastUpdated(dto.getLastUpdated());
		return customer;
	}
	
	public List<CustomerDTO> getAllCustomer(){
		return customerReppository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	public CustomerDTO getCustomer(Long customer_id) {
		return customerReppository.findById(customer_id).map(this::convertToDto).orElse(null);
	}
	
	public CustomerDTO addCustomer(CustomerDTO customerDTO) {
		 Customer customer = convertToEntity(customerDTO);//takes the customertDTO object and converts it into a customer entity.
		 Customer savedCustomer = customerReppository.save(customer); //Save the Customer to the Database
		 return convertToDto(savedCustomer);//Convert the Saved Customer Back to CustomerDTO
	}
	
		// Method to update an existing customer
	    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
	        return customerReppository.findById(id).map(customer -> {
	            customer.setFirstName(customerDTO.getFirstName());
	            customer.setLastName(customerDTO.getLastName());
	            customer.setEmail(customerDTO.getEmail());
	            customer.setPhoneNumber(customerDTO.getPhoneNumber());
	            customer.setAddress(customerDTO.getAddress());
	            customer.setDateOfBirth(customerDTO.getDateOfBirth());

	            Customer updatedCustomer = customerReppository.save(customer);
	            return convertToDto(updatedCustomer);
	        }).orElse(null);
	    }
	    
	    public void deleteCustomer(Long id) {
	        if (customerReppository.existsById(id)) {
	        	customerReppository.deleteById(id);
	        } else {
	            // Handle the case where the customer doesn't exist (optional)
	            throw new RuntimeException("Customer with ID " + id + " not found");
	        }
	    }

	
	
	
}
