/*REFERENCA: VEZBE 6, AbstractTableModelIgraci klasa*/
package gui;

import javax.swing.table.AbstractTableModel;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public String getColumnName(int column) {
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
}
