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

		if (StudentController.getInstance().proveriIme(DodavanjeStudentaDialog.imeField.getText().trim())
				&& StudentController.getInstance().proveriIme(DodavanjeStudentaDialog.prezimeField.getText().trim())
				&& StudentController.getInstance().proveriDatumR(DodavanjeStudentaDialog.datumRField.getText().trim())
				&& StudentController.getInstance()
						.proveriAdresuSt(DodavanjeStudentaDialog.adresaSField.getText().trim())
				&& StudentController.getInstance()
						.proveriKontaktTl(DodavanjeStudentaDialog.brojTField.getText().trim())
				&& StudentController.getInstance().proveriEmail(DodavanjeStudentaDialog.emailField.getText().trim())
				&& StudentController.getInstance()
						.proveriBrojInd(DodavanjeStudentaDialog.brIndField.getText().trim())
				&& StudentController.getInstance()
						.proveriGodUp(DodavanjeStudentaDialog.godUpField.getText().trim())) {
			DodavanjeStudentaDialog.prihvati.setEnabled(true);
		} else {
			DodavanjeStudentaDialog.prihvati.setEnabled(false);
		}
	}

}
