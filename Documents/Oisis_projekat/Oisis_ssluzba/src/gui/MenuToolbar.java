/*Referenca: https://alvinalexander.com/java/java-action-abstractaction-actionlistener/ */

package gui;



import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MenuToolbar  extends JToolBar{

	
	Action newAction, editAction, deleteAction;
	
	public static JTextField searchbar;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MenuToolbar() {
		
	 super(SwingConstants.HORIZONTAL);
	
	 setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
	
	 add(Box.createHorizontalStrut(5));
	
	 JButton btnNew = new JButton(newAction);
	 btnNew.setIcon(new ImageIcon("icons/plus.png"));
	 btnNew.setPreferredSize(new Dimension(20,20));
	 btnNew.setMinimumSize(new Dimension(20,20));
	 btnNew.setMaximumSize(new Dimension(20,20));
	 btnNew.setBorder(null);
	
	add(btnNew);

	 add(Box.createHorizontalStrut(10));

	 JButton btnEdit = new JButton(editAction);
	 btnEdit.setIcon(new ImageIcon("icons/pen.png"));
	 btnEdit.setPreferredSize(new Dimension(20,20));
	 btnEdit.setMinimumSize(new Dimension(20,20));
	 btnEdit.setMaximumSize(new Dimension(20,20));
	 btnEdit.setBorder(null);
   add(btnEdit);
     add(Box.createHorizontalStrut(15));

	 JButton btnDelete = new JButton(deleteAction);
	 btnDelete.setIcon(new ImageIcon("icons/trashbin.png"));
	 btnDelete.setPreferredSize(new Dimension(20,20));
	 btnDelete.setMinimumSize(new Dimension(20,20));
	 btnDelete.setMaximumSize(new Dimension(20,20));
	 btnDelete.setBorder(null);
	add(btnDelete);
	
	 add(Box.createHorizontalGlue());
	
	 searchbar = new JTextField(20);
	 searchbar.setPreferredSize(new Dimension(40,25));
	 searchbar.setMinimumSize(new Dimension(40,25));
	 searchbar.setMaximumSize(new Dimension(40,25));
	add(searchbar); 
	  
	
	  JButton btnSearch = new JButton();
	  btnSearch.setIcon(new ImageIcon("icons/search.png"));
	  btnSearch.setPreferredSize(new Dimension(20,20));
	  btnSearch.setMinimumSize(new Dimension(20,20));
	  btnSearch.setMaximumSize(new Dimension(20,20));

	 add(btnSearch);
	  
	  add(Box.createHorizontalStrut(15));
	
	}
}
