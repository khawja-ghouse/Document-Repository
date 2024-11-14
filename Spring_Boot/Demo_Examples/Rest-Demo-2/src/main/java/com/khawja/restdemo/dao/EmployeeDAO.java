package com.khawja.restdemo.dao;

import java.util.List;

import com.khawja.restdemo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee employee);

	void deleteById(int id);
}
