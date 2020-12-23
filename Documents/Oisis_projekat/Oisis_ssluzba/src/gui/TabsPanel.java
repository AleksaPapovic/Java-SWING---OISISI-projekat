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

public class TabsPanel extends JTabbedPane {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public TabsPanel(){
	
	JPanel  gornji = new JPanel();
	JPanel  levi = new JPanel();
	JPanel  desni = new JPanel();
	JPanel  donji = new JPanel();
	
		//Tab student
		JPanel  tabStudent = new JPanel();
		tabStudent.setLayout(new BorderLayout());
		levi.setPreferredSize(new Dimension(50,tabStudent.getHeight()));
		desni.setPreferredSize(new Dimension(50,tabStudent.getHeight()));
		gornji.setPreferredSize(new Dimension(tabStudent.getWidth(),50));
		donji.setPreferredSize(new Dimension(tabStudent.getWidth(),50));
		tabStudent.setBackground(Color.white);
		TableStudent tableStudent = new TableStudent();
		JScrollPane scrollPane1 = new JScrollPane(tableStudent);
		tabStudent.add(scrollPane1,BorderLayout.CENTER);
		Icon ikonStud = new ImageIcon("icons" + File.separator + "about.png");
		this.addTab("Studenti",ikonStud,tabStudent,"Prikaz studenata");
	
		
		//Tab profesor
		JPanel  tabProfesor = new JPanel();
		tabProfesor.setLayout(new BorderLayout());
		levi.setPreferredSize(new Dimension(50,tabProfesor.getHeight()));
		desni.setPreferredSize(new Dimension(50,tabProfesor.getHeight()));
		gornji.setPreferredSize(new Dimension(tabProfesor.getWidth(),50));
		donji.setPreferredSize(new Dimension(tabProfesor.getWidth(),50));
		tabProfesor.setBackground(Color.white);
		TableProfesor tableProfesor = new TableProfesor();
		JScrollPane scrollPane = new JScrollPane(tableProfesor);
		tabProfesor.add(scrollPane,BorderLayout.CENTER);
		tabProfesor.add(levi,BorderLayout.WEST);
		tabProfesor.add(desni,BorderLayout.EAST);
		tabProfesor.add(gornji,BorderLayout.NORTH);
		tabProfesor.add(donji,BorderLayout.SOUTH);
		Icon ikonProf = new ImageIcon("icons" + File.separator + "about.png");
		this.addTab("Profesori",ikonProf,tabProfesor,"Prikaz profesora");
		
		//Tab predmet
		JPanel  tabPredmet = new JPanel();
		tabPredmet.setLayout(new BorderLayout());
		tabPredmet.setBackground(Color.white);
		TablePredmet tablePredmet = new TablePredmet();
		JScrollPane scrollPane3 = new JScrollPane(tablePredmet);
		tabPredmet.add(scrollPane3,BorderLayout.CENTER);
		Icon ikonPred = new ImageIcon("icons" + File.separator + "about.png");
		this.addTab("Predmeti",ikonPred,tabPredmet,"Prikaz predmeta");
		
	}
}
