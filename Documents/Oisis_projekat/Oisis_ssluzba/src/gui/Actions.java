/*REFERENCA:https://alvinalexander.com/java/java-action-abstractaction-actionlistener/*/

package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Actions{
	
	public void Actions() {
		
	}

	public class NewAction extends AbstractAction
	  {
	    public NewAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
          super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'New' action.");
	    }
	  }
	public class CloseAction extends AbstractAction
	  {
	    public CloseAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
        super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Close' action.");
	    }
	  }

	public class EditAction extends AbstractAction
	  {
	    public EditAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
	      super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Edit' action.");
	    }
	  }
	
	public class DeleteAction extends AbstractAction
	  {
	    public DeleteAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
	      super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Delete' action.");
	    }
      }	
	
	public class HelpAction extends AbstractAction
	  {
	    public HelpAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
        super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Help' action.");
	    }
	  }
	
	public class AboutAction extends AbstractAction
	  {
	    public AboutAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	    {
        super(name, icon);
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'About' action.");
	    }
	  }
	

}


