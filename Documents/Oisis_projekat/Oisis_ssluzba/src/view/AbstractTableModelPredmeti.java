/*REFERENCA: VEZBE 6, AbstractTableModelIgraci klasa*/
package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
