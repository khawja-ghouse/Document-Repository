package com.springboot.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.dao.EmployeeDAO;
import com.springboot.demo.dao.EmployeeRepository;
import com.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

//	@Autowired
//	@Qualifier("employeeDAOJpaImpl")
//	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeRepository employeeDAO; // employeeRepository;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result = employeeDAO.findById(theId);

		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find employee Id - " + theId);
		}

		return employee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theld) {
		employeeDAO.deleteById(theld);
	}

}
