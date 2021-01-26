package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Profesor;
/**
 * This class implements a table for a list of exams which are taught by professor.
 * 
 * @author Aleksa Papovic
 *
 */
public class TablePredavaniPredmeti extends JTable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor with parameters which sets the attributes of the table.
	 * 
	 * @param p selected professor for who the table of exams is created
	 */
	public TablePredavaniPredmeti(Profesor p) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredavaniPredmeti(p));
		this.setAutoCreateRowSorter(true);
	}
	/**
	 * This method prepares renderers which are the components that control the
	 * display of values in a cell in a table.
	 */
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
	/**
	 * This method updates the table and is called when a change in the model has been made.
	 */	
	public void azuriranjeTabelePredavaniPredmeti() {
		AbstractTableModelPredavaniPredmeti model = (AbstractTableModelPredavaniPredmeti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}
	/**
	 * This method returns the row which is selected.
	 * @return row which is selected
	 */
	public int getSelectedTableRow() {
		return this.convertRowIndexToModel(this.getSelectedRow()) ;
	}
}