package com.khawja.restdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khawja.restdemo.dao.EmployeeDAO;
import com.khawja.restdemo.entity.Employee;
import com.khawja.restdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl() {

	}

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}