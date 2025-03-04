package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerServiceImpl customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		// Just index into the list ... keep it simple

		// If customerId is not found in the database then it returns null
		// For null Objects Jackson returns empty body

		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			System.out.println("Customer is null");
			throw new CustomerNotFoundException("Customer Id not found -" + customerId);
		}
		return customer;
	}

	// add mapping for POST /customers - add new customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		customer.setId(0);
		customerService.saveCustomer(customer);

		return customer;
		// Question: when the customer is returned the customer is coming back with auto
		// generated ID. how ?
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
		// Question: when the customer is returned the customer is coming back with auto
		// generated ID. how ?
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		// Just index into the list ... keep it simple

		// If customerId is not found in the database then it returns null
		// For null Objects Jackson returns empty body

		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			System.out.println("Customer is null");
			throw new CustomerNotFoundException("Customer Id not found -" + customerId);
		}
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer Id - " + customerId;
	}

}
