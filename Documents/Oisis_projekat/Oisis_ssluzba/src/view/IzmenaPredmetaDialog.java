package view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
/**
 * This class implements a dialog which is used for editing a selected existing subject.
 * 
 * @author Dusan Lekic
 *
 */	
public class IzmenaPredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4936262418771654628L;
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public IzmenaPredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setTitle("Izmena predmeta");
		setSize(600, 650);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		IzmenaPredmetaTabs izmenaPredmetaTabovi = new IzmenaPredmetaTabs(this);
		add(izmenaPredmetaTabovi, BorderLayout.NORTH);

		
		
		this.setVisible(true);

	}
}