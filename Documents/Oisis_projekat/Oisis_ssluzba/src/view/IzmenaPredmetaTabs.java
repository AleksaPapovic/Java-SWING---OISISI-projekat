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
/**
 * This class implements tabs for editing a selected existing subject.
 * @author Admin
 *
 */
public class IzmenaPredmetaTabs extends JTabbedPane {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/**
	 *  This is static value of selected row
	 */
	public static int curr_tab = 0;
	/**
	 *  This is static table of not passed subjects
	 */
	public static TableNepolozeniPredmeti tableNepolozeniPredmeti;
	/**
	 * Constructor with parameters where the tabs are initialized and theirs
	 * dimensions and components are set.
	 * 
	 * @param parentDialog the window which the dialog is relative to
	 */
	public IzmenaPredmetaTabs(JDialog parentDialog) {

		// Tab Predmet
		JPanel tabPredmet = new JPanel();
		tabPredmet.setLayout(new BorderLayout());
		JPanel gornji1 = new JPanel();
		JPanel levi1 = new JPanel();
		JPanel desni1 = new JPanel();
		JPanel donji1 = new JPanel();
		levi1.setBackground(Color.WHITE);
		desni1.setBackground(Color.WHITE);
		gornji1.setBackground(Color.WHITE);
		donji1.setBackground(Color.WHITE);
		levi1.setPreferredSize(new Dimension(50, tabPredmet.getHeight()));
		desni1.setPreferredSize(new Dimension(50, tabPredmet.getHeight()));
		gornji1.setPreferredSize(new Dimension(tabPredmet.getWidth(), 15));
		donji1.setPreferredSize(new Dimension(tabPredmet.getWidth(), 50));
		IzmenaPredmetaPanel panelIzmeniPredmeta = new IzmenaPredmetaPanel(parentDialog);
		tabPredmet.setBackground(Color.WHITE);
		tabPredmet.add(panelIzmeniPredmeta, BorderLayout.CENTER);
		tabPredmet.add(levi1, BorderLayout.WEST);
		tabPredmet.add(desni1, BorderLayout.EAST);
		tabPredmet.add(gornji1, BorderLayout.NORTH);
		tabPredmet.add(donji1, BorderLayout.SOUTH);
		Icon ikonProf = new ImageIcon("icons" + File.separator + "tab.png");
		this.addTab("Informacije", ikonProf, tabPredmet, "Prikaz informacija selektovanog predmeta");

		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {

				JTabbedPane tabbedPane = (JTabbedPane) event.getSource();
				curr_tab = tabbedPane.getSelectedIndex();
			}
		});
	}
}