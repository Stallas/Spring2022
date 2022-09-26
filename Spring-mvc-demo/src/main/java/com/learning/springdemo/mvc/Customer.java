package com.learning.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.learning.springdemo.mvc.validation.CourseCode;


public class Customer {

	private String firstName;
	
	@NotNull(message="is required") 
	@Size(min=1, message = "is Required")
	private String lastName;
	
	@Min(value=0, message="Should be greater than or equal to 0")
	@Max(value=10, message="Should be less than or equal to 10")  
	private Integer freePasses;// int -> Integer ()
	
	@Pattern(regexp = "^[a-zA-Z0-5]{5}",message="Should be only 5 characters/digits")
	private String postalCode;
	
	//@CourseCode(value="LUV",message="must start with LUV")
	@CourseCode
	private String courseCode;//any field irrespective of annotation

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
}
