/*Referenca: https://alvinalexander.com/java/java-action-abstractaction-actionlistener/ */

package gui;



import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MenuToolbar  extends JToolBar{

	
	Action newAction, editAction, deleteAction;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MenuToolbar() {
		
	super(SwingConstants.HORIZONTAL);
	JButton btnNew = new JButton(newAction);
	btnNew.setIcon(new ImageIcon("icons/plus.png"));
	add(btnNew);

	addSeparator();

	JButton btnEdit = new JButton();
	btnEdit.setIcon(new ImageIcon("icons/pen.png"));
	add(btnEdit);

	addSeparator();

	JButton btnDelete = new JButton();
	btnDelete.setIcon(new ImageIcon("icons/trashbin.png"));
	add(btnDelete);
	
	
	
	setFloatable(true);
	
	
	
	}
}
