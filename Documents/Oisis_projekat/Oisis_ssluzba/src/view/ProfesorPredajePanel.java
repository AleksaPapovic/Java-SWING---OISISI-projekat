package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaProfesora;
import model.Profesor;

/**
 * This class implements panel for adding new subject to the professor
 * 
 * 
 * @author Aleksa Papovic
 *
 */
public class ProfesorPredajePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is static table of the list of subjects which are taught by selected professor
	 */
	public static TablePredavaniPredmeti tablePredavaniPredmeti;

	/**
	 * Constructor with parameters where the panel is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 */
	public ProfesorPredajePanel(JDialog parent) {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		JPanel gornji3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
		JButton dodaj = new JButton("Dodaj predmet");
		JButton ukloni = new JButton("Ukloni predmet");
		gornji3.add(dodaj);
		gornji3.add(ukloni);
		JPanel levi3 = new JPanel();
		JPanel desni3 = new JPanel();
		JPanel donji3 = new JPanel();
		levi3.setBackground(Color.WHITE);
		desni3.setBackground(Color.WHITE);
		gornji3.setBackground(Color.WHITE);
		donji3.setBackground(Color.WHITE);
		levi3.setPreferredSize(new Dimension(50, this.getHeight()));
		desni3.setPreferredSize(new Dimension(50, this.getHeight()));
		gornji3.setPreferredSize(new Dimension(this.getWidth(), 60));
		donji3.setPreferredSize(new Dimension(this.getWidth(), 50));
		this.setBackground(Color.white);
		Profesor p = BazaProfesora.getInstance().getSelectedProfesor(TabsPanel.tableProfesor.getSelectedTableRow());
		tablePredavaniPredmeti = new TablePredavaniPredmeti(p);
		JScrollPane scrollPane3 = new JScrollPane(tablePredavaniPredmeti);
		scrollPane3.getViewport().setBackground(Color.WHITE);
		this.add(scrollPane3, BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
		this.add(levi3, BorderLayout.WEST);
		this.add(desni3, BorderLayout.EAST);
		this.add(gornji3, BorderLayout.NORTH);
		this.add(donji3, BorderLayout.SOUTH);

		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				@SuppressWarnings("unused")
				DodavanjePredmetaProfesoruDialog dodavanjePredmetaProfesoruDialog = new DodavanjePredmetaProfesoruDialog(
						parent, p);
			}
		});

	}

}