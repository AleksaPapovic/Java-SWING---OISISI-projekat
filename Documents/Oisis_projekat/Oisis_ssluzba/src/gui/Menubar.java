/*REFERENCA: https://alvinalexander.com/java/java-action-abstractaction-actionlistener/ 
Icons made by "https://www.flaticon.com/authors/Freepik" */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.Actions.AboutAction;
import gui.Actions.CloseAction;
import gui.Actions.DeleteAction;
import gui.Actions.EditAction;
import gui.Actions.HelpAction;
import gui.Actions.NewAction;

public class Menubar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3785591432336951155L;
	public NewAction newAction;
	public CloseAction closeAction;
	public EditAction editAction;
	public DeleteAction deleteAction;
	public HelpAction helpAction;
	public AboutAction aboutAction;

	ImageIcon newIcon, closeIcon, editIcon, deleteIcon, helpIcon, aboutIcon;

	public Menubar() {
		super();
		createActions();
		// create the menubar

		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		setPreferredSize(new Dimension(10, 30));

		// create our main menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		// create our menu items, using the same actions the toolbar buttons use
		JMenuItem newMenuItem = new JMenuItem(newAction);
		newMenuItem.setText("New");
		JMenuItem closeMenuItem = new JMenuItem(closeAction);
		closeMenuItem.setText("Close");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(closeMenuItem);

		JMenuItem editMenuItem = new JMenuItem(editAction);
		editMenuItem.setText("Edit");
		JMenuItem deleteMenuItem = new JMenuItem(deleteAction);
		deleteMenuItem.setText("Delete");
		editMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

		editMenu.add(editMenuItem);
		editMenu.addSeparator();
		editMenu.add(deleteMenuItem);

		JMenuItem helpMenuItem = new JMenuItem(helpAction);
		helpMenuItem.setText("Help");
		JMenuItem aboutMenuItem = new JMenuItem(aboutAction);
		aboutMenuItem.setText("About");
		helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		helpMenu.add(helpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);

		add(Box.createHorizontalStrut(15));
		add(fileMenu);
		add(Box.createHorizontalStrut(10));
		add(editMenu);
		add(Box.createHorizontalStrut(10));
		add(helpMenu);

	}

	private void createActions() {

		Actions ac = new Actions();
		// create our icons (for the toolbar)
		newIcon = new ImageIcon("icons" + File.separator + "plus.png");
		closeIcon = new ImageIcon("icons" + File.separator + "close.png");
		editIcon = new ImageIcon("icons" + File.separator + "pen.png");
		deleteIcon = new ImageIcon("icons" + File.separator + "trashbin.png");
		helpIcon = new ImageIcon("icons" + File.separator + "help.png");
		aboutIcon = new ImageIcon("icons" + File.separator + "about.png");

		// create our actions
		newAction = ac.new NewAction("New", newIcon, "Create new", KeyEvent.VK_N,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		closeAction = ac.new CloseAction("Close", closeIcon, "Close", KeyEvent.VK_C,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		editAction = ac.new EditAction("Edit", editIcon, "Edit data", KeyEvent.VK_E,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		deleteAction = ac.new DeleteAction("Delete", deleteIcon, "Delete data", KeyEvent.VK_D,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		helpAction = ac.new HelpAction("Help", helpIcon, "Help ", KeyEvent.VK_H,
				KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		aboutAction = ac.new AboutAction("About", aboutIcon, "Information", KeyEvent.VK_A,
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

	}

}
