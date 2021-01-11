package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.BazaStudenata;
import model.Student;

public class IzmenaStudentaTabs extends JTabbedPane{

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static int curr_tab = 0;
	public static TableNepolozeniPredmeti tableNepolozeniPredmeti;

	public IzmenaStudentaTabs(JDialog parentDialog) {

		// Tab Student
		JPanel tabStudent = new JPanel();
		tabStudent.setLayout(new BorderLayout());
		JPanel gornji1 = new JPanel();
		JPanel levi1 = new JPanel();
		JPanel desni1 = new JPanel();
		JPanel donji1 = new JPanel();
		levi1.setBackground(Color.WHITE);
		desni1.setBackground(Color.WHITE);
		gornji1.setBackground(Color.WHITE);
		donji1.setBackground(Color.WHITE);
		levi1.setPreferredSize(new Dimension(50, tabStudent.getHeight()));
		desni1.setPreferredSize(new Dimension(50, tabStudent.getHeight()));
		gornji1.setPreferredSize(new Dimension(tabStudent.getWidth(), 15));
		donji1.setPreferredSize(new Dimension(tabStudent.getWidth(), 50));
		IzmenaStudentaPanel panelIzmeniStudenta = new IzmenaStudentaPanel(parentDialog);
		tabStudent.setBackground(Color.WHITE);
		tabStudent.add(panelIzmeniStudenta, BorderLayout.CENTER);
		tabStudent.add(levi1, BorderLayout.WEST);
		tabStudent.add(desni1, BorderLayout.EAST);
		tabStudent.add(gornji1, BorderLayout.NORTH);
		tabStudent.add(donji1, BorderLayout.SOUTH);
		Icon ikonProf = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Informacije", ikonProf, tabStudent, "Prikaz informacija selektovanog studenta");
		
		
		JPanel tabNepolozeni = new JPanel();
		tabNepolozeni.setLayout(new BorderLayout());
		JPanel gornji3 = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
		JButton dodaj = new JButton("Dodaj");
		JButton ukloni = new JButton("Obriši");
		JButton polaganje = new JButton("Polaganje");
		gornji3.add(dodaj);
		gornji3.add(ukloni);
		gornji3.add(polaganje);
		JPanel levi3 = new JPanel();
		JPanel desni3 = new JPanel();
		JPanel donji3 = new JPanel();
		levi3.setBackground(Color.WHITE);
		desni3.setBackground(Color.WHITE);
		gornji3.setBackground(Color.WHITE);
		donji3.setBackground(Color.WHITE);
		levi3.setPreferredSize(new Dimension(50, tabNepolozeni.getHeight()));
		desni3.setPreferredSize(new Dimension(50, tabNepolozeni.getHeight()));
		gornji3.setPreferredSize(new Dimension(tabNepolozeni.getWidth(), 60));
		donji3.setPreferredSize(new Dimension(tabNepolozeni.getWidth(), 50));
		tabNepolozeni.setBackground(Color.white);
		Student s = BazaStudenata.getInstance().getRow(TabsPanel.tableStudent.getSelectedRow());
		tableNepolozeniPredmeti = new TableNepolozeniPredmeti(s);
		JScrollPane scrollPane3 = new JScrollPane(tableNepolozeniPredmeti);
		scrollPane3.getViewport().setBackground(Color.WHITE);
		tabNepolozeni.add(scrollPane3, BorderLayout.CENTER);
		tabNepolozeni.setBackground(Color.WHITE);
		tabNepolozeni.add(levi3, BorderLayout.WEST);
		tabNepolozeni.add(desni3, BorderLayout.EAST);
		tabNepolozeni.add(gornji3, BorderLayout.NORTH);
		tabNepolozeni.add(donji3, BorderLayout.SOUTH);
		
		this.addTab("Nepoloženi predmeti", null,tabNepolozeni, "Prikaz nepoloženih ispita selektovanog studenta");
		
		polaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(tableNepolozeniPredmeti.getSelectedRow() != -1) {
				UpisOceneDialog uod = new UpisOceneDialog(MainFrame.getInstance(), "Upis ocene", true);}
				else {
				JOptionPane.showMessageDialog(null, "Nije selektovan nepolozen predmet", "GRESKA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
               
				JTabbedPane tabbedPane = (JTabbedPane) event.getSource();
				curr_tab = tabbedPane.getSelectedIndex();
			}
		});
	}
}