package com.khwaja.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			findAll(studentDAO);
//			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("khwaja", "ghouse", "ghouseKhwaja@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved Student with id " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1 : " + student);
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("Nadeem");
		studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

}
