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

public class IzmenaStudentaTabs extends JTabbedPane{

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static int curr_tab = 0;

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

		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {

				JTabbedPane tabbedPane = (JTabbedPane) event.getSource();
				curr_tab = tabbedPane.getSelectedIndex();
			}
		});
	}
}