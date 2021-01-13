package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.UpisOceneDialog;

public class DocumentListenerUpis implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}

	public boolean proveriPolja() {
		boolean ret = false;

		if (ProfesorController.getInstance().proveriDatumR(UpisOceneDialog.datumUpisaField.getText().trim())) {
			ret = true;
		}
		return ret;
	}

}
