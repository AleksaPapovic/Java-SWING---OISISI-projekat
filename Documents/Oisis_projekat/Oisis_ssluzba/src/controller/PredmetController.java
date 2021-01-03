package controller;

import javax.swing.JOptionPane;

import gui.TabsPanel;
import model.BazaPredmeta;

public class PredmetController {

	public static PredmetController instance = null;

	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	private PredmetController() {

	}
	
	public boolean izbrisiPredmet(int index_predmeta) {
	
	if(index_predmeta != -1) {
	//BazaPredmeta.getInstance().izbrisiPredmet(index_predmeta);
	TabsPanel.tablePredmet.azuriranjeTabelePredmet();
	return true;
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Morate selektovati predmet", "Greška",
				JOptionPane.ERROR_MESSAGE);	
	return false;	
	}
	
	}
		
	}
	
	

