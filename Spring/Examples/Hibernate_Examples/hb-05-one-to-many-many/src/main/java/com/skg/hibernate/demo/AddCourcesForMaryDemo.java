package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Course;
import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;
import com.skg.hibernate.entity.Review;
import com.skg.hibernate.entity.Student;

public class AddCourcesForMaryDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// create a course
			// get the student mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCoursel = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 260@ - Game Development");

			// add student to courses
			tempCoursel.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("\nSaving the courses ...");

			session.save(tempCoursel);
			session.save(tempCourse2);

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
