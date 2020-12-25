/*REFERENCA: VEZBE 6, AbstractTableModelIgraci klasa*/ 
package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
		 * 
		 */
	private static final long serialVersionUID = -5330664615490765357L;

	public AbstractTableModelStudenti() {
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 6)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		return null;
	}

}
