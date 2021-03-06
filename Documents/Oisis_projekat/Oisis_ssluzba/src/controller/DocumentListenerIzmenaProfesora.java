package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.IzmenaProfesoraPanel;

/**
 * This class implements a document listener which is used to disable buttons
 * depending on the content of the text fields for the dialog which is used for
 * change professor data.
 * 
 * @author Aleksa Papovic
 *
 */

public class DocumentListenerIzmenaProfesora implements DocumentListener {
	
	/**
	 *  Default constructor with no parameters.
	 *  
	 */
	public DocumentListenerIzmenaProfesora() {}
	
	/**
	 * This method calls the disable and the enable button method when change one of
	 * inserted sign.
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(true);
		} else {
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(false);
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
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(true);
		} else {
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(false);
		}
	}

	/**
	 * This method calls the disable and the enable button method when remove sign.
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		if (proveriPolja()) {
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(true);
		} else {
			IzmenaProfesoraPanel.prihvatiIzmena.setEnabled(false);
		}
	}
	/**
	 * This method disables buttons depending on the content of the text fields.
	 * 
	 * @return true or false depends if fields are valid
	 */
	public boolean proveriPolja() {
		boolean ret = false;

		if (ProfesorController.getInstance().proveriImeP(IzmenaProfesoraPanel.imeIzmena.getText().trim())
				&& ProfesorController.getInstance().proveriImeP(IzmenaProfesoraPanel.prezimeIzmena.getText().trim())
				&& ProfesorController.getInstance().proveriDatumR(IzmenaProfesoraPanel.datumRIzmena.getText().trim())
				&& ProfesorController.getInstance().proveriAdresuSK(IzmenaProfesoraPanel.adresaSIzmena.getText().trim())
				&& ProfesorController.getInstance()
						.proveriBrojTel(IzmenaProfesoraPanel.kontaktTelIzmena.getText().trim())
				&& ProfesorController.getInstance().proveriEmail(IzmenaProfesoraPanel.emailIzmena.getText().trim())
				&& ProfesorController.getInstance()
						.proveriAdresuSK(IzmenaProfesoraPanel.adresaKIzmena.getText().trim())) {

			ret = true;
		}

		if (IzmenaProfesoraPanel.imeIzmena.getSablon().equals(IzmenaProfesoraPanel.imeIzmena.getText().trim())
				|| IzmenaProfesoraPanel.prezimeIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.prezimeIzmena.getText().trim())
				|| IzmenaProfesoraPanel.datumRIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.datumRIzmena.getText().trim())
				|| IzmenaProfesoraPanel.adresaSIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.adresaKIzmena.getText().trim())
				|| IzmenaProfesoraPanel.kontaktTelIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.kontaktTelIzmena.getText().trim())
				|| IzmenaProfesoraPanel.emailIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.emailIzmena.getText().trim())
				|| IzmenaProfesoraPanel.adresaKIzmena.getSablon()
						.equals(IzmenaProfesoraPanel.adresaKIzmena.getText().trim())) {

			ret = false;
		}

		return ret;
	}
}