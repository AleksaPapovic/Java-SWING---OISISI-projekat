package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabsIzmenaProfesora extends JTabbedPane {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static int tab_curr_izmenaProf = 0;

	public TabsIzmenaProfesora(JDialog parentDialog) {

		// Tab profesor
		JPanel tabProfesor = new JPanel();
		tabProfesor.setLayout(new BorderLayout());
		JPanel gornji1 = new JPanel();
		JPanel levi1 = new JPanel();
		JPanel desni1 = new JPanel();
		JPanel donji1 = new JPanel();
		levi1.setBackground(Color.WHITE);
		desni1.setBackground(Color.WHITE);
		gornji1.setBackground(Color.WHITE);
		donji1.setBackground(Color.WHITE);
		levi1.setPreferredSize(new Dimension(50, tabProfesor.getHeight()));
		desni1.setPreferredSize(new Dimension(50, tabProfesor.getHeight()));
		gornji1.setPreferredSize(new Dimension(tabProfesor.getWidth(), 15));
		donji1.setPreferredSize(new Dimension(tabProfesor.getWidth(), 50));
		IzmenaProfesoraPanel panelIzmeniProfesora = new IzmenaProfesoraPanel(parentDialog);
		tabProfesor.setBackground(Color.WHITE);
		tabProfesor.add(panelIzmeniProfesora, BorderLayout.CENTER);
		tabProfesor.add(levi1, BorderLayout.WEST);
		tabProfesor.add(desni1, BorderLayout.EAST);
		tabProfesor.add(gornji1, BorderLayout.NORTH);
		tabProfesor.add(donji1, BorderLayout.SOUTH);
		Icon ikonProf = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Info", ikonProf, tabProfesor, "Prikaz informacija selektovanog profesora");

		// Tab profesor i predmeti
		JPanel tabPredmeti = new JPanel();
		tabPredmeti.setLayout(new BorderLayout());
		JPanel gornji2 = new JPanel();
		JPanel donji2 = new JPanel();
		gornji2.setBackground(Color.WHITE);
		donji2.setBackground(Color.WHITE);
		gornji2.setPreferredSize(new Dimension(tabPredmeti.getWidth(), 15));
		donji2.setPreferredSize(new Dimension(tabPredmeti.getWidth(), 50));
		ProfesorPredajePanel panelProfesorPredaje = new ProfesorPredajePanel(parentDialog);
		tabPredmeti.setBackground(Color.WHITE);
		tabPredmeti.add(panelProfesorPredaje, BorderLayout.CENTER);
		tabPredmeti.add(gornji2, BorderLayout.NORTH);
		tabPredmeti.add(donji2, BorderLayout.SOUTH);
		Icon ikonProf2 = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Predmeti", ikonProf2, tabPredmeti, "Prikaz predmeta");
		
		

		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {

				JTabbedPane tabbedPane = (JTabbedPane) event.getSource();
				tab_curr_izmenaProf = tabbedPane.getSelectedIndex();
			}
		});
	}
}