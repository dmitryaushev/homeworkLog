package com.luxoft.homeworkLog.ui.list;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;

import com.luxoft.homeworkLog.model.Student;
import com.luxoft.homeworkLog.util.DataUtil;

public class StudentListUISupport {

	private StudentListUI _studentListUI;

	private TableViewer _tableViewer;
	private TableViewerColumn _nameColumn;
	private TableViewerColumn _groupColumn;
	private TableViewerColumn _taskColumn;

	public StudentListUISupport(StudentListUI studentListUI) {
		_studentListUI = studentListUI;
	}

	public void createStudentListListeners() {
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
		_nameColumn.setEditingSupport(new AbstactEditingSupport(_tableViewer) {

			@Override
			protected Object getValue(Object object) {
				return ((Student) object).getName();
			}

			@Override
			protected void doSetValue(Object object, Object value) {
				String name = ((Student) object).getName();
				name = value.toString();
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
		_groupColumn.setEditingSupport(new AbstactEditingSupport(_tableViewer) {

			@Override
			protected Object getValue(Object object) {
				return ((Student) object).getGroup();
			}

			@Override
			protected void doSetValue(Object object, Object value) {
				String group = ((Student) object).getGroup().toString();
				group = value.toString();
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
		
		_taskColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object object) {
				return ((Student) object).isTaskDone().toString();
			}
		});
		_taskColumn.setEditingSupport(new AbstactEditingSupport(_tableViewer) {

			@Override
			protected Object getValue(Object object) {
				return ((Student) object).isTaskDone();
			}

			@Override
			protected void doSetValue(Object object, Object value) {
				String isTaskDone = ((Student) object).isTaskDone().toString();
				isTaskDone = value.toString();
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

		//_tableViewer.setInput(DataUtil.createData());
	}
}
