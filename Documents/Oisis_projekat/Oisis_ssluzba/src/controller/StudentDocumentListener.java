package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.DodavanjeStudentaDialog;

public class StudentDocumentListener implements DocumentListener{

	@Override
	public void removeUpdate(DocumentEvent e) {
		disableButton();

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		disableButton();

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		disableButton();

	}

	public void disableButton() {

		if (DodavanjeStudentaDialog.imeField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.prezimeField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.datumRField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.adresaSField.getText().isEmpty()
				|| DodavanjeStudentaDialog.brojTField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.emailField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.brIndField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.godUpField.getText().trim().isEmpty()) {
			DodavanjeStudentaDialog.prihvati.setEnabled(false);
		} else {
			DodavanjeStudentaDialog.prihvati.setEnabled(true);
		}
	}

}
