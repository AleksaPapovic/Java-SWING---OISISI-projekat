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

import controller.StudentController;
import model.BazaPredmeta;
import model.Predmet;
import model.Student;
/**
 * This is dialog for adding subjects to the student
 * 
 * @author Aleksa Papovic
 *
 */
public class DodavanjePredmetaStudentuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is a static subject.
	 */
	public static Predmet predmet;
	/**
	 * This is a static list of subjects for the selected student.
	 */
	public static TableListaPredmetaStudenta tabelaListaPredmetaStudenta;	
	
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param student the selected student
	 */
	
	public DodavanjePredmetaStudentuDialog(JDialog parent, Student student) {
		super(parent, "Dodavanje predmeta", true);
		this.setResizable(false);
		this.setSize(450, 400);
		this.setLocationRelativeTo(parent);

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.NORTH);
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		JLabel lbl = new JLabel("Predmeti:");
		panTop.add(lbl, FlowLayout.LEFT);
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		tabelaListaPredmetaStudenta = new TableListaPredmetaStudenta(student);
		JScrollPane scrollPanePredmeti = new JScrollPane(tabelaListaPredmetaStudenta);
		panCenter.add(scrollPanePredmeti, BorderLayout.CENTER);
		
		this.add(panCenter, BorderLayout.CENTER);
		
		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		
		
		JButton btnPotvrdi = new JButton("Dodaj");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaListaPredmetaStudenta.getSelectedRow() != -1) {
					String sifraSel = (String)tabelaListaPredmetaStudenta.getValueAt(tabelaListaPredmetaStudenta.getSelectedRow(), 0);
					String []niz=sifraSel.trim().split(" ");
					for (Predmet pr : BazaPredmeta.getInstance().getPredmeti()) {
						if(pr.getSifraP().equals(niz[0])) {
							predmet = pr;
							break;
						}
					}
					StudentController.getInstance().dodajStudentuPredmet(predmet);
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
