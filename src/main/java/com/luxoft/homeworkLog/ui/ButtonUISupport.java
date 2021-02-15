package com.luxoft.homeworkLog.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.service.ValidationService;
import com.luxoft.homeworkLog.util.FileManager;

public class ButtonUISupport {

	private ButtonUI _buttonUI;
	private InputUI _inputUI;

	public ButtonUISupport(InputUI inputUI, ButtonUI buttonUI, StudentListUI studentListUI) {
		_inputUI = inputUI;
		_buttonUI = buttonUI;
		createButtonUIListeners();
	}

	private void createButtonUIListeners() {

		ModelManager modelManager = ModelManager.getInstance();
		TableViewer tableViewer = ViewManager.getInstance().getStudentListUI().getTableViewer();

		Button addButton = _buttonUI.getAddButton();
		Button saveButton = _buttonUI.getSaveButton();
		Button deleteButton = _buttonUI.getDeleteButton();
		Button clearButton = _buttonUI.getClearButton();

		Text nameText = _inputUI.getNameText();
		Text groupText = _inputUI.getGroupText();
		Button checkButton = _inputUI.getCheckButton();

		addButton.addSelectionListener(widgetSelectedAdapter(event -> {
			String name = nameText.getText().trim();
			String group = groupText.getText().trim();
			boolean isTaskDone = checkButton.getSelection();

			try {
				ValidationService.validateInput(name, group);

				Student student = new Student(name, group, isTaskDone);
				modelManager.addStudent(student);
				tableViewer.refresh();
			} catch (Exception e) {
				MessageDialog.openError(tableViewer.getControl().getShell(), "Invalid input", e.getMessage());
			}
		}));

		saveButton.addSelectionListener(widgetSelectedAdapter(event -> {
			List<Student> students = modelManager.getStateModel().getStudents();
			FileManager.writeListToFile(students);
		}));

		deleteButton.addSelectionListener(widgetSelectedAdapter(event -> {
			List<Student> students = new ArrayList<>();

			StructuredSelection structuredSelection = (StructuredSelection) tableViewer.getSelection();
			structuredSelection.forEach(selectedStudent -> {
				Student student = (Student) selectedStudent;
				students.add(student);
			});

			if (students.size() == 0) {
				MessageDialog.openError(tableViewer.getControl().getShell(), "Invalid", "No student select");
				return;
			}

			String message = "";
			if (students.size() == 1) {
				message = String.format("Delete student %s?", students.get(0).getName());
			} else {
				message += "Delete students: ";
				for (int i = 0; i < students.size(); i++) {
					if (i != students.size() - 1) {
						message += students.get(i).getName() + ", ";
					} else {
						message += students.get(i).getName() + "?";
					}
				}
			}

			boolean result = MessageDialog.openQuestion(tableViewer.getControl().getShell(), "Delete", message);
			if (result) {
				modelManager.deleteStudents(students);
				tableViewer.refresh();
			}
		}));

		clearButton.addSelectionListener(widgetSelectedAdapter(event -> {
			nameText.setText("");
			groupText.setText("");
			checkButton.setSelection(false);
		}));
	}
}
