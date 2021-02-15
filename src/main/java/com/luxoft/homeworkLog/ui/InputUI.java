package com.luxoft.homeworkLog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class InputUI {

	private Composite _composite;
	private Label _nameLabel;
	private Label _groupLabel;
	private Label _taskLabel;
	private Text _nameText;
	private Text _groupText;
	private Button _checkButton;

	public InputUI(Composite parent) {
		createInputUI(parent);
	}

	private void createInputUI(Composite parent) {

		_composite = new Composite(parent, SWT.NONE);

		_nameLabel = new Label(_composite, SWT.NONE);
		_nameText = new Text(_composite, SWT.BORDER);
		_groupLabel = new Label(_composite, SWT.NONE);
		_groupText = new Text(_composite, SWT.BORDER);
		_taskLabel = new Label(_composite, SWT.NONE);
		_checkButton = new Button(_composite, SWT.CHECK);

		_composite.setLayout(new GridLayout(2, false));

		GridData labelGridData = new GridData();
		GridData textGridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		GridData checkGridData = new GridData();

		labelGridData.verticalIndent = 15;
		textGridData.horizontalIndent = -5;
		textGridData.verticalIndent = 15;
		checkGridData.horizontalIndent = 170;
		checkGridData.verticalIndent = 15;

		_nameLabel.setText("Name");
		_nameLabel.setLayoutData(labelGridData);
		_nameText.setLayoutData(textGridData);
		_groupLabel.setText("Group");
		_groupLabel.setLayoutData(labelGridData);
		_groupText.setLayoutData(textGridData);
		_taskLabel.setText("SWT task done");
		_taskLabel.setLayoutData(labelGridData);
		_checkButton.setLayoutData(checkGridData);
	}

	public Text getNameText() {
		return _nameText;
	}

	public Text getGroupText() {
		return _groupText;
	}

	public Button getCheckButton() {
		return _checkButton;
	}
}
