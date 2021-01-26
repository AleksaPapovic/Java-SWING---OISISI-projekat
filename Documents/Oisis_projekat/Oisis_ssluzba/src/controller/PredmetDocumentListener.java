package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.DodavanjePredmetaDialog;

/**
 * This class implements a document listener which is used to disable buttons
 * depending on the content of the text fields for the dialog which is used for
 * adding subjects.
 * 
 * @author Dusan Lekic
 *
 */
public class PredmetDocumentListener implements DocumentListener {
	
	/**
	 * This method calls the disable button method.
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		disableButton();

	}
	
	/**
	 * This method calls the disable button method.
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		disableButton();

	}
	
	/**
	 * This method calls the disable button method.
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		disableButton();

	}
	
	/**
	 * This method disables buttons depending on the content of the text fields.
	 */
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