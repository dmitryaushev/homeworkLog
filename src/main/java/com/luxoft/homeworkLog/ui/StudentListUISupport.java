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

	private TableViewer _tableViewer;
	private TableViewerColumn _nameColumn;
	private TableViewerColumn _groupColumn;
	private TableViewerColumn _taskColumn;

	public StudentListUISupport(StudentListUI studentListUI) {
		_studentListUI = studentListUI;
		createStudentListListeners();
		setListStudentsToTableViewer();
	}

	private void createStudentListListeners() {
		_tableViewer = _studentListUI.getTableViewer();
		_nameColumn = _studentListUI.getNameColumn();
		_groupColumn = _studentListUI.getGroupColumn();
		_taskColumn = _studentListUI.getTaskColumn();

		_nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object object) {
				return ((Student) object).getName();
			}
		});
		new ColumnViewerComparator(_tableViewer, _nameColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		};

		_groupColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object object) {
				return ((Student) object).getGroup();
			}
		});
		new ColumnViewerComparator(_tableViewer, _groupColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return Integer.valueOf(s1.getGroup()).compareTo(Integer.valueOf(s2.getGroup()));
			}
		};
		
		_taskColumn.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(_tableViewer) {		
			@Override
			protected boolean isChecked(Object object) {
				return ((Student) object).isTaskDone();
			}
		});
		new ColumnViewerComparator(_tableViewer, _taskColumn) {
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
		_tableViewer.setInput(input);		
	}
}
