package com.luxoft.homeworkLog.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.ViewManager;

public class LoadUtil {

	public static void loadList() {
		String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
		String json = "";
		List<Student> students;
		try {
			json = Files.readString(Paths.get(path));			
			Type listType = new TypeToken<List<Student>>() {}.getType();			
			students = new Gson().fromJson(json, listType);
			
			ModelManager.getInstance().getStateModel().setStudents(students);			
			ViewManager.getInstance().getStudentListUI().getTableViewer().setInput(students);
		} catch (IOException e) {
			students = ModelManager.getInstance().getStateModel().getStudents();
			ViewManager.getInstance().getStudentListUI().getTableViewer().setInput(students);
		}		
	}
}
