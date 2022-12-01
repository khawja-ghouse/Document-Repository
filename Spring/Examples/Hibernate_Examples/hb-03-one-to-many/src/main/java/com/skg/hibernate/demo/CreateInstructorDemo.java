package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Course;
import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the Java Object.

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// save the object

			// NOTE: this will also saves the Instructor Details Object because of
			// CascadeType.ALL

			// create Instructor object
			int tempId = 1;
			Instructor tempInstructor = session.get(Instructor.class, tempId);

			// create some cources
			Course course1 = new Course("Gittar Cources !!");
			Course course2 = new Course("The Pin ball Master class !!");

			tempInstructor.add(course2);
			tempInstructor.add(course1);

			session.save(course1);
			session.save(course2);

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
