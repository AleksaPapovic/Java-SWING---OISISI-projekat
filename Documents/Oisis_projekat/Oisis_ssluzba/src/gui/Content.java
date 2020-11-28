package gui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Content extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Content() {
		
		super();
		setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		JLabel label = new JLabel("TODO: Prikaz entiteta sistema");
		add(label);
		
		
		this.setVisible(true);
		
	}
}
