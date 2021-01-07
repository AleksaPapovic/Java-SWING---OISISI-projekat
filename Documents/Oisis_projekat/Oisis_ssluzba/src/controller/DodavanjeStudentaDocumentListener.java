package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.DodavanjeStudentaDialog;

public class DodavanjeStudentaDocumentListener implements DocumentListener {

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
				&& !DodavanjeStudentaDialog.imeField.getSablon()
						.equals(DodavanjeStudentaDialog.imeField.getText().trim())
				&& StudentController.getInstance().proveriIme(DodavanjeStudentaDialog.prezimeField.getText().trim())
				&& !DodavanjeStudentaDialog.prezimeField.getSablon()
						.equals(DodavanjeStudentaDialog.prezimeField.getText().trim())
				&& StudentController.getInstance().proveriDatumR(DodavanjeStudentaDialog.datumRField.getText().trim())
				&& !DodavanjeStudentaDialog.datumRField.getSablon()
						.equals(DodavanjeStudentaDialog.datumRField.getText().trim())
				&& StudentController.getInstance()
						.proveriAdresuSt(DodavanjeStudentaDialog.adresaSField.getText().trim())
				&& !DodavanjeStudentaDialog.adresaSField.getSablon()
						.equals(DodavanjeStudentaDialog.adresaSField.getText().trim())
				&& StudentController.getInstance().proveriKontaktTl(DodavanjeStudentaDialog.brojTField.getText().trim())
				&& !DodavanjeStudentaDialog.brojTField.getSablon()
						.equals(DodavanjeStudentaDialog.brojTField.getText().trim())
				&& StudentController.getInstance().proveriEmail(DodavanjeStudentaDialog.emailField.getText().trim())
				&& !DodavanjeStudentaDialog.emailField.getSablon()
						.equals(DodavanjeStudentaDialog.emailField.getText().trim())
				&& StudentController.getInstance().proveriBrojInd(DodavanjeStudentaDialog.brIndField.getText().trim())
				&& !DodavanjeStudentaDialog.brIndField.getSablon()
						.equals(DodavanjeStudentaDialog.brIndField.getText().trim())
				&& StudentController.getInstance().proveriGodUp(DodavanjeStudentaDialog.godUpField.getText().trim())
				&& !DodavanjeStudentaDialog.godUpField.getSablon()
						.equals(DodavanjeStudentaDialog.godUpField.getText().trim())) {
			DodavanjeStudentaDialog.prihvati.setEnabled(true);
		} else {
			DodavanjeStudentaDialog.prihvati.setEnabled(false);
		}
	}

}
