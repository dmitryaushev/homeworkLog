package com.luxoft.homeworkLog.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.luxoft.homeworkLog.model.Student;

public class FileManager {
	
	private final static Logger LOGGER = Logger.getLogger(FileManager.class);
	
	public static List<Student> readListFromFile() {
		try {
			String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
			String json = Files.readString(Paths.get(path));
			if (json.isEmpty()) {
				LOGGER.info("Load empty list");
				return new ArrayList<Student>();
			}
			Type listType = new TypeToken<List<Student>>() {}.getType();	
			LOGGER.info("Load list with students");
			return new Gson().fromJson(json, listType);						
		} catch (IOException e) {
			LOGGER.error("No file found. Load empty list");
			return new ArrayList<Student>();
		} catch (JsonSyntaxException e) {
			LOGGER.error("File is damaged. Load empty list");
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
