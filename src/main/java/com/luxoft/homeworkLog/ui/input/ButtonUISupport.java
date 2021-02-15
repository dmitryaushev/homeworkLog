package com.luxoft.homeworkLog.ui.input;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.service.ValidationService;
import com.luxoft.homeworkLog.ui.ViewManager;
import com.luxoft.homeworkLog.ui.list.StudentListUI;
import com.luxoft.homeworkLog.util.FileManager;

public class ButtonUISupport {

	private ButtonUI _buttonUI;
	private InputUI _inputUI;
	private StudentListUI _studentListUI;

	private Button _addButton;
	private Button _saveButton;
	private Button _deleteButton;
	private Button _clearButton;

	private Text _nameText;
	private Text _groupText;
	private Button _checkButton;
	
	private ModelManager _modelManager;
	private TableViewer _tableViewer;

	public ButtonUISupport(InputUI inputUI, ButtonUI buttonUI, StudentListUI studentListUI) {
		_inputUI = inputUI;
		_buttonUI = buttonUI;
		_studentListUI = studentListUI;
		_modelManager = ModelManager.getInstance();
		_tableViewer = ViewManager.getInstance().getStudentListUI().getTableViewer();
		createButtonUIListeners();
	}

	private void createButtonUIListeners() {

		_addButton = _buttonUI.getAddButton();
		_saveButton = _buttonUI.getSaveButton();
		_deleteButton = _buttonUI.getDeleteButton();
		_clearButton = _buttonUI.getClearButton();

		_nameText = _inputUI.getNameText();
		_groupText = _inputUI.getGroupText();
		_checkButton = _inputUI.getCheckButton();

		_addButton.addSelectionListener(widgetSelectedAdapter(event -> {
			String name = _nameText.getText();
			String group = _groupText.getText();
			boolean isTaskDone = _checkButton.getSelection();
			
			try {
				ValidationService.validateInput(name, group);
				
				Student student = new Student(name, group, isTaskDone);
				_modelManager.addStudent(student);
				_tableViewer.refresh();							
			} catch (Exception e) {
				MessageDialog.openError(_tableViewer.getControl().getShell(), "Invalid input", e.getMessage());
			}		
		}));

		_saveButton.addSelectionListener(widgetSelectedAdapter(event -> {
			List<Student> students = _modelManager.getStateModel().getStudents();
			FileManager.writeListToFile(students);
		}));

		_deleteButton.addSelectionListener(widgetSelectedAdapter(event -> {
			List<Student> students = new ArrayList<>();
			
			StructuredSelection structuredSelection = (StructuredSelection) _studentListUI.getTableViewer().getSelection();
			structuredSelection.forEach(selectedStudent -> {
				Student student = (Student) selectedStudent;
				students.add(student);
				});
			
			_modelManager.deleteStudents(students);
			_tableViewer.refresh();
		}));

		_clearButton.addSelectionListener(widgetSelectedAdapter(event -> {
			_nameText.setText("");
			_groupText.setText("");
			_checkButton.setSelection(false);
		}));
	}
}
