package com.luxoft.homeworkLog.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class InputUISupport {
	
	private InputUI _inputUI;
	
	public InputUISupport(InputUI inputUI) {
		_inputUI = inputUI;
		createInputUIListeners();
	}

	private void createInputUIListeners() {
		
		Text nameText = _inputUI.getNameText();
		Text groupText = _inputUI.getGroupText();
		
		nameText.addListener(SWT.KeyUp, event -> {
			String name = nameText.getText();
			String[] chars = name.split("");
			for(String s : chars) {
				if(!s.matches("^[\\p{L} ]+$")) {
					name = name.replace(s, "");
					nameText.setText(name);
					nameText.setSelection(name.length());
				}
			}
		});
		
		groupText.addListener(SWT.KeyUp, event -> {
			String group = groupText.getText();
			String[] chars = group.split("");
			for(String s : chars) {
				if(!s.matches("^[1-9]\\d*$")) {
					group = group.replace(s, "");
					groupText.setText(group);
					groupText.setSelection(group.length());
				}
			}
		});
	}
}
