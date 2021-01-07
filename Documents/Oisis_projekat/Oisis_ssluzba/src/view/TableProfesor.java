/*REFERENCA: VEZBE 6, IgraciJTable klasa*/
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class TableProfesor extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableProfesor() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
	}

	// izmena boje redova prilikom selektovanja
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

	public void azuriranjeTabeleProfesor() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) this.getModel();
		model.fireTableDataChanged();
		validate();
	}

}
