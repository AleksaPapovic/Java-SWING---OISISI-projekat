/*REFERENCA: VEZBE 6, IgraciJTable klasa*/ 
package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTableModelOcene extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4471619261297990267L;

	public AbstractTableModelOcene() {
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcene().size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 4)
			return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
		return null;
	}

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
