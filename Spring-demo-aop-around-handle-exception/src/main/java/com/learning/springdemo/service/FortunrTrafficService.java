package com.learning.springdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortunrTrafficService {
	
	public String getFortune() {
		
		//Simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expected heavy traffic";
	}

	public String getFortune(boolean flag) {
		
		if(flag) {
			throw new RuntimeException("Major accident ! Highway is closed");
		}
		return getFortune();
	}
}
