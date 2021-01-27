package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Profesor;
/**
 * This class implements an abstract table model for a taught subjects.
 * @author Aleksa Papovic
 *
 */
public class AbstractTableModelPredavaniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profesor profesor;

	/**
	 * Constructor with parameters.
	 * @param profesor professor whose exam is being added
	 */
	public AbstractTableModelPredavaniPredmeti(Profesor profesor) {
		this.profesor = profesor;
	}
	/**
	 * This method returns the number of columns of the table.
	 * @return number of columns of the table
	 */
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCountPredavaniPredmeti();
	}
	/**
	 * This method returns the number of rows of the table.
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getPredavaniPredmeti(profesor).size();
	}
	/**
	 * Returns the name of the column.
	 * @return name of the column.
	 */
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnNamePredavaniPredmeti(column);
	}
	/**
	 * Returns the value at the specified row and column.
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAtPredavaniPredmeti(profesor, row, column);
	}

}
