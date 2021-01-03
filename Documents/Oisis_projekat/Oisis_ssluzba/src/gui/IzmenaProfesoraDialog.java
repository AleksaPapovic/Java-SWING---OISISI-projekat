package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

public class IzmenaProfesoraDialog extends JDialog {

	private static final long serialVersionUID = -2808959874444229630L;

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
