package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Profesor;

public class AbstractTableModelDodavanjeProfesoraPredmetu extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelDodavanjeProfesoraPredmetu() {
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Profesor> profesor = BazaProfesora.getInstance().getProfesori();
		Profesor pr = profesor.get(rowIndex);
		return pr.getIme()+" "+pr.getPrezime();
	}
}
