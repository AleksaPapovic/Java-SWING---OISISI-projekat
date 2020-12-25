/*REFERENCA: VEZBE 6, IgraciJTable klasa*/ 
package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TableStudent extends JTable {

	private static final long serialVersionUID = -3151913759468484171L;
	/**
	 * 
	 */

	public TableStudent() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void update() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}

}
