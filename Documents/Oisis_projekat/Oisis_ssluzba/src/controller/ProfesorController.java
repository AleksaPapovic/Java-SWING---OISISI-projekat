/*REFERENCA: VEZBE 6, IgraciController klasa*/
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaProfesora;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.DodavanjeProfesoraDialog;
import view.IzmenaProfesoraPanel;
import view.TabsPanel;

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
		profesor.setIme(ime);
		profesor.setPrezime(prezime);
		Date dateR = BazaProfesora.parseDate(datumR);
		profesor.setDatumR(dateR);
		System.out.printf(dateR.toString());

		profesor.setEmail(email);
		profesor.setAdresaS(adresaS);
		profesor.setKontaktTel(kontaktTel);
		profesor.setAdresaK(adresaK);
		profesor.setBrlk(brlk);
		profesor.setTitula(titula);

		BazaProfesora.getInstance().dodajProfesora(profesor.getPrezime(), profesor.getIme(), profesor.getDatumR(),
				profesor.getAdresaS(), profesor.getKontaktTel(), profesor.getEmail(), profesor.getAdresaK(),
				profesor.getBrlk(), titula, zvanje);

		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();

		return true;
	}

	public boolean proveriImeP(String imeP) {
		boolean ret = true;

		if (imeP.isEmpty() || Character.isLowerCase(imeP.charAt(0))) {
			ret = false;
		}
		return ret;

	}

	public boolean proveriDatumR(String datumRodjenja) {

		boolean ret = true;
		@SuppressWarnings("unused")
		Date dateR = new Date();
		try {
			dateR = new SimpleDateFormat("dd.mm.yyyy.").parse(datumRodjenja);
			ret = true;
		} catch (ParseException e) {
			ret = false;
		}
		return ret;
	}

	public boolean proveriBrojTel(String kontaktTel) {
		boolean ret = true;
		if (!kontaktTel.matches("[0-9]{9,}")) {
			ret = false;
		}
		return ret;

	}

	public boolean proveriEmail(String email) {
		boolean ret = true;
		if (email.contains("@") && email.matches("[a-zA-Z0-9\\.]{1,30}[@][a-zA-Z\\.]{5,30}")) {
		} else {

			ret = false;
		}
		return ret;
	}

	public boolean proveriBrojLK(String brlk) {
		boolean ret = true;

		if (!brlk.matches("[0-9]{9}")) {
			ret = false;
		}

		for (Profesor p : BazaProfesora.getInstance().getProfesoriSvi()) {
			if (p.getBrlk().equals(brlk)) {
				ret = false;
			}
		}
		return ret;
	}

	public boolean proveriAdresuSK(String adresa) {
		boolean ret = true;

		if (adresa.isEmpty()) {
			ret = false;
		}

		return ret;
	}

	public boolean izmeniProfesora() {
		String ime = IzmenaProfesoraPanel.imeIzmena.getText();
		String prezime = IzmenaProfesoraPanel.prezimeIzmena.getText();
		String datumR = IzmenaProfesoraPanel.datumRIzmena.getText();
		String adresaS = IzmenaProfesoraPanel.adresaSIzmena.getText();
		String kontaktTel = IzmenaProfesoraPanel.kontaktTelIzmena.getText();
		String email = IzmenaProfesoraPanel.emailIzmena.getText();
		String adresaK = IzmenaProfesoraPanel.adresaKIzmena.getText();
		String brlk = IzmenaProfesoraPanel.brlkIzmena.getText();
		String comboTitula = IzmenaProfesoraPanel.combobox1Izmena.getSelectedItem().toString();
		String comboZvanje = IzmenaProfesoraPanel.combobox2Izmena.getSelectedItem().toString();
		Titula titula;
		Zvanje zvanje;
		Date dateR = BazaProfesora.parseDate(datumR);

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

		int index_izmenjenog = TabsPanel.tableProfesor.getSelectedTableRow();
		Profesor izmenjeniProfesor = new Profesor(prezime, ime, dateR, adresaS, kontaktTel, email, adresaK, brlk,
				titula, zvanje);
		BazaProfesora.getInstance().izmeniProfesora(izmenjeniProfesor, index_izmenjenog);
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
		return true;
	}

	public boolean izbrisiProfesora(int index) {

		BazaProfesora.getInstance().izbrisiProfesora(index);
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
		return true;

	}

	public void pretragaProfesora(String text) {
		BazaProfesora.getInstance().pretraziProfesora(text);
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
	}

}
