/*REFERENCA: VEZBE 5, Tabovi*/
package view;

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
/**
 * This class implements tabbedPane for tables
 * 
 * 
 * @author Aleksa Papovic
 *
 */
public class TabsPanel extends JTabbedPane {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/**
	 *  This is a static  value of selected row from table
	 */
	public static int tab_curr = 0;
	/**
	 *  This is a static  table of professors
	 */
	public static TableProfesor tableProfesor;
	/**
	 *  This is a static  table of students
	 */
	public static TableStudent tableStudent;
	/**
	 *  This is a static  table of subjects
	 */
	public static TablePredmet tablePredmet;
/**
 * This is constructor for tabs and add tables to tabs
 */
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
		JPanel gornji2 = new JPanel();
		JPanel levi2 = new JPanel();
		JPanel desni2 = new JPanel();
		JPanel donji2 = new JPanel();
		levi2.setBackground(Color.WHITE);
		desni2.setBackground(Color.WHITE);
		gornji2.setBackground(Color.WHITE);
		donji2.setBackground(Color.WHITE);
		levi2.setPreferredSize(new Dimension(50, tabPredmet.getHeight()));
		desni2.setPreferredSize(new Dimension(50, tabPredmet.getHeight()));
		gornji2.setPreferredSize(new Dimension(tabPredmet.getWidth(), 50));
		donji2.setPreferredSize(new Dimension(tabPredmet.getWidth(), 50));
		tabPredmet.setBackground(Color.white);
		tablePredmet = new TablePredmet();
		JScrollPane scrollPane3 = new JScrollPane(tablePredmet);
		scrollPane3.getViewport().setBackground(Color.WHITE);
		tabPredmet.add(scrollPane3, BorderLayout.CENTER);
		tabPredmet.add(levi2, BorderLayout.WEST);
		tabPredmet.add(desni2, BorderLayout.EAST);
		tabPredmet.add(gornji2, BorderLayout.NORTH);
		tabPredmet.add(donji2, BorderLayout.SOUTH);
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
