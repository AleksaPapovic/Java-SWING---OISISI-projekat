package view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
/**
 * This class implements a dialog which is used for editing a selected existing professor.
 * 
 * @author Aleksa Papovic
 *
 */	
public class IzmenaProfesoraDialog extends JDialog {

	private static final long serialVersionUID = -2808959874444229630L;
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public IzmenaProfesoraDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setTitle("Izmena profesora");
		setSize(600, 650);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		TabsIzmenaProfesora taboviIzmenaProfesora = new TabsIzmenaProfesora(this);
		add(taboviIzmenaProfesora, BorderLayout.NORTH);

		this.setVisible(true);

	}
}
