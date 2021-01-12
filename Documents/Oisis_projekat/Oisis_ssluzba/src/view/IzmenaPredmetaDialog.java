package view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

public class IzmenaPredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4936262418771654628L;

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