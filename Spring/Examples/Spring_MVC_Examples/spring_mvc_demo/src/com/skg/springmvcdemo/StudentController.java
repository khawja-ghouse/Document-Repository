package com.skg.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("showForm")
	public String showForm(Model model) {

		// create a new Student object
		Student student = new Student();

		// add student object to the model
		model.addAttribute("student", student);

		return "student-form";

	}

	/**
	 * Now when we do a submit from the form, then this @ModelAttribute will grab
	 * the student object data and the same will be available for us inside the
	 * controller for further processing.
	 * 
	 * @param student
	 * @return String
	 */
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {

		// log the stuedent data
		System.out.println("First Name : " + student.getFirstName());
		System.out.println("Last Name : " + student.getLastName());
		return "student-confirmation";
	}

}
