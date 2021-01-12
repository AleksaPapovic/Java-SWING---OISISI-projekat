package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Entiteti;

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
		ImageIcon icon = new ImageIcon("icons" + File.separator + "university.png");
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Menubar menu = new Menubar();
		this.setJMenuBar(menu);

		MenuToolbar toolbar = new MenuToolbar();
		add(toolbar, BorderLayout.NORTH);

		StatusBar status = new StatusBar();
		add(status, BorderLayout.SOUTH);

		TabsPanel tabPanel = new TabsPanel();
		add(tabPanel, BorderLayout.CENTER);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Entiteti.getInstance().serializeToXML();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}

		});

		setVisible(true);

	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

}
