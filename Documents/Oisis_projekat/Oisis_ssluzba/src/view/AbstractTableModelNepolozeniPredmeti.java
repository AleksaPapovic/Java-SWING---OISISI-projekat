package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;
import model.Student;

/**
 * This class implements an abstract table model for failed exams of the student.
 * @author Dusan Lekic
 *
 */

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student student;
	
	/**
	 * Constructor with parameters.
	 * @param student given student with failed exams
	 */
	public AbstractTableModelNepolozeniPredmeti(Student student) {
		this.student = student;
	}
	
	/**
	 * This method returns the number of columns of the table.
	 * @return number of columns of the table
	 */
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCountNepolozeniPredmeti();
	}
	
	/**
	 * This method returns the number of rows of the table.
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getNepolozeniPredmeti(student).size();
	}
	
	/**
	 * Returns the name of the column.
	 * @return name of the column.
	 */
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnNameNepolozeniPredmeti(column);
	}
	
	/**
	 * Returns the value at the specified row and column.
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudenata.getInstance().getValueAtNepolozeniPredmeti(student, row, column);
	}
}
