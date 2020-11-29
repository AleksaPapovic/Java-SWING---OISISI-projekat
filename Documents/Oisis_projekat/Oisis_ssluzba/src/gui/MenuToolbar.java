/*Referenca: https://alvinalexander.com/java/java-action-abstractaction-actionlistener/ */

package gui;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import gui.Actions.DeleteAction;
import gui.Actions.EditAction;
import gui.Actions.NewAction;
import gui.Actions.SearchAction;

public class MenuToolbar  extends JToolBar{

	public  NewAction newAction;
	public  EditAction editAction;
	public  DeleteAction deleteAction;
	public  SearchAction searchAction;
	public static JTextField searchbar;
	
	ImageIcon newIcon, editIcon, deleteIcon,searchIcon;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MenuToolbar() {
	 super(SwingConstants.HORIZONTAL);
	 
	 toolbarActions(); 
	
	
	 
	 add(Box.createHorizontalStrut(5));
	 
	 this.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
	 setFloatable( false);
	 setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
	 setBackground(Color.WHITE);
	 setPreferredSize(new Dimension(10,35));
	 JButton btnNew = new JButton(newAction);
	 btnNew.setPreferredSize(new Dimension(20,24));
	 btnNew.setMinimumSize(new Dimension(20,24));
	 btnNew.setMaximumSize(new Dimension(20,24));
	 btnNew.setOpaque(false);
	 btnNew.setBorder(null);
	
	 add(Box.createHorizontalStrut(15));
	 
	add(btnNew);

	 add(Box.createHorizontalStrut(10));

	 JButton btnEdit = new JButton(editAction);
	
	 btnEdit.setPreferredSize(new Dimension(24,24));
	 btnEdit.setMinimumSize(new Dimension(24,24));
	 btnEdit.setMaximumSize(new Dimension(24,24));
	 btnEdit.setOpaque(false);
	 btnEdit.setBorder(null);
   add(btnEdit);
     add(Box.createHorizontalStrut(15));

	 JButton btnDelete = new JButton(deleteAction);
	 btnDelete.setPreferredSize(new Dimension(24,24));
	 btnDelete.setMinimumSize(new Dimension(24,24));
	 btnDelete.setMaximumSize(new Dimension(24,24));
	 btnDelete.setOpaque(false);
	 btnDelete.setBorder(null);
	add(btnDelete);
	
	 add(Box.createHorizontalGlue());
	
	 searchbar = new JTextField(20);
	 searchbar.setPreferredSize(new Dimension(24,24));
	 searchbar.setMinimumSize(new Dimension(24,24));
	 searchbar.setMaximumSize(new Dimension(24,24));
	 searchbar.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
	add(searchbar); 
	  
	 add(Box.createHorizontalStrut(5));
	 JButton btnSearch = new JButton(searchAction);
	 btnSearch.setPreferredSize(new Dimension(24,24));
	 btnSearch.setMinimumSize(new Dimension(24,24));
	 btnSearch.setMaximumSize(new Dimension(24,24));
	 btnSearch.setOpaque(false);
	 btnSearch.setBorder(null);
	add(btnSearch);
	  
	  add(Box.createHorizontalStrut(15));
	
	}
	
	private void toolbarActions()
	  {
		
		Actions ac = new Actions();
	    // create our icons (for the toolbar)
	    newIcon = new ImageIcon("icons/plus.png");
	    editIcon = new ImageIcon("icons/pen.png");
	    deleteIcon = new ImageIcon("icons/trashbin.png");
	    searchIcon = new ImageIcon("icons/search.png");

	    // create our actions
	     newAction = ac.new NewAction("New", newIcon, "Create new", new Integer(KeyEvent.VK_N),KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	     editAction = ac.new EditAction("Edit", editIcon, "Edit data", new Integer(KeyEvent.VK_E),KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	     deleteAction = ac.new DeleteAction("Delete", deleteIcon, "Delete data", new Integer(KeyEvent.VK_D),KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	     searchAction = ac.new SearchAction("Search", searchIcon, "Search data", new Integer(KeyEvent.VK_S),KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
	   
	  }
	
	
}
