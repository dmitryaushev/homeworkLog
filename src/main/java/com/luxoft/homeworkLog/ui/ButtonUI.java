package com.luxoft.homeworkLog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonUI {

	private Composite _composite;
	private Button _addButton;
	private Button _saveButton;
	private Button _deleteButton;
	private Button _clearButton;
	
	public ButtonUI(Composite parent) {
		createButtonUi(parent);
	}

	private void createButtonUi(Composite parent) {

		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.marginTop = 25;
		RowData data = new RowData();
		data.width = 75;
		
		_composite = new Composite(parent, SWT.NONE);
		_composite.setLayout(layout);

		_addButton = new Button(_composite, SWT.PUSH);
		_saveButton = new Button(_composite, SWT.PUSH);
		_deleteButton = new Button(_composite, SWT.PUSH);
		_clearButton = new Button(_composite, SWT.PUSH);	

		_addButton.setText("Add");
		_saveButton.setText("Save");
		_deleteButton.setText("Delete");
		_clearButton.setText("Clear");
		_addButton.setLayoutData(data);
		_saveButton.setLayoutData(data);
		_deleteButton.setLayoutData(data);
		_clearButton.setLayoutData(data);
	}

	public Button getAddButton() {
		return _addButton;
	}

	public Button getSaveButton() {
		return _saveButton;
	}

	public Button getDeleteButton() {
		return _deleteButton;
	}

	public Button getClearButton() {
		return _clearButton;
	}
}
