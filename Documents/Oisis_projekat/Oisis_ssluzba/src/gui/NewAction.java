package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class NewAction extends AbstractAction{
	
	public NewAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic)
	  {
	    super(name, icon);
	    putValue(SHORT_DESCRIPTION, shortDescription);
	    putValue(MNEMONIC_KEY, mnemonic);
	  }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

