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

import controller.PredmetController;
import controller.ProfesorController;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class DodavanjeProfesoraPredmetuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Predmet predmet;
	public static TableListaProfesoraPredmeta tableListaProfesoraPredmeta;

	public DodavanjeProfesoraPredmetuDialog(JDialog parent) {
		super(parent, "Odaberi profesora", true);
		this.setResizable(false);
		this.setSize(450, 400);
		this.setLocationRelativeTo(parent);

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.NORTH);
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		JPanel panCenter = new JPanel();
		this.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new BorderLayout());
		tableListaProfesoraPredmeta = new TableListaProfesoraPredmeta();
		JScrollPane scrollPanePredmeti = new JScrollPane(tableListaProfesoraPredmeta);
		panCenter.add(scrollPanePredmeti, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListaProfesoraPredmeta.getCurrentSelectedRow() != -1) {
					PredmetController.getInstance().dodajPredmetuProfesora(BazaProfesora.getInstance()
							.getSelectedProfesor(tableListaProfesoraPredmeta.getCurrentSelectedRow()));
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
