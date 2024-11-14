package com.khawja.restdemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khawja.restdemo.dao.EmployeeDAO;
import com.khawja.restdemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	// define fields for entityManager
	private EntityManager entityManager;

	// setup constructor injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

		// execute query and get result list
		List<Employee> employeeList = query.getResultList();

		// return the results
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		// get the employee
		Employee employee = entityManager.find(Employee.class, id);

		// return the employee
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		// save employee
		Employee updatedEmployee = entityManager.merge(employee);

		// return the employee
		return updatedEmployee;
	}

	@Override
	public void deleteById(int id) {
		// find the employee
		Employee employee = entityManager.find(Employee.class, id);

		// delete the employee
		entityManager.remove(employee);
	}

}
