package com.luxoft.homeworkLog.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;

import com.luxoft.homeworkLog.ui.action.About;
import com.luxoft.homeworkLog.ui.action.Delete;
import com.luxoft.homeworkLog.ui.action.Exit;
import com.luxoft.homeworkLog.ui.action.Save;

public class MenuUI {

	MenuManager _mainMenu;
	MenuManager _fileMenu;
	MenuManager _editMenu;
	MenuManager _helpMenu;

	public MenuManager createMenuManager(ApplicationWindow applicationWindow) {
		_mainMenu = new MenuManager();
		_fileMenu = new MenuManager("File");
		_editMenu = new MenuManager("Edit");
		_helpMenu = new MenuManager("Help");

		_fileMenu.add(new Save(applicationWindow));
		_fileMenu.add(new Exit(applicationWindow));
		_editMenu.add(new Delete(applicationWindow));
		_helpMenu.add(new About(applicationWindow));

		_mainMenu.add(_fileMenu);
		_mainMenu.add(_editMenu);
		_mainMenu.add(_helpMenu);
		return _mainMenu;
	}
}
