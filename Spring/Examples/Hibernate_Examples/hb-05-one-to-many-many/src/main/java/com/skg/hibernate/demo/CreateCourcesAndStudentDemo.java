package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Course;
import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;
import com.skg.hibernate.entity.Review;
import com.skg.hibernate.entity.Student;

public class CreateCourcesAndStudentDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");

			// save the course
			System.out.println("\nSaving the course ..");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);

			// create the students
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			// save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved student:" + tempCourse.getStudents());

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
