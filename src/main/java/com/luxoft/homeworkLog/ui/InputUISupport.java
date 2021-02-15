package com.luxoft.homeworkLog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class InputUISupport {
	
	private InputUI _inputUI;
	private Text _nameText;
	private Text _groupText;
	
	public InputUISupport(InputUI inputUI) {
		_inputUI = inputUI;
		createInputUIListeners();
	}

	private void createInputUIListeners() {
		
		_nameText = _inputUI.getNameText();
		_groupText = _inputUI.getGroupText();
		
		_nameText.addListener(SWT.KeyUp, event -> {
			String name = _nameText.getText();
			String[] chars = name.split("");
			for(String s : chars) {
				if(!s.matches("^[\\p{L} ]+$")) {
					name = name.replace(s, "");
					_nameText.setText(name);
					_nameText.setSelection(name.length());
				}
			}
		});
		
		_groupText.addListener(SWT.KeyUp, event -> {
			String group = _groupText.getText();
			String[] chars = group.split("");
			for(String s : chars) {
				if(!s.matches("^[1-9]\\d*$")) {
					group = group.replace(s, "");
					_groupText.setText(group);
					_groupText.setSelection(group.length());
				}
			}
		});
	}
}
