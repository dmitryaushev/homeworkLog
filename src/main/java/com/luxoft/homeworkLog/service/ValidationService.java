package com.luxoft.homeworkLog.service;

public class ValidationService {
	
	public static void validateInput(String name, String group) {
		
		if (name.isEmpty() || group.isEmpty()) {
			throw new IllegalArgumentException("All fields must be filled");
		}
	}
}
