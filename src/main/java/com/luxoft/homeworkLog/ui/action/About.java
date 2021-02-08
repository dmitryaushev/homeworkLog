package com.luxoft.homeworkLog.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

public class About extends Action {
	
	ApplicationWindow _applicationWindow;

	public About(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("About");
	}

	@Override
	public void run() {
		MessageDialog.openInformation(_applicationWindow.getShell(), "About", "Some text");
	}
}
