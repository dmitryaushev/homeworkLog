package com.luxoft.homeworkLog;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.ui.ViewManager;
import com.luxoft.homeworkLog.util.FileManager;

public class App extends ApplicationWindow {

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
		shell.setMinimumSize(700, 300);
		
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) + 150;
		int y = bounds.y + (bounds.height - rect.height) + 25;
		shell.setLocation(x, y);
	}

	@Override
	protected MenuManager createMenuManager() {
		return _viewManager.getMenuManager(this);
	}

	public static void main() {
		App awin = new App();
		awin.setBlockOnOpen(true);
		awin.open();
		Display.getCurrent().dispose();
	}
}
