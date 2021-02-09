package com.luxoft.homeworkLog.util;

import java.util.Arrays;
import java.util.List;

import com.luxoft.homeworkLog.model.Student;

public class DataUtil {

	public static List<Student> createData() {
	
		return Arrays.asList(
				new Student("sasha", "14", true), 
				new Student("vanya", "14", false), 
				new Student("tolya", "1", true), 
				new Student("masha", "4", false), 
				new Student("lera", "5", true), 
				new Student("katya", "14", true), 
				new Student("denis", "2", false), 
				new Student("zera", "14", true), 
				new Student("dima", "14", false), 
				new Student("kolya", "2", true),
				new Student("anya", "5", false));
	}
}
