package com.skg.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.hibernate.entity.Student;

public class QueryStudentDemo {

	private static final Logger logger = LoggerFactory.getLogger(QueryStudentDemo.class);

	public static void main(String[] args) {
		// load hibernate configuration file hibernate.cfg.xml and create an instance of
		// SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {

			// get current session object
			Session currentSession = sessionFactory.getCurrentSession();
			// begin transaction
			currentSession.beginTransaction();

			// Query to get all the students...
			List<Student> students = currentSession.createQuery("from Student").list();

			// display student list
			displayStudents(students);

			// fetch students whose last name is 'Ghouse'
			List<Student> resultList = currentSession.createQuery("from Student s where s.lastName='Ghouse'").list();

			displayStudents(resultList);

			// fetch students whose first name is 'Khawja' or last name is 'Ghouse'
			List resultList2 = currentSession
					.createQuery("from Student s where s.firstName='khawja' or s.lastName='Ghouse'").getResultList();
			logger.debug("displaying students where the first name is 'Khawja' or last name is 'Ghouse'");
			displayStudents(resultList2);

			// fetch students whose email id contains 'syed'
			List<Student> resultList3 = currentSession.createQuery("from Student s where s.email like '%syed%'")
					.getResultList();
			logger.debug("displaying students where the email contains 'demo'");
			displayStudents(resultList3);

			// commit transaction
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students) {

		for (Student student : students) {
			logger.debug("" + student);
		}
	}

}
