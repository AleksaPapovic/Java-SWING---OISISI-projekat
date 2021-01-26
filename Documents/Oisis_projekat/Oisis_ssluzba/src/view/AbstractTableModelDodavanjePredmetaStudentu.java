package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;
import model.Predmet;
import model.Student;

/**
 * This class implements an abstract table model for adding exams which were taken to the student.
 * @author Dusan Lekic
 *
 */
public class AbstractTableModelDodavanjePredmetaStudentu extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	/**
	 * Constructor with parameters.
	 * @param student student whose exam is being added
	 */
	public AbstractTableModelDodavanjePredmetaStudentu(Student student) {
		this.student = student;
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
		return BazaStudenata.getInstance().getNeradjeneIspite(student).size();
	}
	
	/**
	 * Returns the value at the specified row and column.
	 * @return value at the specified row and column.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Predmet> predmeti = BazaStudenata.getInstance().getNeradjeneIspite(student);
		Predmet predmet = predmeti.get(rowIndex);
		return predmet.getSifraP() + " - " + predmet.getImeP();
	}
}
