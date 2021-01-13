package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.DodavanjePredmetaDialog;

public class PredmetDocumentListener implements DocumentListener {

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

		if (PredmetController.getInstance().proveriIme(DodavanjePredmetaDialog.imeField.getText().trim())
				&& !DodavanjePredmetaDialog.imeField.getSablon()
						.equals(DodavanjePredmetaDialog.imeField.getText().trim())
				&& PredmetController.getInstance().proveriSifru(DodavanjePredmetaDialog.sifraField.getText().trim())
				&& !DodavanjePredmetaDialog.sifraField.getSablon()
						.equals(DodavanjePredmetaDialog.sifraField.getText().trim())
				&& PredmetController.getInstance().proveriESPB(DodavanjePredmetaDialog.espbField.getText().trim())
				&& !DodavanjePredmetaDialog.espbField.getSablon()
						.equals(DodavanjePredmetaDialog.espbField.getText().trim())) {
			DodavanjePredmetaDialog.prihvati.setEnabled(true);
		} else {
			DodavanjePredmetaDialog.prihvati.setEnabled(false);
		}
	}

}