package com.khawja.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khawja.demo.model.Student;
import com.khawja.demo.model.StudentErrorResponse;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Anupam", "Acharya"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

	
}
