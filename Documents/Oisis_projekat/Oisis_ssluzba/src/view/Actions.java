/*REFERENCA:https://alvinalexander.com/java/java-action-abstractaction-actionlistener/*/

package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.Entiteti;

/**
 * This class implements multiple actions which are used for different toolbar
 * buttons and menu items.
 * 
 * @author Dusan Lekic and Aleksa Papovic
 *
 */
public class Actions {
	public String tekst = "<html>Glavni prozor se sastoji iz Menubar-a, Toolbar-a, Statusbar-a, Searchbar-a u Toolbar-u i centralnog prozora <br>"
			+ "koji prikazuje studente, profesore i predmete. Meniji koji postoje u Menubar-u su File, Edit i Help. File sadrzi stavke <br>"
			+ "New, koja pravi novi entitet i Close, koja zatvara aplikaciju. Edit sadrzi stavke Edit, koja sluzi za menjanje podataka entiteta i<br>"
			+ "i Delete, koja brise postojeci entitet. Help meni sadrzi Help stavku, koja sluzi za pomoc korisniku, i<br>"
			+ "About stavku, koja sluzi za prikaz verzije aplikacije, kao i kratak opis iste.</html>";

	/**
	 * Default constructor without parameters.
	 */
	public Actions() {

	}

	/**
	 * This class implements the action for creating a new object and is called when
	 * the new menu item or button on the toolbar is clicked
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class NewAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4444373563346796488L;

		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public NewAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		/**
		 * This method implements what happens when the we click the toolbar button or
		 * menu item.
		 */
		public void actionPerformed(ActionEvent e) {
			switch (TabsPanel.tab_curr) {
			case 0: {
				@SuppressWarnings("unused")
				DodavanjeStudentaDialog dialogNoviStudent = new DodavanjeStudentaDialog(MainFrame.getInstance(),
						"Dodavanje Studenta", true);
			}
				break;
			case 1: {
				@SuppressWarnings("unused")
				DodavanjeProfesoraDialog dialogNoviProfesor = new DodavanjeProfesoraDialog(MainFrame.getInstance(),
						"Dodavanje Profesora", true);
			}
				break;

			case 2: {
				@SuppressWarnings("unused")
				DodavanjePredmetaDialog dialogNoviProfesor = new DodavanjePredmetaDialog(MainFrame.getInstance(),
						"Dodavanje Predmeta", true);
			}
				break;

			default:
				break;
			}
		}
	}

	/**
	 * This class implements the action for closing the main frame and serializing
	 * the data and is called when the close menu item is clicked.
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class CloseAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 23685682457822238L;

		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public CloseAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		/**
		 * This method implements what happens when the we click the menu item.
		 */
		public void actionPerformed(ActionEvent e) {
			try {
				Entiteti.getInstance().serializeToXML();
				System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This class implements the action for editing a selected existing object and
	 * is called when the edit menu item or button on the toolbar is clicked
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class EditAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5247903053441802302L;

		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public EditAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		/**
		 * This method implements what happens when the we click the menu item or the
		 * toolbar button.
		 */
		public void actionPerformed(ActionEvent e) {

			switch (TabsPanel.tab_curr) {
			case 0: {
				if (TabsPanel.tableStudent.getSelectedRow() != -1) {
					@SuppressWarnings("unused")
					IzmenaStudentaDialog stIz = new IzmenaStudentaDialog(MainFrame.getInstance(), "Izmena studenta",
							true);
				} else {
					JOptionPane.showMessageDialog(null, "Niste odabrali red za izmenu", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
				}

			}
				break;
			case 1: {
				if (TabsPanel.tableProfesor.getSelectedRow() != -1) {
					@SuppressWarnings("unused")
					IzmenaProfesoraDialog izmenaProf = new IzmenaProfesoraDialog(MainFrame.getInstance(),
							"Izmena profesora", true);
				} else {
					JOptionPane.showMessageDialog(null, "Niste odabrali red za izmenu", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
				}
			}
				break;

			case 2: {
				if (TabsPanel.tablePredmet.getSelectedRow() != -1) {
					@SuppressWarnings("unused")
					IzmenaPredmetaDialog prIz = new IzmenaPredmetaDialog(MainFrame.getInstance(), "Izmena predmeta",
							true);
				} else {
					JOptionPane.showMessageDialog(null, "Niste odabrali red za izmenu", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
				}
			}
				break;

			default:
				break;
			}

		}
	}

	/**
	 * This class implements the action for deleting a selected existing object and
	 * is called when the delete menu item or button on the toolbar is clicked
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class DeleteAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public DeleteAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		/**
		 * This method implements what happens when the we click the menu item or the
		 * toolbar button.
		 */
		public void actionPerformed(ActionEvent e) {
			switch (TabsPanel.tab_curr) {
			case 0: {
				int index = TabsPanel.tableStudent.getSelectedRow();
				if (index != -1) {
					StudentController.getInstance().izbrisiStudenta(index);
				} else {
					JOptionPane.showMessageDialog(null, "Niste odabrali red za brisanje", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
				}
			}
				break;
			case 1: {
				int index = TabsPanel.tableProfesor.getSelectedRow();
				if (index != -1) {
					ProfesorController.getInstance().izbrisiProfesora(index);
				} else {
					JOptionPane.showMessageDialog(null, "Niste odabrali red za brisanje", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
				}
			}
				break;
			case 2: {
				int index_predmeta = TabsPanel.tablePredmet.getSelectedRow();
				PredmetController.getInstance().izbrisiPredmet(index_predmeta);
			}
				break;

			default:
				break;
			}
		}
	}

	/**
	 * This class implements the action for opening the help dialog and is called
	 * when the help menu item is clicked.
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class HelpAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1374658992717206617L;
		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public HelpAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}
		/**
		 * This method implements what happens when the we click the menu item.
		 */
		public void actionPerformed(ActionEvent e) {
			HelpDialog dialog = new HelpDialog(MainFrame.getInstance(), "Help", true);
			dialog.setVisible(true);
		}
	}
	/**
	 * This class implements the action for opening the about dialog and is called
	 * when the about menu item is clicked.
	 * 
	 * @author Dusan Lekic
	 *
	 */
	public class AboutAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9021628910874527061L;
		/**
		 * Constructor with parameters
		 * 
		 * @param name             name of the action
		 * @param icon             icon for action display
		 * @param shortDescription short description of the action
		 * @param mnemonic         shortcut key for the action
		 * @param accelerator      shortcut command for the action
		 */
		public AboutAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}
		/**
		 * This method implements what happens when the we click the menu item.
		 */
		public void actionPerformed(ActionEvent e) {
			AboutDialog dialog = new AboutDialog(MainFrame.getInstance(), "About", true);
			dialog.setVisible(true);
		}
	}

	public class SearchAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		public SearchAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			switch (TabsPanel.tab_curr) {
			case 0: {
				StudentController.getInstance().pretragaStudenta(MenuToolbar.searchbar.getText());
			}
				break;
			case 1: {
				ProfesorController.getInstance().pretragaProfesora(MenuToolbar.searchbar.getText());
			}
				break;

			case 2: {
				PredmetController.getInstance().pretragaPredmeta(MenuToolbar.searchbar.getText());
			}
				break;

			default:
				break;
			}
		}
	}

	private ImageIcon setAbstractAction(ImageIcon icon) {
		Image img = icon.getImage();
		Image newimg3 = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg3);
		return icon;
	}

}
