package com.luxoft.homeworkLog.model;

import java.util.ArrayList;
import java.util.List;

public class StateModel{
	
	private List<Student> students = new ArrayList<>();
		
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void deleteStudents(List<Student> deletedStudents) {
		deletedStudents.forEach(student -> students.remove(student));
	}
}
