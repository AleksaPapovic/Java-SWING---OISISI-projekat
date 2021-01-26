/*REFERENCA: VEZBE 6, IgraciJTable klasa*/
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
/**
 * This class implements a table for a list of subjects.
 * 
 * @author Aleksa Papovic
 *
 */
public class TablePredmet extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor with parameters which sets the attributes of the table.
	 * 
	 */
	public TablePredmet() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
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
	public void azuriranjeTabelePredmet() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) this.getModel();
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
