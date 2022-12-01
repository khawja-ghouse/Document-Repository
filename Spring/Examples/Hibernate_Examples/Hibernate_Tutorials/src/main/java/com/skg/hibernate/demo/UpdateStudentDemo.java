package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Student;

public class UpdateStudentDemo {

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

			System.out.println("Student Before update :" + student);

			System.out.println("....Update Student....");

			student.setFirstName("abcdcefg");

			// save the student object
			System.out.println("Update the student object");
			session.save(student);

			Student UpdatedStudent = session.get(Student.class, studentId);

			System.out.println("Student After Update :" + UpdatedStudent);

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
