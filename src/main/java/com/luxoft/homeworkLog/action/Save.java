package com.luxoft.homeworkLog.action;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.util.FileManager;

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
			FileManager.writeListToFile(students);
		}
	}
}