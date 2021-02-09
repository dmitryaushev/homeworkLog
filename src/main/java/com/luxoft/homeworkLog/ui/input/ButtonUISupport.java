package com.luxoft.homeworkLog.ui.input;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.list.StudentListUI;

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

	private TableViewer _tableViewer;

	public ButtonUISupport(InputUI inputUI, ButtonUI buttonUI, StudentListUI studentListUI) {
		_inputUI = inputUI;
		_buttonUI = buttonUI;
		_studentListUI = studentListUI;
	}

	public void createButtonUISupport() {

		_addButton = _buttonUI.getAddButton();
		_saveButton = _buttonUI.getSaveButton();
		_deleteButton = _buttonUI.getDeleteButton();
		_clearButton = _buttonUI.getClearButton();

		_nameText = _inputUI.getNameText();
		_groupText = _inputUI.getGroupText();
		_checkButton = _inputUI.getCheckButton();

		_tableViewer = _studentListUI.getTableViewer();

		_addButton.addSelectionListener(widgetSelectedAdapter(event -> {
			String name = _nameText.getText();
			String group = _groupText.getText();
			boolean isTaskDone = _checkButton.getSelection();
			Student student = new Student(name, group, isTaskDone);

			List<Student> students = (List<Student>) _tableViewer.getInput();
			students.add(student);

			_tableViewer.setInput(students);
		}));

		_saveButton.addSelectionListener(widgetSelectedAdapter(event -> {
			Object students = _tableViewer.getInput();
			String json = new Gson().toJson(students);
			String path = String.format("%s%sfile.txt", System.getProperty("user.dir"), File.separator);
			try {
				Files.write(Paths.get(path), json.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));

		_deleteButton.addSelectionListener(widgetSelectedAdapter(event -> {
			List<Student> students = (List<Student>) _tableViewer.getInput();
			
			StructuredSelection structuredSelection = (StructuredSelection) _tableViewer.getSelection();
			structuredSelection.forEach(object -> {
				Student student = (Student) object;
				_tableViewer.remove(student);
				students.remove(student);
			});
			
			_tableViewer.setInput(students);
		}));

		_clearButton.addSelectionListener(widgetSelectedAdapter(event -> {
			_nameText.setText("");
			_groupText.setText("");
			_checkButton.setSelection(false);
		}));
	}
}
