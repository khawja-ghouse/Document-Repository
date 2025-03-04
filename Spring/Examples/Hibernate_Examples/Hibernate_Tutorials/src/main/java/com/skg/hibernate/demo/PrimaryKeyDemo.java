package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
			Student student1 = new Student("Khawja", "Ghouse", "ghouse@gmail.com");
			Student student2 = new Student("Nadeem", "Syed", "nSyed@gmail.com");
			Student student3 = new Student("Syed", "Ghouse", "SyedGhouse@gmail.com");

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// save the student object
			System.out.println("saving the student object");
			session.save(student2);
			session.save(student1);
			session.save(student3);

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
