package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.PredmetController;
import model.BazaProfesora;
import model.Predmet;
/**
 * This class implements a dialog which is used for adding a new professor to the
 * selected subject.
 * 
 * @author Dusan Lekic
 *
 */	
public class DodavanjeProfesoraPredmetuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Predmet predmet;
	public static TableListaProfesoraPredmeta tableListaProfesoraPredmeta;
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and components are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 */
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
		/**
		 * This action listener specifies the action for the 'potvrdi' button.
		 */
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
		/**
		 * This action listener specifies the action for the 'odustani' button.
		 */
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
