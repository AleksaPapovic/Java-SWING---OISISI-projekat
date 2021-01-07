package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.Predmet;
import view.DodavanjePredmetaDialog;
import view.TabsPanel;

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

	public boolean dodajPredmet() {
		Predmet pr = new Predmet();
		
		pr.setSifraP(DodavanjePredmetaDialog.sifraField.getText());
		pr.setImeP(DodavanjePredmetaDialog.imeField.getText());
		pr.setBrojESPB(Integer.parseInt(DodavanjePredmetaDialog.espbField.getText()));

		switch (DodavanjePredmetaDialog.godinaComboBox.getSelectedItem().toString()) {
		case "I(prva)":
			pr.setGodinaS(1);
			break;
		case "II(druga)":
			pr.setGodinaS(2);
			break;

		case "III(treca)":
			pr.setGodinaS(3);
			break;

		case "IV(cetvrta)":
			pr.setGodinaS(4);
			break;

		default:
			break;
		}

		pr.setSemestar(DodavanjePredmetaDialog.semestarComboBox.getSelectedItem().toString());

		BazaPredmeta.getInstance().dodajPredmet(pr.getSifraP(),pr.getImeP(), pr.getBrojESPB(), pr.getGodinaS(), pr.getSemestar());
		TabsPanel.tablePredmet.azuriranjeTabelePredmet();
		return true;
	}

	public boolean izbrisiPredmet(int index_predmeta) {

		if (index_predmeta != -1) {
			BazaPredmeta.getInstance().izbrisiPredmet(index_predmeta);
			TabsPanel.tablePredmet.azuriranjeTabelePredmet();
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Morate selektovati predmet", "Greška", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}
	
	public boolean proveriIme(String ime) {
		boolean ret = true;

		if (ime.isEmpty()) {
			ret = false;
		}
		return ret;

	}
	
	public boolean proveriSifru(String sifra) {

		boolean ret = true;
		if (sifra.isEmpty()) {
			ret = false;
		}
		return ret;
	}
	
	
	public boolean proveriESPB(String brojESPB) {
		boolean ret = true;
		if (brojESPB.isEmpty()) {
			ret = false;
		}
		return ret;

	}

}
