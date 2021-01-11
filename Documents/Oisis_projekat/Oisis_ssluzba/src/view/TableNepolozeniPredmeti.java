package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Student;

public class TableNepolozeniPredmeti extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableNepolozeniPredmeti(Student s) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelNepolozeniPredmeti(s));
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

		public void azurirajNepolozene() {
			AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) this.getModel();
			model.fireTableDataChanged();
			validate();
		}

}