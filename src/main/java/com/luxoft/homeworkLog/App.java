package com.luxoft.homeworkLog;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class App extends ApplicationWindow{
	
	public App() {
		super(null);
	}
	
	@Override
	protected Control createContents(Composite parrent) {
		
		parrent.pack();
		return parrent;
	}

	public static void main(String[] args) {
		App awin = new App();
		awin.setBlockOnOpen(true);
		awin.open();
		Display.getCurrent().dispose();
	}
}
