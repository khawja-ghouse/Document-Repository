package com.springboot.demo.rest;

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

import com.springboot.demo.entity.Employee;
import com.springboot.demo.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeServices employeeServices;

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeServices.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = employeeServices.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theEmployee.setId(0);
		employeeServices.save(theEmployee);
		return theEmployee;
	}

	// add mapping for PUT /employees - update existing employee

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeServices.save(theEmployee);
		return theEmployee;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = employeeServices.findById(employeeId);
		// throw exception if null
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		employeeServices.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}
}
