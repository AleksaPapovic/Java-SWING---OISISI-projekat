package controller;

import javax.swing.JOptionPane;

import gui.DodavanjeProfesoraDialog;
import gui.MainFrame;
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

		if (DodavanjeProfesoraDialog.imeField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.prezimeField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.datumRField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.adresaSField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.kontaktTelField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.emailField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.adresaKField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.brlkField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate uneti sve podatke");
			return false;
		}
		String ime = DodavanjeProfesoraDialog.imeField.getText();
		String prezime = DodavanjeProfesoraDialog.prezimeField.getText();
		String datumR = DodavanjeProfesoraDialog.datumRField.getText();
		String adresaS = DodavanjeProfesoraDialog.adresaSField.getText();
		String kontaktTel = DodavanjeProfesoraDialog.kontaktTelField.getText();
		String email = DodavanjeProfesoraDialog.emailField.getText();
		String adresaK = DodavanjeProfesoraDialog.adresaKField.getText();
		String brlk = DodavanjeProfesoraDialog.brlkField.getText();
		int indexTitule = DodavanjeProfesoraDialog.combobox1.getSelectedIndex();
		int indexZvanja = DodavanjeProfesoraDialog.combobox2.getSelectedIndex();
		Titula t = Titula.values()[indexTitule];
		Zvanje z = Zvanje.values()[indexZvanja];

		profesor.setIme(ime);
		profesor.setPrezime(prezime);
		profesor.setDatumR(datumR);
		profesor.setAdresaS(adresaS);
		profesor.setKontaktTel(kontaktTel);
		profesor.setEmail(email);
		profesor.setAdresaK(adresaK);
		profesor.setBrlk(brlk);
		profesor.setTitula(t);
		profesor.setZvanje(z);

		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
		
		}

		BazaProfesora.getInstance().dodajProfesora(profesor.getPrezime(), profesor.getIme(), profesor.getDatumR(),
				profesor.getAdresaS(), profesor.getKontaktTel(), profesor.getEmail(), profesor.getAdresaK(),
				profesor.getBrlk(), null, null);

		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();

		return true;
	}

}
