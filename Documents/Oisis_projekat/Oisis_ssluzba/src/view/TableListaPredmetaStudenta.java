package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.Student;

/**
 * This class implements a table for a list of exams which student hasn't taken.
 * 
 * @author Dusan Lekic
 *
 */
public class TableListaPredmetaStudenta extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with parameters which sets the attributes of the table.
	 * 
	 * @param s selected student for who the table of exams is created
	 */
	public TableListaPredmetaStudenta(Student s) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelDodavanjePredmetaStudentu(s));
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
	public void update() {
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

}
