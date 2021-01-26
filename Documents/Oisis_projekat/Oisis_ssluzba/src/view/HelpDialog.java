/*REFERENCA: Vezbe 4, b-dogadjaji, klasa SimpleDialog */
package view;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class implements a dialog which is used providing help to the user
 * regarding how commands work and what they do.
 * 
 * @author Dusan Lekic
 *
 */
public class HelpDialog extends JDialog {

	public String tekst = "<html>Glavni prozor se sastoji iz Menubar-a, Toolbar-a, <br>Statusbar-a, Searchbar-a u Toolbar-u i centralnog prozora <br>"
			+ "koji prikazuje studente, profesore i predmete. Meniji koji postoje<br> u Menubar-u su File, Edit i Help. File sadrzi stavke <br>"
			+ "New, koja pravi novi entitet i Close, koja zatvara aplikaciju.<br> Edit sadrzi stavke Edit, koja sluzi za menjanje podataka entiteta i<br>"
			+ "i Delete, koja brise postojeci entitet. <br>Help meni sadrzi Help stavku, koja sluzi za pomoc korisniku, i<br>"
			+ "About stavku, koja sluzi za prikaz verzije <br>aplikacije, kao i kratak opis iste.</html>";
	/**
	 * 
	 */
	private static final long serialVersionUID = -2808959874444229630L;
	/**
	 * Constructor with parameters where initialize the dialog and set his
	 * dimensions and components.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public HelpDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 210);
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout());

		pan.add(new JLabel(tekst));

		add(pan);

		setLocationRelativeTo(parent);

	}
}
