package com.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// By default on start Entity Manager bean would have created.
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the Employee
		Employee employee = currentSession.get(Employee.class, theId);

		// return the Employee
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Get the Employee
		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int theld) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theld);

		theQuery.executeUpdate();

	}

}
