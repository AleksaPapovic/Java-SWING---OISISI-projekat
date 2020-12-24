package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
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
	
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		
		setTitle("Studenska služba");
		ImageIcon icon = new ImageIcon("icons/university.png");
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		      	
		
	    Menubar menu = new Menubar();
	    this.setJMenuBar(menu);
	
	    MenuToolbar toolbar = new MenuToolbar();
		add(toolbar, BorderLayout.NORTH);
		
	    StatusBar status = new StatusBar();
		add(status, BorderLayout.SOUTH);
		
		TabsPanel tabPanel  = new TabsPanel();
		add(tabPanel, BorderLayout.CENTER);
		
		setVisible(true);
	
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
		}

}
