package com.luxoft.homeworkLog.service;

public class ValidationService {
	
	public static void validateInput(String name, String group) {
		
		if (name.isEmpty() || group.isEmpty()) {
			throw new IllegalArgumentException("All fields must be filled");
		}
		
		String nameFieldRegexp = "^[\\p{L} ]+$";
		String groupFieldRegexp = "^[1-9]\\d*$";
		
		if (!name.matches(nameFieldRegexp)) {
			throw new IllegalArgumentException("Wrong input");
		}
		if (!group.matches(groupFieldRegexp)) {
			throw new IllegalArgumentException("Wrong input");
		}
	}

}
