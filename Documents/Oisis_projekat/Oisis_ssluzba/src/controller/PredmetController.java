package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.DodavanjePredmetaDialog;
import view.DodavanjeProfesoraPredmetuDialog;
import view.IzmenaPredmetaPanel;
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

		BazaPredmeta.getInstance().dodajPredmet(pr.getSifraP(), pr.getImeP(), pr.getBrojESPB(), pr.getGodinaS(),
				pr.getSemestar());
		TabsPanel.tablePredmet.azuriranjeTabelePredmet();
		return true;
	}

	public boolean izmeniPredmet() {

		String sifraP = IzmenaPredmetaPanel.sifraIzmena.getText();
		String ime = IzmenaPredmetaPanel.imePredIzmena.getText();
		int espb = Integer.parseInt(IzmenaPredmetaPanel.espbIzmena.getText());
		int godinaS = 0;
		switch (IzmenaPredmetaPanel.godinaIzmena.getSelectedItem().toString()) {
		case "I(prva)":
			godinaS = 1;
			break;
		case "II(druga)":
			godinaS = 2;
			break;

		case "III(treca)":
			godinaS = 3;
			break;

		case "IV(cetvrta)":
			godinaS = 4;
			break;

		default:
			break;
		}

		String semestar = IzmenaPredmetaPanel.semestarIzmena.getSelectedItem().toString();

		int index = TabsPanel.tablePredmet.getSelectedRow();
		BazaPredmeta.getInstance().izmeniPredmet(index, sifraP, ime, espb, godinaS, semestar);
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

	public void pretragaPredmeta(String text) {
		BazaPredmeta.getInstance().pretraziPredmete(text);
		TabsPanel.tablePredmet.azuriranjeTabelePredmet();
	}

	public void dodajPredmetuProfesora(Profesor profesor) {
		// TODO Auto-generated method stub
		Predmet predmet = BazaPredmeta.getInstance().getSelectedPredmet(TabsPanel.tablePredmet.getSelectedRow());
		BazaPredmeta.getInstance().dodajProfesoraPredmetu(predmet, profesor);
		DodavanjeProfesoraPredmetuDialog.tableListaProfesoraPredmeta.update();
	}

	public boolean uklanjanjeProfesoruSaPredmeta() {
		int index_predmeta = TabsPanel.tablePredmet.getSelectedTableRow();
		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(index_predmeta);
		if (p.getPredProf() == null) {
			return false;
		}
		p.getPredProf().getPredmeti().remove(p);
		BazaProfesora.getInstance().uklanjanjeProfesoruSaPredmeta(p);
		return true;
	}

}
