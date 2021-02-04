package com.luxoft.homeworkLog.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Shell;

public class ViewManager {

	private static ViewManager _viewManager;
	
	private MenuUI _menuUI;
	
	public ViewManager() {
		_menuUI = new MenuUI();
	}
	
	public void createUI(Shell shell) {
		
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
