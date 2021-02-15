package com.luxoft.homeworkLog.model;

import java.util.List;

import com.luxoft.homeworkLog.util.FileManager;

public class ModelManager {

	private static ModelManager _modelManager;
	
	private StateModel _stateModel;
	
	public static ModelManager getInstance() {
		if (_modelManager == null) {
			_modelManager = new ModelManager();
		}
		return _modelManager;
	}
	
	public StateModel getStateModel() {
		if (_stateModel == null) {
			_stateModel = new StateModel();
			initModel();
		}
		return _stateModel;
	}

	public void addStudent(Student student) {
		_stateModel.addStudent(student);
	}
	
	public void deleteStudents(List<Student> deletedStudents) {
		_stateModel.deleteStudents(deletedStudents);
	}
	
	private void initModel() {
		List<Student> students = FileManager.readListFromFile();
		_stateModel.setStudents(students);
	}
}
