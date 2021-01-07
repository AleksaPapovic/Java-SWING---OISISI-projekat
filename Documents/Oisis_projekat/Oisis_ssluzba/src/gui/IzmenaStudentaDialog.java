package gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

public class IzmenaStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4936262418771654628L;

	public IzmenaStudentaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setTitle("Izmena studenta");
		setSize(600, 650);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		IzmenaStudentaTabs izmenaStudentaTabovi = new IzmenaStudentaTabs(this);
		add(izmenaStudentaTabovi, BorderLayout.NORTH);

		this.setVisible(true);

	}
}