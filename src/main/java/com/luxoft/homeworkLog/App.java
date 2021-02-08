package com.luxoft.homeworkLog;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.homeworkLog.ui.ViewManager;

public class App extends ApplicationWindow{
	
	private ViewManager _viewManager = ViewManager.getInstance();
	
	public App() {
		super(null);
		addMenuBar();
	}
	
	@Override
	protected Control createContents(Composite parent) {
		_viewManager.createUI(parent);
		
		parent.pack();
		return parent;
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("JFace homework log");
		shell.setSize(700, 300);
	}
	
	@Override
	protected MenuManager createMenuManager() {		
		return _viewManager.getMenuManager(this);
	}

	public static void main(String[] args) {
		App awin = new App();
		awin.setBlockOnOpen(true);
		awin.open();
		Display.getCurrent().dispose();
	}
}
