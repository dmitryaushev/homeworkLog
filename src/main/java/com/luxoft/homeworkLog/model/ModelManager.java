package com.luxoft.homeworkLog.model;

import java.util.List;

public class ModelManager {

	private static ModelManager _modelManager;
	
	private StateModel _stateModel;
	
	public void createModel() {
		_stateModel = new StateModel();
	}
	
	public static ModelManager getInstance() {
		if (_modelManager == null) {
			_modelManager = new ModelManager();
		}
		return _modelManager;
	}
	
	public StateModel getStateModel() {
		return _stateModel;
	}

	public void addStudent(Student student) {
		_stateModel.addStudent(student);
	}
	
	public void deleteStudents(List<Student> deletedStudents) {
		_stateModel.deleteStudents(deletedStudents);
	}
}
