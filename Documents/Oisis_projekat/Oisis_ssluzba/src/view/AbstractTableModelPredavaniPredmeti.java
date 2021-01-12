package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.Student;

public class AbstractTableModelPredavaniPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profesor profesor;

	public AbstractTableModelPredavaniPredmeti(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCountPredavaniPredmeti();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getPredavaniPredmeti(profesor).size();
	}

	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnNamePredavaniPredmeti(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAtPredavaniPredmeti(profesor, row, column);
	}

}
