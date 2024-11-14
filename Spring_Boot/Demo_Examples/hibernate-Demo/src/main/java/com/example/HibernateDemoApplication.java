package com.example;

import com.example.dao.AppDao;
import com.example.entity.Course;
import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao){
//		return runner-> createInstructor(appDao);
//       return runner -> findInstructorById(appDao);
//		return runner -> deleteInstructorById(appDao);
		return runner -> createInstructorWithCourses(appDao);
    }

	private void createInstructorWithCourses(AppDao appDAO) {
		Instructor instructor = new Instructor("susan@bbx.com", "Susan", "Wong");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/su", "gaming");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("Pin Ball - MasterClass");

		instructor.add(course1);
		instructor.add(course2);

		appDAO.save(instructor);
	}

	private void createInstructor(AppDao appDAO) {
		Instructor instructor = new Instructor("khwajag@.com", "Khawja", "Ghouse");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/khawja", "cooking");
		instructor.setInstructorDetail(instructorDetail);
		appDAO.save(instructor);
	}

	private void findInstructorById(AppDao appDAO) {
		Instructor instructor = appDAO.findByID(1);
		System.out.println("Found \n"+instructor+ "\n with id "+1);
	}

	private void deleteInstructorById(AppDao appDAO) {
		appDAO.deleteInstructorById(1);
		System.out.println("Deleted Instructor by id "+1);
	}

}
