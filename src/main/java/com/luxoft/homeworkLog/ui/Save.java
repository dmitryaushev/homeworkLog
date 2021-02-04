package com.luxoft.homeworkLog.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

public class Save extends Action {

	ApplicationWindow _applicationWindow;

	public Save(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("Save");
	}

	@Override
	public void run() {
		boolean result = MessageDialog.openQuestion(_applicationWindow.getShell(), "Save", "Save data?");
		if (result) {

		}
	}
}
