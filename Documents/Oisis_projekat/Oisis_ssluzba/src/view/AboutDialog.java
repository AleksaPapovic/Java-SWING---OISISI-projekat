/*REFERENCA: Vezbe 4, b-dogadjaji, klasa SimpleDialog */ 
package view;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class implements a dialog which is used providing a short decription of jdk
 * and short biographies of authors.
 * 
 * @author Dusan Lekic
 *
 */
public class AboutDialog extends JDialog {
	
	private String tekst="<html>Verzija JDK:JavaSE-1.8<br>"
			+ "JDK 8 je superset JRE 8 i sadrži sve što je u JRE 8, kao i alate poput kompajlera<br>"
			+ "i programa za otklanjanje grešaka neophodnih za razvoj apleta i aplikacija.<br>"
			+ "JRE 8 pruža biblioteke, Java virtuelnu mašinu (JVM) i druge komponente za pokretanje<br>"
			+ "apleta i aplikacija napisanih na programskom jeziku Java. JRE ukljucuje komponente<br>"
			+ "koje nisu potrebne u specifikaciji Java SE, ukljucujuci i standardne<br>"
			+ "i nestandardne Java komponente."
			+ "Dusan Lekić: 20 godina, iz Kraljeva, student na FTN-u Novi Sad, RA smer<br>"
			+ "Aleksa Papović: 21 godina, iz Kraljeva, student na FTN-u Novi Sad, RA smer<br><html>";
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
	public AboutDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(650, 180);
		JPanel pan=new JPanel();
		pan.setLayout(new FlowLayout());
	
		pan.add(new JLabel(tekst));
		
		add(pan);
		
		setLocationRelativeTo(parent);

	}
}
