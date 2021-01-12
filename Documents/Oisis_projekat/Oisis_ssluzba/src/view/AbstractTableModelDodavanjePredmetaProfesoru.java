package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AbstractTableModelDodavanjePredmetaProfesoru extends AbstractTableModel {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profesor profesor;
	
	public AbstractTableModelDodavanjePredmetaProfesoru(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getNePredajePredmeteProfesor(profesor).size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Predmet> predmeti = BazaProfesora.getInstance().getNePredajePredmeteProfesor(profesor);
		Predmet predmet = predmeti.get(rowIndex);
		return predmet.getSifraP() + " - " + predmet.getImeP();
	}
}
