package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.DodavanjeProfesoraDialog;

public class DocumentListenerProfesorFields implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			DodavanjeProfesoraDialog.prihvati.setEnabled(true);
		} else {
			DodavanjeProfesoraDialog.prihvati.setEnabled(false);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			DodavanjeProfesoraDialog.prihvati.setEnabled(true);
		} else {
			DodavanjeProfesoraDialog.prihvati.setEnabled(false);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			DodavanjeProfesoraDialog.prihvati.setEnabled(true);
		} else {
			DodavanjeProfesoraDialog.prihvati.setEnabled(false);
		}
	}

	public boolean proveriPolja() {
		boolean ret = false;

		if (ProfesorController.getInstance().proveriImeP(DodavanjeProfesoraDialog.imeField.getText().trim())
				&& ProfesorController.getInstance().proveriImeP(DodavanjeProfesoraDialog.prezimeField.getText().trim())
				&& ProfesorController.getInstance().proveriDatumR(DodavanjeProfesoraDialog.datumRField.getText().trim())
				&& ProfesorController.getInstance()
						.proveriAdresuSK(DodavanjeProfesoraDialog.adresaSField.getText().trim())
				&& ProfesorController.getInstance()
						.proveriBrojTel(DodavanjeProfesoraDialog.kontaktTelField.getText().trim())
				&& ProfesorController.getInstance().proveriEmail(DodavanjeProfesoraDialog.emailField.getText().trim())
				&& ProfesorController.getInstance()
						.proveriAdresuSK(DodavanjeProfesoraDialog.adresaKField.getText().trim())
				&& ProfesorController.getInstance()
						.proveriBrojLK(DodavanjeProfesoraDialog.brlkField.getText().trim())) {

			ret = true;
		}

		if (DodavanjeProfesoraDialog.imeField.getSablon().equals(DodavanjeProfesoraDialog.imeField.getText().trim())
				|| DodavanjeProfesoraDialog.prezimeField.getSablon()
						.equals(DodavanjeProfesoraDialog.prezimeField.getText().trim())
				|| DodavanjeProfesoraDialog.datumRField.getSablon()
						.equals(DodavanjeProfesoraDialog.datumRField.getText().trim())
				|| DodavanjeProfesoraDialog.adresaSField.getSablon()
						.equals(DodavanjeProfesoraDialog.adresaKField.getText().trim())
				|| DodavanjeProfesoraDialog.kontaktTelField.getSablon()
						.equals(DodavanjeProfesoraDialog.kontaktTelField.getText().trim())
				|| DodavanjeProfesoraDialog.emailField.getSablon()
						.equals(DodavanjeProfesoraDialog.emailField.getText().trim())
				|| DodavanjeProfesoraDialog.adresaKField.getSablon()
						.equals(DodavanjeProfesoraDialog.adresaKField.getText().trim())
				|| DodavanjeProfesoraDialog.brlkField.getSablon()
						.equals(DodavanjeProfesoraDialog.brlkField.getText().trim())) {

			ret = false;
		}

		return ret;
	}

}
