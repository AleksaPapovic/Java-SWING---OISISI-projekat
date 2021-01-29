package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.UpisOceneDialog;
/**
 * This class implements a document listener which is used to disable buttons
 * depending on the content of the text fields for the dialog which is used for
 * adding grades.
 * 
 * @author Aleksa Papovic
 *
 */
public class DocumentListenerUpis implements DocumentListener {

	/**
	 *  Default constructor with no parameters.
	 *  
	 */
	public DocumentListenerUpis() {}
	
	/**
	 * This method calls the disable and the enable button method when change one of
	 * inserted sign.
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}
	/**
	 * This method calls the disable and the enable button method when insert new
	 * sign.
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}
	/**
	 * This method calls the disable and the enable button method when remove sign.
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			UpisOceneDialog.prihvatiUpis.setEnabled(true);
		} else {
			UpisOceneDialog.prihvatiUpis.setEnabled(false);
		}
	}
	/**
	 * This method disables buttons depending on the content of the text fields.
	 * 
	 * @return true or false depends if fields are valid
	 */
	public boolean proveriPolja() {
		boolean ret = false;

		if (ProfesorController.getInstance().proveriDatumR(UpisOceneDialog.datumUpisaField.getText().trim())) {
			ret = true;
		}
		return ret;
	}

}
