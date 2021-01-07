package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.IzmenaStudentaPanel;

public class IzmenaStudentaDocumentListener implements DocumentListener {

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

		if (StudentController.getInstance().proveriIme(IzmenaStudentaPanel.imeIzmena.getText().trim())
				&& !IzmenaStudentaPanel.imeIzmena.getSablon().equals(IzmenaStudentaPanel.imeIzmena.getText().trim())
				&& StudentController.getInstance().proveriIme(IzmenaStudentaPanel.prezimeIzmena.getText().trim())
				&& !IzmenaStudentaPanel.prezimeIzmena.getSablon()
						.equals(IzmenaStudentaPanel.prezimeIzmena.getText().trim())
				&& StudentController.getInstance().proveriDatumR(IzmenaStudentaPanel.datumRIzmena.getText().trim())
				&& !IzmenaStudentaPanel.datumRIzmena.getSablon()
						.equals(IzmenaStudentaPanel.datumRIzmena.getText().trim())
				&& StudentController.getInstance().proveriAdresuSt(IzmenaStudentaPanel.adresaSIzmena.getText().trim())
				&& !IzmenaStudentaPanel.adresaSIzmena.getSablon()
						.equals(IzmenaStudentaPanel.adresaSIzmena.getText().trim())
				&& StudentController.getInstance().proveriKontaktTl(IzmenaStudentaPanel.brojTIzmena.getText().trim())
				&& !IzmenaStudentaPanel.brojTIzmena.getSablon().equals(IzmenaStudentaPanel.brojTIzmena.getText().trim())
				&& StudentController.getInstance().proveriEmail(IzmenaStudentaPanel.emailIzmena.getText().trim())
				&& !IzmenaStudentaPanel.emailIzmena.getSablon().equals(IzmenaStudentaPanel.emailIzmena.getText().trim())
				&& StudentController.getInstance().proveriGodUp(IzmenaStudentaPanel.godUpIzmena.getText().trim())
				&& !IzmenaStudentaPanel.godUpIzmena.getSablon()
						.equals(IzmenaStudentaPanel.godUpIzmena.getText().trim())) {
			IzmenaStudentaPanel.prihvatiIzmena.setEnabled(true);
		} else {
			IzmenaStudentaPanel.prihvatiIzmena.setEnabled(false);
		}
	}

}