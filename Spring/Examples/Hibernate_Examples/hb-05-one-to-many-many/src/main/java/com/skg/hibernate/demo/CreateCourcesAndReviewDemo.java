package com.skg.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skg.hibernate.entity.Course;
import com.skg.hibernate.entity.Instructor;
import com.skg.hibernate.entity.InstructorDetails;
import com.skg.hibernate.entity.Review;

public class CreateCourcesAndReviewDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// begin a transaction
			System.out.println("beginning a transaction");
			session.beginTransaction();

			// create Instructor object
			int tempId = 1;
			Instructor tempInstructor = session.get(Instructor.class, tempId);

			// create some cources
			Course tempCourse = new Course("Gittar Cources !!");

			// add some reviews
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well dof"));
			tempCourse.addReview(new Review("Great course ... loved it!"));

			tempInstructor.add(tempCourse);

			session.save(tempCourse);

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
