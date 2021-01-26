/*REFERENCA: VEZBE 6, AbstractTableModelIgraci klasa*/
package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

/**
 * This class implements an abstract table model for students.
 * 
 * @author Dusan Lekic
 *
 */
public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
		 * 
		 */
	private static final long serialVersionUID = -5330664615490765357L;

	/**
	 * Default constructor without parameters.
	 */
	public AbstractTableModelStudenti() {
	}
	
	/**
	 * This method tells us if we can edit the cell at the specified row and column.
	 * 
	 * @return false
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	/**
	 * This method returns the number of columns of the table.
	 * 
	 * @return number of columns of the table
	 */
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}
	/**
	 * This method returns the number of rows of the table.
	 * 
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}
	/**
	 * Returns the name of the column.
	 * 
	 * @return name of the column.
	 */
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	/**
	 * Returns the value at the specified row and column.
	 * 
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 6)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		return null;
	}

}
