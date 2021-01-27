package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

/**
 * This class implements an abstract table model for adding exams which are taught by a professor.
 * @author Aleksa Papovic
 *
 */

public class AbstractTableModelDodavanjePredmetaProfesoru extends AbstractTableModel {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profesor profesor;
	
	/**
	 * Constructor with parameters.
	 * @param profesor professor whose exam is being added
	 */
	public AbstractTableModelDodavanjePredmetaProfesoru(Profesor profesor) {
		this.profesor = profesor;
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
		return BazaProfesora.getInstance().getNePredajePredmeteProfesor(profesor).size();
	}
	
	/**
	 * Returns the value at the specified row and column.
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Predmet> predmeti = BazaProfesora.getInstance().getNePredajePredmeteProfesor(profesor);
		Predmet predmet = predmeti.get(rowIndex);
		return predmet.getSifraP() + " - " + predmet.getImeP();
	}
}
