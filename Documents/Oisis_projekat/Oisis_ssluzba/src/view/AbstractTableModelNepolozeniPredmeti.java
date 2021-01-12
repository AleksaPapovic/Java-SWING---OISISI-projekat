package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;
import model.Student;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student student;

	public AbstractTableModelNepolozeniPredmeti(Student student) {
		this.student = student;
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCountNepolozeniPredmeti();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getNepolozeniPredmeti(student).size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnNameNepolozeniPredmeti(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudenata.getInstance().getValueAtNepolozeniPredmeti(student, row, column);
	}
}
