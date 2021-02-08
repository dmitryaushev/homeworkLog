package com.luxoft.homeworkLog.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

public class Exit extends Action {

	ApplicationWindow _applicationWindow;

	public Exit(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("Exit");
	}

	@Override
	public void run() {
		boolean result = MessageDialog.openQuestion(_applicationWindow.getShell(), "Exit", "Are you sure?");
		if (result) {
			_applicationWindow.close();
		}
	}
}
