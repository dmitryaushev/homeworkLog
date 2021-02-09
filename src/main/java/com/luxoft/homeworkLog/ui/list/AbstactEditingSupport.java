package com.luxoft.homeworkLog.ui.list;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

public abstract class AbstactEditingSupport extends EditingSupport {

	private TextCellEditor editor;

	public AbstactEditingSupport(TableViewer viewer) {
		super(viewer);
		this.editor = new TextCellEditor(viewer.getTable());
	}

	@Override
	protected boolean canEdit(Object object) {
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object object) {
		return editor;
	}

	@Override
	protected void setValue(Object object, Object value) {
		doSetValue(object, value);
		getViewer().update(object, null);
	}

	protected abstract void doSetValue(Object object, Object value);

}
