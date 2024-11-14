package com.khawja.restdemo.rest;

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

import com.khawja.restdemo.entity.Employee;
import com.khawja.restdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// expose end point "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("employee not found with id " + employeeId);
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		// forcibly set the employee id to 0 just in case they pass
		// an id in the request JSON to force save of a new employee
		// instead of updating an existing one.
		employee.setId(0);

		Employee savedEmployee = employeeService.save(employee);

		return savedEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.save(employee);

		return savedEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("the employee you are trying to delete does not exist with id" + employeeId);
		}

		employeeService.deleteById(employeeId);
		return "Deleted Employee with id " + employeeId;
	}
}
