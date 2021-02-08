package com.luxoft.homeworkLog.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;

public class Delete extends Action {

	ApplicationWindow _applicationWindow;

	public Delete(ApplicationWindow applicationWindow) {
		_applicationWindow = applicationWindow;
		setText("Delete");
	}

	@Override
	public void run() {
		boolean result = MessageDialog.openQuestion(_applicationWindow.getShell(), "Delete", "Delete data?");
		if (result) {

		}
	}
}
