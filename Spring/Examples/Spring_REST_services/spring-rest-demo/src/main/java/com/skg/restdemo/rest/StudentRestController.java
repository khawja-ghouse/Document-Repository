package com.skg.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skg.restdemo.entity.Student;
import com.skg.restdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	List<Student> theStudents = null;

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}

	// define endpoint for "/students" - return list of students

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// Just index into the list ... keep it simple

		//
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return theStudents.get(studentId);
	}



}
