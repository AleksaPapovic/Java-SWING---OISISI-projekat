/*REFERENCA: VEZBE 6, IgraciJTable klasa*/
package view;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

/**
 * This class implements an abstract table model for grades.
 * 
 * @author Dusan Lekic
 *
 */
public class AbstractTableModelOcene extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4471619261297990267L;

	/**
	 * Constructor without parameters.
	 * 
	 
	 */
	public AbstractTableModelOcene() {
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
		return BazaOcena.getInstance().getColumnCount();
	}

	/**
	 * This method returns the number of rows of the table.
	 * 
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcene().size();
	}

	/**
	 * Returns the name of the column.
	 * 
	 * @return name of the column.
	 */
	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

	/**
	 * Returns the value at the specified row and column.
	 * 
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 4)
			return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
		return null;
	}

	/**
	 * Returns the class of the specified column.
	 * 
	 * @return class of the specified column
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		default:
			return null;
		}
	}

}
