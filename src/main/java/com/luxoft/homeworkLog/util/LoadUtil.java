package com.luxoft.homeworkLog.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.ViewManager;

public class LoadUtil {

	public static void loadList() {
		String path = String.format("%s/file.txt", System.getProperty("user.dir"));	
		String json = "";
		try {
			json = Files.readString(Paths.get(path));
			
			Type listType = new TypeToken<List<Student>>() {}.getType();
			
			List<Student> students = new Gson().fromJson(json, listType);
			
			ViewManager.getInstance().getStudentListUI().getTableViewer().setInput(students);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
