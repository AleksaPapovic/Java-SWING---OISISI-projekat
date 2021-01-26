package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.Profesor;
/**
 * This class implements a table for a list of subjects.
 * 
 * @author Aleksa Papovic
 *
 */
public class TableListaPredmeta  extends JTable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor with parameters which sets the attributes of the table.
	 * 
	 * @param p selected professor for who the table of exams is created
	 */
	public TableListaPredmeta(Profesor p) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    this.setModel(new AbstractTableModelDodavanjePredmetaProfesoru(p));
		this.setTableHeader(null);
	}
	/**
	 * This method prepares renderers which are the components that control the
	 * display of values in a cell in a table.
	 */
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
	/**
	 * This method updates the table and is called when a change in the model has been made.
	 */
	public void azurirajPrikaz() {
		AbstractTableModel model = (AbstractTableModel) this.getModel();
		model.fireTableDataChanged();
		this.validate();
	}
	/**
	 * This method returns the row which is selected.
	 * @return row which is selected
	 */
	public int getCurrentSelectedRow() {
		return this.getSelectedRow();
	}
	/**
	 * This method returns the rows which is selected.
	 * @return rows which is selected
	 */
	public int[] getMultipleSelectedRows() {
		return this.getSelectedRows();
	}

}