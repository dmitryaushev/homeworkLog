package com.luxoft.homeworkLog.util;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.ViewManager;

public class DataUtil {

	public static void createData() {
	
		List<Student> students = new ArrayList<>();
		students.add(new Student("sasha", "14", true));
		students.add(new Student("vanya", "14", false));
		students.add(new Student("tolya", "1", true));
		students.add(new Student("masha", "4", false));
		students.add(new Student("lera", "5", true));
		students.add(new Student("katya", "14", true));
		students.add(new Student("denis", "2", false));
		students.add(new Student("zera", "14", true));
		students.add(new Student("dima", "14", false));
		students.add(new Student("kolya", "2", true));
		students.add(new Student("anya", "5", false));
		ViewManager.getInstance().getStudentListUI().getTableViewer().setInput(students);
	}
}
