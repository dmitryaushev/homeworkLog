package com.luxoft.homeworkLog.ui.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

import com.google.gson.Gson;
import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;

public class Save extends Action {

	private ApplicationWindow _applicationWindow;
	
	private ModelManager _modelManager = ModelManager.getInstance();

	public Save(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("Save");
	}

	@Override
	public void run() {
		boolean result = MessageDialog.openQuestion(_applicationWindow.getShell(), "Save", "Save data?");
		if (result) {
			List<Student> students = _modelManager.getStateModel().getStudents();
			String json = new Gson().toJson(students);
			String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
			try {
				Files.write(Paths.get(path), json.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
