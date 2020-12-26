/*REFERENCA: VEZBE 6, IgraciController klasa*/
package controller;

import javax.swing.JOptionPane;

import gui.DodavanjeProfesoraDialog;
import gui.TabsPanel;
import model.BazaProfesora;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class ProfesorController {

	private static ProfesorController instance = null;

	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

	private ProfesorController() {
	}

	public boolean dodatiProfesora() {
		Profesor profesor = new Profesor();

		String ime = DodavanjeProfesoraDialog.imeField.getText();
		String prezime = DodavanjeProfesoraDialog.prezimeField.getText();
		String datumR = DodavanjeProfesoraDialog.datumRField.getText();
		String adresaS = DodavanjeProfesoraDialog.adresaSField.getText();
		String kontaktTel = DodavanjeProfesoraDialog.kontaktTelField.getText();
		String email = DodavanjeProfesoraDialog.emailField.getText();
		String adresaK = DodavanjeProfesoraDialog.adresaKField.getText();
		String brlk = DodavanjeProfesoraDialog.brlkField.getText();
		String comboTitula = DodavanjeProfesoraDialog.combobox1.getSelectedItem().toString();
		String comboZvanje = DodavanjeProfesoraDialog.combobox2.getSelectedItem().toString();
		Titula titula;
		Zvanje zvanje;

		switch (comboTitula) {
		case "Master":
			titula = Titula.Ms;
			break;
		case "Doktor":
			titula = Titula.Dr;
			break;
		case "Profesor doktor":
			titula = Titula.ProfDr;
			break;
		default:
			titula = null;
			return false;
		}

		switch (comboZvanje) {
		case "Asistent":
			zvanje = Zvanje.Asistent;
			break;
		case "Docent":
			zvanje = Zvanje.Docent;
			break;
		case "Vanredni Profesor":
			zvanje = Zvanje.VProfesor;
			break;
		case "Redovni Profesor":
			zvanje = Zvanje.RProfesor;
			break;
		case "Saradnik":
			zvanje = Zvanje.Saradnik;
			break;
		default:
			zvanje = null;
			return false;
		}

		if (Character.isUpperCase(ime.charAt(0))) {
			profesor.setIme(ime);
		} else {
			JOptionPane.showMessageDialog(null, "Greška ime mora početi velikim slovom");
			return false;
		}

		if (Character.isUpperCase(prezime.charAt(0))) {
			profesor.setPrezime(prezime);
		} else {
			JOptionPane.showMessageDialog(null, "Greška prezime mora početi velikim slovom");
			return false;
		}

		if (datumR.matches("[0-9]{2}[\\.]{1}[0-9]{2}[\\.]{1}[0-9]{4}[\\.]{1}")) {
			String dateR[] = datumR.split("\\.");
			int dan = Integer.parseInt(dateR[0]);
			int mesec = Integer.parseInt(dateR[1]);
			if (dan > 31 || mesec > 12) {
				JOptionPane.showMessageDialog(null, "Greška uneli ste pogresan dan ili mesec");
				return false;
			} else {
				profesor.setDatumR(datumR);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Greška datum mora biti u formatu dd.mm.yyyy.");
			return false;
		}

		if (email.contains("@")) {
			profesor.setEmail(email);
		} else {
			JOptionPane.showMessageDialog(null, "Greška email mora imati @ ");
			return false;
		}

		profesor.setAdresaS(adresaS);

		if (kontaktTel.matches("[0-9]{9,}")) {
			profesor.setKontaktTel(kontaktTel);
		} else {
			JOptionPane.showMessageDialog(null, "Greška kontakt telefon mora imati bar 9 brojeva");
			return false;
		}

		profesor.setAdresaK(adresaK);

		if (brlk.matches("[0-9]{9}")) {
			profesor.setBrlk(brlk);
		} else {
			JOptionPane.showMessageDialog(null, "Greška broj lične karte  mora imati 9 brojeva");
			return false;
		}

		profesor.setTitula(titula);

		BazaProfesora.getInstance().dodajProfesora(profesor.getPrezime(), profesor.getIme(), profesor.getDatumR(),
				profesor.getAdresaS(), profesor.getKontaktTel(), profesor.getEmail(), profesor.getAdresaK(),
				profesor.getBrlk(), titula, zvanje);

		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();

		return true;
	}

}
