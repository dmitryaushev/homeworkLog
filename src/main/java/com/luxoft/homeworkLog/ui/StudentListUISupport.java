package com.luxoft.homeworkLog.ui;

import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;

import com.luxoft.homeworkLog.model.ModelManager;
import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.ui.tableviewer.ColumnViewerComparator;
import com.luxoft.homeworkLog.ui.tableviewer.EmulatedNativeCheckBoxLabelProvider;

public class StudentListUISupport {

	private StudentListUI _studentListUI;

	private TableViewer tableViewer;

	public StudentListUISupport(StudentListUI studentListUI) {
		_studentListUI = studentListUI;
		setColumnLogic();
		setListStudentsToTableViewer();
	}

	private void setColumnLogic() {
		
		TableViewer tableViewer = _studentListUI.getTableViewer();
		TableViewerColumn nameColumn = _studentListUI.getNameColumn();
		TableViewerColumn groupColumn = _studentListUI.getGroupColumn();
		TableViewerColumn taskColumn = _studentListUI.getTaskColumn();

		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object object) {
				return ((Student) object).getName();
			}
		});
		new ColumnViewerComparator(tableViewer, nameColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		};

		groupColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object object) {
				return ((Student) object).getGroup();
			}
		});
		new ColumnViewerComparator(tableViewer, groupColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return Integer.valueOf(s1.getGroup()).compareTo(Integer.valueOf(s2.getGroup()));
			}
		};
		
		taskColumn.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(tableViewer) {		
			@Override
			protected boolean isChecked(Object object) {
				return ((Student) object).isTaskDone();
			}
		});
		new ColumnViewerComparator(tableViewer, taskColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return Boolean.compare(s1.isTaskDone(), s2.isTaskDone());
			}
		};		
	}
	
	private void setListStudentsToTableViewer() {
		List<Student> input = ModelManager.getInstance().getStateModel().getStudents();
		tableViewer.setInput(input);		
	}
}
