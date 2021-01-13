package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;
import model.Predmet;
import model.Student;

public class AbstractTableModelDodavanjePredmetaStudentu extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;

	public AbstractTableModelDodavanjePredmetaStudentu(Student student) {
		this.student = student;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getNeradjeneIspite(student).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Predmet> predmeti = BazaStudenata.getInstance().getNeradjeneIspite(student);
		Predmet predmet = predmeti.get(rowIndex);
		return predmet.getSifraP() + " - " + predmet.getImeP();
	}
}
