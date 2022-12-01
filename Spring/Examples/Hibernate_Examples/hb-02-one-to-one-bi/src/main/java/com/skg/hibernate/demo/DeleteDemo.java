package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the Java Object.
			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// Get the instructor by primary key
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Found Instructor ::" + tempInstructor);

			// delete the instructor

			if (tempInstructor != null) {
				System.out.println("Deleting ::" + tempInstructor);
				
				// NOTE: This will also delete associated "details" object 
				// because of CascadeType.ALL
				session.delete(tempInstructor);
			}

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
