package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.IzmenaPredmetaPanel;

/**
 * This class implements a document listener which is used to disable buttons
 * depending on the content of the text fields for the dialog which is used for
 * editing subjects.
 * 
 * @author Dusan Lekic
 *
 */
public class IzmenaPredmetaDocumentListener implements DocumentListener {

	/**
	 * This method disables button.
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		disableButton();

	}

	/**
	 * This method disables button.
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		disableButton();

	}

	/**
	 * This method disables button.
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		disableButton();

	}
	
	/**
	 * This method disables buttons depending on the content of the text fields.
	 */
	public void disableButton() {

		if (PredmetController.getInstance().proveriIme(IzmenaPredmetaPanel.imePredIzmena.getText().trim())
				&& !IzmenaPredmetaPanel.imePredIzmena.getSablon()
						.equals(IzmenaPredmetaPanel.sifraIzmena.getText().trim())
				&& PredmetController.getInstance().proveriSifru(IzmenaPredmetaPanel.sifraIzmena.getText().trim())
				&& !IzmenaPredmetaPanel.sifraIzmena.getSablon().equals(IzmenaPredmetaPanel.sifraIzmena.getText().trim())
				&& PredmetController.getInstance().proveriESPB(IzmenaPredmetaPanel.espbIzmena.getText().trim())
				&& !IzmenaPredmetaPanel.espbIzmena.getSablon()
						.equals(IzmenaPredmetaPanel.espbIzmena.getText().trim())) {
			IzmenaPredmetaPanel.prihvatiIzmena.setEnabled(true);
		} else {
			IzmenaPredmetaPanel.prihvatiIzmena.setEnabled(false);
		}
	}

}