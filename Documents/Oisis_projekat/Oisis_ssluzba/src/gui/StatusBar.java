/*REFERENCA: https://www.javaknowledge.info/status-bar-example-for-jframe/ */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class StatusBar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;

	public StatusBar(){
		
		super();
		setLayout(new BorderLayout());	
	
		
		this.setBackground(Color.WHITE);
		this.setBorder(new CompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(3, 3, 3, 3)));
		
	    JLabel labelTitle = new JLabel("Studentska služba");
	    Date datum = new Date();
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
	    JLabel time = new JLabel(dateFormat.format(datum));
	    Date date = new Date();
	    time.setText(dateFormat.format(date));
	    
	    Timer timer = new Timer(10, null); 
	    
		time.setText(dateFormat.format(date));
	    	    	    
	    timer.start();	    
	    
	    this.add(labelTitle, BorderLayout.WEST);
		this.add(time, BorderLayout.EAST);
	  
	}
	

}
