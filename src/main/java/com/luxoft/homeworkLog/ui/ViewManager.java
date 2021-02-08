package com.luxoft.homeworkLog.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.luxoft.homeworkLog.ui.input.ButtonUI;
import com.luxoft.homeworkLog.ui.input.InputUI;
import com.luxoft.homeworkLog.ui.list.StudentListUI;

public class ViewManager {

	private static ViewManager _viewManager;
	
	private MenuUI _menuUI;
	private StudentListUI _studentListUI;
	private InputUI _inputUI;
	private ButtonUI _buttonUI;
	
	public ViewManager() {
		_menuUI = new MenuUI();
		_studentListUI = new StudentListUI();
		_inputUI = new InputUI();
		_buttonUI = new ButtonUI();
	}
	
	public void createUI(Composite parent) {
		
		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setLayout(new FillLayout());
		
		_studentListUI.createStudentListUI(sashForm);
	
		Composite composite = new Composite(sashForm, SWT.BORDER);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		_inputUI.createInputUI(composite);
		_buttonUI.createButtonUi(composite);
		
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
}
