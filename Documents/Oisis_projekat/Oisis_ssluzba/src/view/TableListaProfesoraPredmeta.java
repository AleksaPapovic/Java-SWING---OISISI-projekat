package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class TableListaProfesoraPredmeta extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableListaProfesoraPredmeta() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    this.setModel(new AbstractTableModelDodavanjeProfesoraPredmetu());
		this.setTableHeader(null);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new java.awt.Color(220, 230, 240));
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	public void update() {
		AbstractTableModel model = (AbstractTableModel) this.getModel();
		model.fireTableDataChanged();
		this.validate();
	}
	
	public int getCurrentSelectedRow() {
		return this.getSelectedRow();
	}

}
