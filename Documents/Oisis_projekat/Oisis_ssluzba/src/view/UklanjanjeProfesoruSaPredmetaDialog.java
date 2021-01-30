package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;

/**
 * This class implements a dialog which is used for removing professor from the
 * subject
 * 
 * @author Aleksa Papovic
 *
 */
public class UklanjanjeProfesoruSaPredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  This is a static button to confirm the removal.
	 */
	public static JButton da;
	/**
	 *   This is a static button to reject the removal.
	 */
	public static JButton ne;

	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent        the window which the dialog is relative to
	 * @param title         the name of the dialog
	 * @param modal         boolean value which tells us if we have to finish
	 *                      working with
	 * @param profesorFiled text field we need to reset if remove the subject this
	 *                      dialog to switch to other windows or not
	 */
	public UklanjanjeProfesoruSaPredmetaDialog(JDialog parent, String title, boolean modal, JTextField profesorFiled) {
		super(parent, title, modal);
		setTitle(title);
		setSize(300, 120);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		add(panel, BorderLayout.CENTER);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());

		JLabel labela = new JLabel("Da li ste sigurni?");
		panel.add(labela);
		JButton da = new JButton("Da");
		da.setPreferredSize(new Dimension(100, 25));

		da.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (PredmetController.getInstance().uklanjanjeProfesoruSaPredmeta()) {
					profesorFiled.setText("Profesor");
				}

				dispose();
			}

		});

		JButton ne = new JButton("Ne");
		ne.setPreferredSize(new Dimension(100, 25));
		ne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel1.add(da);
		panel1.add(ne);

		add(panel1, BorderLayout.SOUTH);
		setVisible(true);
	}

}