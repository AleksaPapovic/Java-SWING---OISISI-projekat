package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.IzmenaPredmetaPanel;

public class IzmenaPredmetaDocumentListener implements DocumentListener {

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