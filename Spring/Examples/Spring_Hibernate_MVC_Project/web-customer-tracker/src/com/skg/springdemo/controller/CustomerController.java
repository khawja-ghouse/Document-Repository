package com.skg.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skg.springdemo.dao.CustomerDAOImpl;
import com.skg.springdemo.entity.Customer;
import com.skg.springdemo.services.CustomerDAO;
import com.skg.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject CustomerDAOImpl
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		System.out.println("Inside List Customer !!!");

		// Get customer list from the service.
		List<Customer> customerList = customerService.getCustomers();

		// Add the list to model
		theModel.addAttribute("customers", customerList);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// Save the customer
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		// get the customer from the database
		customerService.deleteCustomer(theId);
		// send over to our form
		return "redirect:/customer/list";
	}
	
}
