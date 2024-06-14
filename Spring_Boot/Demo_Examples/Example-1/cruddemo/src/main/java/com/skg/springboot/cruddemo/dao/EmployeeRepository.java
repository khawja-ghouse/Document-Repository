package com.skg.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skg.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
