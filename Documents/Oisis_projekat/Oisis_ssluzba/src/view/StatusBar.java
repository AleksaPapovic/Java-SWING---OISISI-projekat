/*REFERENCA: https://www.javaknowledge.info/status-bar-example-for-jframe/ */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class implements a status bar which shows the current time and date
 * 
 * @author Dusan Lekic
 *
 */
public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;

	/**
	 * Constructor which initializes the dimensions and components and creates an
	 * action listener for the clock.
	 * 
	 */
	public StatusBar() {

		super();
		setLayout(new BorderLayout());

		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(10, 27));
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

		JLabel labelTitle = new JLabel("Studentska služba");
		Date datum = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
		JLabel time = new JLabel(dateFormat.format(datum));

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Date date = new Date();
				time.setText(dateFormat.format(date));
			}

		});

		timer.start();

		this.add(labelTitle, BorderLayout.WEST);
		this.add(time, BorderLayout.EAST);

	}

}
