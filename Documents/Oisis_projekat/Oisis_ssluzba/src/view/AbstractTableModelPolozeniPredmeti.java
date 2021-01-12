package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;
import model.Student;

public class AbstractTableModelPolozeniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student student;
	
	public AbstractTableModelPolozeniPredmeti(Student student) {
		this.student = student;
	}
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCountPolozeniPredmeti();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getPolozeniPredmeti(student).size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnNamePolozeniPredmeti(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudenata.getInstance().getValueAtPolozeniPredmeti(student,row, column);
	}
}
