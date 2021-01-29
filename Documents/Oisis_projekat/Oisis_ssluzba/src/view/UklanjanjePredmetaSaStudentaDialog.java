package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentController;
/**
 * This class implements a dialog which is used for deleting a selected existing subject
 * from the list of subjects which the professor teaches.
 * 
 * @author Dusan Lekic
 *
 */	
public class UklanjanjePredmetaSaStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  This is a static button to confirm the removal
	 */
	public static JButton da;
	/**
	 *   This is a static button to reject  the removal
	 */
	public static JButton ne;
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public UklanjanjePredmetaSaStudentaDialog(JDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		setTitle(title);
		setSize(300, 120);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		add(panel,BorderLayout.CENTER);
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		
		JLabel labela=new JLabel("Da li ste sigurni da želite da uklonite predmet?");
		panel.add(labela);
		JButton da=new JButton("Da");
		da.setPreferredSize(new Dimension(100,25));
		
		da.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().obrisi();
				dispose();
			}
				
			
		});
		
		JButton ne=new JButton("Ne");
		ne.setPreferredSize(new Dimension(100,25));
		ne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel1.add(da);
		panel1.add(ne);
		
		add(panel1,BorderLayout.SOUTH);
		setVisible(true);
	}

}
