package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ProfesorController;
import model.Profesor;

/**
 * This is dialog for adding subjects to the professor
 * 
 * @author Aleksa Papovic
 *
 */
public class DodavanjePredmetaProfesoruDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is a static professor.
	 */
	public static Profesor profesor;
	/**
	 * This is a static table with subjects.
	 */
	public static TableListaPredmeta tabelaListaPredmeta;

	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param profesor the selected professor
	 */
	@SuppressWarnings("static-access")
	public DodavanjePredmetaProfesoruDialog(JDialog parent, Profesor profesor) {
		super(parent, "Dodaj predmet", true);
		this.setResizable(false);
		this.setSize(450, 400);
		this.setLocationRelativeTo(parent);

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.NORTH);
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		JLabel lbl = new JLabel("Predmeti:");
		panTop.add(lbl, FlowLayout.LEFT);
		this.profesor = profesor;
		JPanel panCenter = new JPanel();
		this.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new BorderLayout());
		tabelaListaPredmeta = new TableListaPredmeta(profesor);
		JScrollPane scrollPanePredmeti = new JScrollPane(tabelaListaPredmeta);
		panCenter.add(scrollPanePredmeti, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaListaPredmeta.getCurrentSelectedRow() != -1) {
					ProfesorController.getInstance().dodajProfesoruPredmet();
				}
				dispose();
			}
		});
		panBottom.add(btnPotvrdi);

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panBottom.add(btnOdustani);

		this.setVisible(true);
	}

}