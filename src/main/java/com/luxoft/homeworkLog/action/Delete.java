package com.luxoft.homeworkLog.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;

import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.ViewManager;

public class Delete extends Action {

	private ApplicationWindow _applicationWindow;

	private ModelManager _modelManager = ModelManager.getInstance();
	private ViewManager _viewManager = ViewManager.getInstance();

	public Delete(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("Delete");
	}

	@Override
	public void run() {

		TableViewer tableViewer = _viewManager.getStudentListUI().getTableViewer();
		List<Student> students = new ArrayList<>();

		StructuredSelection structuredSelection = (StructuredSelection) tableViewer.getSelection();
		structuredSelection.forEach(selectedStudent -> {
			Student student = (Student) selectedStudent;
			students.add(student);
		});

		if (students.size() == 0) {
			MessageDialog.openError(_applicationWindow.getShell(), "Invalid", "No student select");
			return;
		}

		String message = String.format("Delete students: %s?", students.toString().replace("[", "").replace("]", ""));

		boolean result = MessageDialog.openQuestion(_applicationWindow.getShell(), "Delete", message);
		if (result) {
			_modelManager.deleteStudents(students);
			tableViewer.refresh();
		}
	}
}
