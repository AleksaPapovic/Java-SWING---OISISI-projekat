package controller;

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
        case "Ms":
            titula = Titula.Ms;
            break;
        case "Dr":
            titula = Titula.Dr;
            break;
        case "ProfDr":
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
	        case "Vprofesor":
	            zvanje = Zvanje.VProfesor;
	            break;
	        case "RProfesor":
	            zvanje = Zvanje.RProfesor;
	            break;
	        case "Saradnik":
	            zvanje = Zvanje.Saradnik;
	            break;
	        default:
	            zvanje = null;
	           return  false;
	        }
		profesor.setIme(ime);
		profesor.setPrezime(prezime);
		profesor.setDatumR(datumR);
		profesor.setAdresaS(adresaS);
		profesor.setKontaktTel(kontaktTel);
		profesor.setEmail(email);
		profesor.setAdresaK(adresaK);
		profesor.setBrlk(brlk);
		profesor.setTitula(titula);

		

		BazaProfesora.getInstance().dodajProfesora(profesor.getPrezime(), profesor.getIme(), profesor.getDatumR(),
				profesor.getAdresaS(), profesor.getKontaktTel(), profesor.getEmail(), profesor.getAdresaK(),
				profesor.getBrlk(),titula, zvanje);

		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();

		return true;
	}

}
