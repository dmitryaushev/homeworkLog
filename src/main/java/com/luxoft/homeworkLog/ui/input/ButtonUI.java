package com.luxoft.homeworkLog.ui.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonUI {

	private Composite _composite;
	private Button _addButton;
	private Button _saveButton;
	private Button _deleteButton;
	private Button _cancelButton;

	public void createButtonUi(Composite parent) {

		_composite = new Composite(parent, SWT.BORDER);
		_composite.setLayout(new FillLayout());

		_addButton = new Button(_composite, SWT.PUSH);
		_saveButton = new Button(_composite, SWT.PUSH);
		_deleteButton = new Button(_composite, SWT.PUSH);
		_cancelButton = new Button(_composite, SWT.PUSH);

		_addButton.setText("Add");
		_saveButton.setText("Save");
		_deleteButton.setText("Delete");
		_cancelButton.setText("Clear");
	}
}
