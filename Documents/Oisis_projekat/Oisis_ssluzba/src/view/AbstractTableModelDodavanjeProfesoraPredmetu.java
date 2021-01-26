package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Profesor;
/**
 * This class implements an abstract table model for adding professors on a exam.
 * @author Aleksa Papovic
 *
 */
public class AbstractTableModelDodavanjeProfesoraPredmetu extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelDodavanjeProfesoraPredmetu() {
	}
	/**
	 * This method returns the number of columns of the table.
	 * @return number of columns of the table
	 */
	@Override
	public int getColumnCount() {
		return 1;
	}
	/**
	 * This method returns the number of rows of the table.
	 * @return number of rows of the table
	 */
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}
	/**
	 * Returns the value at the specified row and column.
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Profesor> profesor = BazaProfesora.getInstance().getProfesori();
		Profesor pr = profesor.get(rowIndex);
		return pr.getIme()+" "+pr.getPrezime();
	}
}
