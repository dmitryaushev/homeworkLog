package com.luxoft.homeworkLog.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.ViewManager;

public class FileManager {
	
	public static List<Student> readListFromFile() {
		try {
			String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
			String json = Files.readString(Paths.get(path));
			if (json.isEmpty()) {
				return new ArrayList<Student>();
			}
			Type listType = new TypeToken<List<Student>>() {}.getType();			
			return new Gson().fromJson(json, listType);						
		} catch (IOException e) {
			return new ArrayList<Student>();
		} catch (JsonSyntaxException e) {
			return new ArrayList<Student>();
		}	
	}
	
	public static void writeListToFile(List<Student> students) {
		String json = new Gson().toJson(students);
		String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
		try {
			Files.write(Paths.get(path), json.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
