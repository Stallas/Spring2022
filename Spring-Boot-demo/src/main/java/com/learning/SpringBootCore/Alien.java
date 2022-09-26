package com.learning.SpringBootCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
public class Alien {

	private int aid;
	private String aname;
	private String tech;
	// SC specifies Alien class to search for dependent Laptop objects in Container.
	@Autowired // Creates object by type.
	@Qualifier("lap") // Creates object by name. Same name to be given in Laptop class.
	private Laptop laptop;

	public Alien() {
		System.out.println("No-Args Constructor of Alien");
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public void display() {
		System.out.println("Display method");
		laptop.compile();// throws null ptr exception when @autowired isnt defined for laptop.
	}
}
