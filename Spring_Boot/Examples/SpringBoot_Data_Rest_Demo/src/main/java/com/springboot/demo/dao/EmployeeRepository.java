package com.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// All the methods are available by default
}
