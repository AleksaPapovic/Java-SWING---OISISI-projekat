package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Student;
/**
 * This class implements a table for a list of exams which student failed.
 * 
 * @author Aleksa Papovic
 *
 */
public class TableNepolozeniPredmeti extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor with parameters which sets the attributes of the table.
	 * 
	 * @param s selected student for who the table of exams is created
	 */
	public TableNepolozeniPredmeti(Student s) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelNepolozeniPredmeti(s));
	}
	/**
	 * This method prepares renderers which are the components that control the
	 * display of values in a cell in a table.
	 */
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
	/**
	 * This method updates the table and is called when a change in the model has been made.
	 */
	public void azurirajNepolozene() {
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}

}