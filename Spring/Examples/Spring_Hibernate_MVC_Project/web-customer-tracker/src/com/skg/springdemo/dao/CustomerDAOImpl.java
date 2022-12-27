package com.skg.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skg.springdemo.entity.Customer;
import com.skg.springdemo.services.CustomerDAO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the Session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// Remove the transaction from here as we have maintained on the service layer.
	public List<Customer> getCustomers() {

		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customersList = query.getResultList();
		// return the result

		return customersList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// save for a new record or update for existing data.
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Query deleteQuery = session.createQuery("delete from Customer where id=:customerId");
		deleteQuery.setParameter("customerId", theId);
		deleteQuery.executeUpdate();
	}

}
