package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the Java Object.
			int studentId = 1;

			session.beginTransaction();

			// create student object
			System.out.println("Get student object");

			// begin a transaction
			System.out.println("beginning a transaction");

			Student student = session.get(Student.class, studentId);

			// Delete Student
			System.out.println("Deleting Student ........");
			session.delete(student);

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
