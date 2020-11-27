/*REFERENCA: https://alvinalexander.com/java/java-action-abstractaction-actionlistener/ */

package gui;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menubar extends JMenuBar{
	
	Action newAction, closeAction, editAction, deleteAction, helpAction, aboutAction;
	
	ImageIcon newIcon, closeIcon, editIcon, deleteIcon, helpIcon, aboutIcon;
	
	Actions ac = new Actions();
	
	public Menubar() {
		super();
	    createActions();
	 // create the menubar
	    
	    // create our main menu
	    JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit");
	    JMenu helpMenu = new JMenu("Help");

	    // create our menu items, using the same actions the toolbar buttons use
	    JMenuItem newMenuItem = new JMenuItem(newAction);
	    JMenuItem closeMenuItem = new JMenuItem(closeAction);
	    
	    JMenuItem editMenuItem = new JMenuItem(editAction);
	    JMenuItem deleteMenuItem = new JMenuItem(deleteAction);
	    
	    JMenuItem helpMenuItem = new JMenuItem(helpAction);
	    JMenuItem aboutMenuItem = new JMenuItem(aboutAction);
	    
	    fileMenu.add(newMenuItem);
	    fileMenu.add(closeMenuItem);
	   
	    editMenu.add(editMenuItem);
	    editMenu.add(deleteMenuItem);
	    
	    helpMenu.add(helpMenuItem);
	    helpMenu.add(aboutMenuItem);

	    // add the menus to the menubar
	    add(fileMenu);
	    add(editMenu);
	    add(helpMenu);
	    
	}
	
	private void createActions()
	  {
	    // create our icons (for the toolbar)
	    //newIcon = new ImageIcon(Menubar.class.getResource("new-32.png"));
	    //editIcon = new ImageIcon(Menubar.class.getResource("edit-32.png"));
	    //deleteIcon = new ImageIcon(Menubar.class.getResource("delete-32.png"));

	    // create our actions
	    //NewAction newAction = ac.new NewAction("New", newIcon, "Create new", new Integer(KeyEvent.VK_N));
	    //EditAction editAction = ac.new EditAction("Edit", editIcon, "Edit data", new Integer(KeyEvent.VK_E));
	    //DeleteAction deleteAction = ac.new DeleteAction("Delete", deleteIcon, "Delete data", new Integer(KeyEvent.VK_D));
	    
	    
	    
	  }
	 
	
	
	 
}	
