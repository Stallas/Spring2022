package com.learning.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HomeController {

	@RequestMapping("/")
	public String display() {
		return "main-menu";
	}
	
	// Read data from browser and display some content
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	@RequestMapping("/processForm")
	public String processForm() {
		return "hello";
	}
	//Add controller method to read the form data
	@RequestMapping("/processFormVersionTwo")
	public String processForm2(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");//Read request parameter from html form
		name = name.toUpperCase();//convert them to uppercase and convert them to message.
		String result = "Hey " + name;
		model.addAttribute("message", result);//finally add them to Model
		return "processModel";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processForm1(@RequestParam("studentName") String name , Model model) {
		name = name.toUpperCase();//convert them to uppercase and convert them to message.
		String result = "Hey My V3 " + name;
		model.addAttribute("message", result);//finally add them to Model
		return "processModel";
	}
}
