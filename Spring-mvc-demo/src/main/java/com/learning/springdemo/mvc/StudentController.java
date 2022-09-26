package com.learning.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/")
	public String display() {
		System.out.println("inside student display method");
		return "main-menu";
	}
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		System.out.println("inside student showform");
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("Student is: "+ theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
