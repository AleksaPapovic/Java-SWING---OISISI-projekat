/*REFERENCA: VEZBE 6, IgraciController klasa*/
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.DodavanjePredmetaProfesoruDialog;
import view.DodavanjeProfesoraDialog;
import view.IzmenaProfesoraPanel;
import view.ProfesorPredajePanel;
import view.TabsPanel;
/**
 * This class connects the model and view components for the selected professor
 * and calls the methods which are used to modify him.
 * 
 * @author Aleksa Papovic
 *
 */
public class ProfesorController {

	private static ProfesorController instance = null;
	/**
	 * This method implements the instance as a singleton(it can only be instanced
	 * once).
	 * 
	 * @return the given instance
	 */
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	/**
	 * Default constructor with no parameters.
	 */
	private ProfesorController() {
	}
	/**
	 * This method implements the action of getting data from the dialog ,creating
	 * an instance of the professor and adding that instance to the model of a
	 * professor.
	 * 
	 * @return true or false depending on the success of the method
	 */
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
	/**
	 * This method checks if the name of a professor is valid.
	 * @param imeP the name of the professor
	 * @return true or false depending on the validity of the name
	 */
	public boolean proveriImeP(String imeP) {
		boolean ret = true;

		if (imeP.isEmpty() || Character.isLowerCase(imeP.charAt(0))) {
			ret = false;
		}
		return ret;

	}
	/**
	 * This method checks if the birth date of a professor is valid.
	 * @param datumRodjenja the name of the professor
	 * @return true or false depending on the validity of the date
	 */
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
	/**
	 * This method checks if the contact info of a professor is valid.
	 * @param kontaktTel the contact info of a professor
	 * @return  true or false depending on the validity of the number
	 */
	public boolean proveriBrojTel(String kontaktTel) {
		boolean ret = true;
		if (!kontaktTel.matches("[0-9]{9,}")) {
			ret = false;
		}
		return ret;

	}
	/**
	 *  This method checks if the email of a professor is valid.
	 * @param email the email of a professor
	 * @return  true or false depending on the validity of the email
	 */
	public boolean proveriEmail(String email) {
		boolean ret = true;
		if (email.contains("@") && email.matches("[a-zA-Z0-9\\.]{1,30}[@][a-zA-Z\\.]{5,30}")) {
		} else {

			ret = false;
		}
		return ret;
	}
	/**
	 *  This method checks if the ID number of a professor is valid.
	 * @param brlk the ID number of a professor
	 * @return true or false depending on the validity of the ID number
	 */
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
	/**
	 *  This method checks if the adress of a professor is valid.
	 * @param adresa adress of a professor or his office
	 * @return true or false depending on the validity of the adress
	 */
	public boolean proveriAdresuSK(String adresa) {
		boolean ret = true;

		if (adresa.isEmpty()) {
			ret = false;
		}

		return ret;
	}
	/**
	 * This method implements the action of getting data from the dialog ,changing
	 * the data of a professor and adding those changes model of a professor.
	 * 
	 * @return true or false depending on the success of the method
	 */
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
	/**
	 * 
	 * This method implements the action of deleting a selected professor from the model.
	 * 
	 * 
	 * @param index the index from the selected table row
	 * @return true or false depending on the success of the method
	 */
	public boolean izbrisiProfesora(int index) {

		BazaProfesora.getInstance().izbrisiProfesora(index);
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
		return true;

	}
	/**
	 *  This method implements the action of searching for a given text through the searchbar.
	 * @param text text forwarded through the searchbar
	 */
	public void pretragaProfesora(String text) {
		BazaProfesora.getInstance().pretraziProfesora(text);
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
	}
	/**
	 * This method adds subjects to the professor in the model
	 * 
	 * 
	 */
	public void dodajProfesoruPredmet() {
		ArrayList<Predmet> predmeti = BazaProfesora.getInstance()
				.getNePredajePredmeteProfesor(DodavanjePredmetaProfesoruDialog.profesor);
		ArrayList<Predmet> predmetiPredaje = new ArrayList<Predmet>();
		int[] rows = DodavanjePredmetaProfesoruDialog.tabelaListaPredmeta.getMultipleSelectedRows();
		for (int i : rows) {
			predmetiPredaje.add(predmeti.get(i));
		}
		for (Predmet predmet : predmetiPredaje) {
			predmet.setPredProf(DodavanjePredmetaProfesoruDialog.profesor);
		}
		BazaProfesora.getInstance().dodajPredmetePofesoru(DodavanjePredmetaProfesoruDialog.profesor, predmetiPredaje);
		DodavanjePredmetaProfesoruDialog.tabelaListaPredmeta.azurirajPrikaz();
		ProfesorPredajePanel.tablePredavaniPredmeti.azuriranjeTabelePredavaniPredmeti();
	}

}
