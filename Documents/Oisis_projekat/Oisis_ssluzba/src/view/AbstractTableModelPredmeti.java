/*REFERENCA: VEZBE 6, AbstractTableModelIgraci klasa*/
package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
/**
 * This class implements an abstract table model for subjects.
 * 
 * @author Aleksa Papovic
 *
 */
public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This method returns the number of columns of the table.
	 * 
	 * @return number of columns of the table
	 */
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}
	/**
	 * This method returns the number of rows of the table.
	 * 
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}
	/**
	 * Returns the name of the column.
	 * 
	 * @return name of the column.
	 */
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	/**
	 * Returns the value at the specified row and column.
	 * 
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
