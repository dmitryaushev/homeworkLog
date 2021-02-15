package com.luxoft.homeworkLog.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.luxoft.homeworkLog.ui.input.ButtonUI;
import com.luxoft.homeworkLog.ui.input.ButtonUISupport;
import com.luxoft.homeworkLog.ui.input.InputUI;
import com.luxoft.homeworkLog.ui.input.InputUISupport;
import com.luxoft.homeworkLog.ui.list.StudentListUI;
import com.luxoft.homeworkLog.ui.list.StudentListUISupport;

public class ViewManager {

	private static ViewManager _viewManager;
	
	private MenuUI _menuUI;
	private StudentListUI _studentListUI;
	private StudentListUISupport _studentListUISupport;
	private InputUI _inputUI;
	private InputUISupport _inputUISupport;
	private ButtonUI _buttonUI;
	private ButtonUISupport _buttonUISupport;
	
	public ViewManager() {
		_menuUI = new MenuUI();
	}
	
	public void createUI(Composite parent) {
		
		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setLayout(new FillLayout());
		
		_studentListUI = new StudentListUI(sashForm);
		_studentListUISupport = new StudentListUISupport(_studentListUI);
		
		Composite composite = new Composite(sashForm, SWT.BORDER);
		composite.setLayout(new GridLayout());
		
		_inputUI = new InputUI(composite);
		_inputUISupport = new InputUISupport(_inputUI);
		_buttonUI = new ButtonUI(composite);	
		_buttonUISupport = new ButtonUISupport(_inputUI, _buttonUI, _studentListUI);
	}
	
	public MenuManager getMenuManager(ApplicationWindow applicationWindow) {
		return _menuUI.createMenuManager(applicationWindow);
	}
	
	public static ViewManager getInstance() {
		if (_viewManager == null) {
			_viewManager = new ViewManager();
		}
		return _viewManager;
	}

	public StudentListUI getStudentListUI() {
		return _studentListUI;
	}
}
