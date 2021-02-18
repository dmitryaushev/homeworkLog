package com.luxoft.homeworkLog.model;

public class Student {

	private String name;
	private String group;
	private Boolean isTaskDone;
	
	public Student(String name, String group, Boolean isTaskDone) {
		this.name = name;
		this.group = group;
		this.isTaskDone = isTaskDone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Boolean isTaskDone() {
		return isTaskDone;
	}
	public void setTaskDone(Boolean isTaskDone) {
		this.isTaskDone = isTaskDone;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
}
