/*REFERENCA:https://alvinalexander.com/java/java-action-abstractaction-actionlistener/*/

package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Actions{
	
	public Actions() {
		
	}

	public class NewAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 4444373563346796488L;

		public NewAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
          super();
	      putValue(SHORT_DESCRIPTION, shortDescription);
	      putValue(MNEMONIC_KEY, mnemonic);
	      putValue(ACCELERATOR_KEY,accelerator);
	      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'New' action.");
	    }
	  }
	public class CloseAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 23685682457822238L;

		public CloseAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Close' action.");
	    }
	  }

	public class EditAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -5247903053441802302L;

		public EditAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Edit' action.");
	    }
	  }
	
	public class DeleteAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		public DeleteAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Delete' action.");
	    }
      }	
	
	public class HelpAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1374658992717206617L;

		public HelpAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Help' action.");
	    }
	  }
	
	public class AboutAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 9021628910874527061L;

		public AboutAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'About' action.");
	    }
	  }
	
	public class SearchAction extends AbstractAction
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		public SearchAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic, KeyStroke accelerator)
	    {
			 super();
		      putValue(SHORT_DESCRIPTION, shortDescription);
		      putValue(MNEMONIC_KEY, mnemonic);
		      putValue(ACCELERATOR_KEY,accelerator);
		      putValue(SMALL_ICON, setAbstractAction(icon) );
	    }

	    public void actionPerformed(ActionEvent e)
	    {
	      JOptionPane.showMessageDialog(null, "Would have done the 'Search' action.");
	    }
    }	
	
	
	private ImageIcon setAbstractAction(ImageIcon icon) {
		Image img = icon.getImage() ;  
		Image newimg3 = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH ) ;  
	    icon = new ImageIcon(newimg3);
	    return icon;
	}
	

}


