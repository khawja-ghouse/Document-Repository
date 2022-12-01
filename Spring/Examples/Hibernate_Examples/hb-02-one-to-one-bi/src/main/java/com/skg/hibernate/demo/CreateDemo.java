package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the Java Object.

			// create Instructor object
			Instructor tempInstructor = new Instructor("Nadeem", "Khan", "KhanNaddem708@gmail");

			InstructorDetails tempInstructorDetails = new InstructorDetails("CoolCoding", "codding,Cricket");

			tempInstructor.setInstructorDetails(tempInstructorDetails);

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// save the object

			// NOTE: this will also saves the Instructor Details Object because of
			// CascadeType.ALL
			session.save(tempInstructor);
			
			// commit the transaction
			System.out.println("committing the transaction");
			session.getTransaction().commit();

			System.out.println("done !!!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
