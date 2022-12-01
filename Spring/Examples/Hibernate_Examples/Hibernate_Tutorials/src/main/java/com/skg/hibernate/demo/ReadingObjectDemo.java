package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Student;

public class ReadingObjectDemo {
	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the Java Object.

			// create student object
			System.out.println("creating student object");
			Student tempStudent = new Student("Danish", "SK", "danish23@gmail.com");

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student object");
			session.save(tempStudent);

			// commit the transaction
			System.out.println("committing the transaction");
			session.getTransaction().commit();
			
			System.out.println("student saved!! assigned id : " + tempStudent.getId());

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student retrievedStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("retrieved student : " + retrievedStudent);
			session.getTransaction().commit();

			

			System.out.println("done !!!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}
	}
}
