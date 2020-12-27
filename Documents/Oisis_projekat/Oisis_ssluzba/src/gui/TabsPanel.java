/*REFERENCA: VEZBE 5, Tabovi*/
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabsPanel extends JTabbedPane {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static int tab_curr = 0;
	public static TableProfesor tableProfesor;
	public static TableStudent tableStudent;

	public TabsPanel() {

		JPanel gornji = new JPanel();
		JPanel levi = new JPanel();
		JPanel desni = new JPanel();
		JPanel donji = new JPanel();

		// Tab student
		JPanel tabStudent = new JPanel();
		tabStudent.setLayout(new BorderLayout());
		levi.setPreferredSize(new Dimension(50, tabStudent.getHeight()));
		desni.setPreferredSize(new Dimension(50, tabStudent.getHeight()));
		gornji.setPreferredSize(new Dimension(tabStudent.getWidth(), 50));
		donji.setPreferredSize(new Dimension(tabStudent.getWidth(), 50));
		levi.setBackground(Color.WHITE);
		desni.setBackground(Color.WHITE);
		gornji.setBackground(Color.WHITE);
		donji.setBackground(Color.WHITE);
		tableStudent = new TableStudent();
		JScrollPane scrollPane1 = new JScrollPane(tableStudent);
		scrollPane1.getViewport().setBackground(Color.WHITE);
		tabStudent.add(scrollPane1, BorderLayout.CENTER);
		tabStudent.add(levi, BorderLayout.WEST);
		tabStudent.add(desni, BorderLayout.EAST);
		tabStudent.add(gornji, BorderLayout.NORTH);
		tabStudent.add(donji, BorderLayout.SOUTH);
		Icon ikonStud = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Studenti", ikonStud, tabStudent, "Prikaz studenata");

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
		gornji1.setPreferredSize(new Dimension(tabProfesor.getWidth(), 50));
		donji1.setPreferredSize(new Dimension(tabProfesor.getWidth(), 50));
		tabProfesor.setBackground(Color.white);
		tableProfesor = new TableProfesor();
		JScrollPane scrollPane = new JScrollPane(tableProfesor);
		scrollPane.getViewport().setBackground(Color.WHITE);
		tabProfesor.add(scrollPane, BorderLayout.CENTER);
		tabProfesor.add(levi1, BorderLayout.WEST);
		tabProfesor.add(desni1, BorderLayout.EAST);
		tabProfesor.add(gornji1, BorderLayout.NORTH);
		tabProfesor.add(donji1, BorderLayout.SOUTH);
		Icon ikonProf = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Profesori", ikonProf, tabProfesor, "Prikaz profesora");
		// Tab predmet
		JPanel tabPredmet = new JPanel();
		tabPredmet.setLayout(new BorderLayout());
		tabPredmet.setBackground(Color.white);
		TablePredmet tablePredmet = new TablePredmet();
		JScrollPane scrollPane3 = new JScrollPane(tablePredmet);
		tabPredmet.add(scrollPane3, BorderLayout.CENTER);
		Icon ikonPred = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Predmeti", ikonPred, tabPredmet, "Prikaz predmeta");

		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {

				JTabbedPane tabbedPane = (JTabbedPane) event.getSource();
				tab_curr = tabbedPane.getSelectedIndex();
			}
		});
	}
}
