package com.learning.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	@RequestMapping("/processForm")
	public String processForm(
			@Valid
			@ModelAttribute("customer") Customer theCustomer,
			BindingResult bindingResult) {
		System.out.println(theCustomer.getLastName());
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		else
			return "customer-confirmation";
		
	}
	//add an initBinder... to convert trim input Strings
	//remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor s = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, s);
	}
}
