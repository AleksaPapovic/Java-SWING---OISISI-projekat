package gui;

import gui.Menubar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7240939624608584060L;

	private static MainFrame instance = null;
	
	private MainFrame() {
		initialise();
	}
	
	
	private void initialise() {
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
	
		setSize(screenWidth / 2, screenHeight / 2);

		setTitle("Studenska sluzba");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setVisible(true);	
		
	    Menubar menu = new Menubar();
	    this.setJMenuBar(menu);
	
	    MenuToolbar toolbar = new MenuToolbar();
		add(toolbar, BorderLayout.NORTH);
	
	
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
		}

}
