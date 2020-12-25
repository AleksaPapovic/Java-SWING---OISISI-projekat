package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.DodavanjeProfesoraDialog;

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
		boolean ret = true;
		if (DodavanjeProfesoraDialog.imeField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.prezimeField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.datumRField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.adresaSField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.kontaktTelField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.emailField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.adresaKField.getText().trim().isEmpty()
				|| DodavanjeProfesoraDialog.brlkField.getText().trim().isEmpty()) {
			ret = false;
		}
		return ret;
	}

}
