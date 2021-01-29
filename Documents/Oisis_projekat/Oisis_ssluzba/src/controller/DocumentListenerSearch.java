package controller;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * This class implements a document listener which is used to disable buttons
 * depending on the content of the text fields for the dialog which is used for
 * search bar.
 * 
 * @author Aleksa Papovic
 *
 */
public class DocumentListenerSearch implements DocumentListener {

	/**
	 *  Default constructor with no parameters.
	 *  
	 */
	public DocumentListenerSearch() {}
	
	/**
	 * This method calls the disable and the enable button method when change one of
	 * inserted sign.
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * This method calls the disable and the enable button method when insert new
	 * sign.
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * This method calls the disable and the enable button method when remove sign.
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
