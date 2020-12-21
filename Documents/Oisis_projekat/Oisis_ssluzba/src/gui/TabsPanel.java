package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabsPanel extends JTabbedPane {

	
public TabsPanel(){
	
		//Tab student
		JPanel  tabStudent = new JPanel();
		tabStudent.setLayout(new BorderLayout());
		tabStudent.setBackground(Color.white);
		TablePredmet tableStudent = new TablePredmet();
		JScrollPane scrollPane1 = new JScrollPane(tableStudent);
		tabStudent.add(scrollPane1,BorderLayout.CENTER);
		Icon ikonStud = new ImageIcon("icons" + File.separator + "about.png");
		this.addTab("Studenti",ikonStud,tabStudent,"Prikaz studenata");
	
		//Tab profesor
		JPanel  tabProfesor = new JPanel();
		tabProfesor.setLayout(new BorderLayout());
		tabProfesor.setBackground(Color.white);
		TableProfesor tableProfesor = new TableProfesor();
		JScrollPane scrollPane = new JScrollPane(tableProfesor);
		tabProfesor.add(scrollPane,BorderLayout.CENTER);
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
