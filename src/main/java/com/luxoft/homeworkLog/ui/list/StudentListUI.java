package com.luxoft.homeworkLog.ui.list;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

public class StudentListUI {

	private TableViewer _tableViewer;
	private TableViewerColumn _nameColumn;
	private TableViewerColumn _groupColumn;
	private TableViewerColumn _taskColumn;
	
	public StudentListUI(Composite parent) {
		createStudentListUI(parent);
	}

	private void createStudentListUI(Composite parent) {

		_tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		_tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		_nameColumn = createColumnFor(_tableViewer, "Name", 150);
		_groupColumn = createColumnFor(_tableViewer, "Group", 50);
		_taskColumn = createColumnFor(_tableViewer, "SWT done", 100);

		_tableViewer.getTable().setLinesVisible(true);
		_tableViewer.getTable().setHeaderVisible(true);
		_tableViewer.getTable().setHeaderBackground(new Color(228, 228, 228));
	}

	private TableViewerColumn createColumnFor(TableViewer viewer, String label, int width) {
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
		column.getColumn().setWidth(width);
		column.getColumn().setText(label);
		column.getColumn().setMoveable(true);
		return column;
	}

	public TableViewer getTableViewer() {
		return _tableViewer;
	}

	public TableViewerColumn getNameColumn() {
		return _nameColumn;
	}

	public TableViewerColumn getGroupColumn() {
		return _groupColumn;
	}

	public TableViewerColumn getTaskColumn() {
		return _taskColumn;
	}
}
