package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Student.Status;

public class DodavanjeStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871252857743880797L;

	public DodavanjeStudentaDialog(Frame parent, String title, boolean modal) {
		setTitle(title);
		setSize(450, 550);
		setLocationRelativeTo(parent);
		setResizable(false);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension velicina = new Dimension(100, 30);

		JLabel imeLabela = new JLabel("Ime*");
		imeLabela.setPreferredSize(velicina);
		imeLabela.setMaximumSize(velicina);
		JTextField imeField = new JTextField();

		JLabel prezimeLabela = new JLabel("Prezime*");
		prezimeLabela.setPreferredSize(velicina);
		prezimeLabela.setMaximumSize(velicina);
		JTextField prezimeField = new JTextField();

		JLabel datumRLabela = new JLabel("Datum rodjenja*");
		datumRLabela.setPreferredSize(velicina);
		datumRLabela.setMaximumSize(velicina);
		JTextField datumRField = new JTextField();

		JLabel adresaSLabela = new JLabel("Adresa stanovanja*");
		adresaSLabela.setPreferredSize(velicina);
		adresaSLabela.setMaximumSize(velicina);
		JTextField adresaSField = new JTextField();

		JLabel brojTLabela = new JLabel("Broj telefona*");
		brojTLabela.setPreferredSize(velicina);
		brojTLabela.setMaximumSize(velicina);
		JTextField brojTField = new JTextField();

		JLabel emailLabela = new JLabel("E-mail adresa*");
		emailLabela.setPreferredSize(velicina);
		emailLabela.setMaximumSize(velicina);
		JTextField emailField = new JTextField();

		JLabel brIndLabela = new JLabel("Broj indeksa*");
		brIndLabela.setPreferredSize(velicina);
		brIndLabela.setMaximumSize(velicina);
		JTextField brIndField = new JTextField();

		JLabel godUpLabela = new JLabel("Godina upisa*");
		godUpLabela.setPreferredSize(velicina);
		godUpLabela.setMaximumSize(velicina);
		JTextField godUpField = new JTextField();

		JLabel godStLabela = new JLabel("Trenutna godina studija*");
		godStLabela.setPreferredSize(velicina);
		godStLabela.setMaximumSize(velicina);
		String godSt[] = { "I(prva)", "II(druga)", "II(treca)", "IV(cetvrta)" };
		JComboBox godStComboBox = new JComboBox(godSt);

		JLabel nacinFLabela = new JLabel("Nacin finansiranja");
		nacinFLabela.setPreferredSize(velicina);
		nacinFLabela.setMaximumSize(velicina);
		String nacinF[] = { "Budzet", "Samofinansiranje" };
		JComboBox nacinFComboBox = new JComboBox(nacinF);

		JButton prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(velicina);
		JButton odustani = new JButton("Odustani");
		odustani.setPreferredSize(velicina);

		prihvati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (imeField.getText().isEmpty() || prezimeField.getText().isEmpty() || datumRField.getText().isEmpty()
						|| adresaSField.getText().isEmpty() || brojTField.getText().isEmpty()
						|| emailField.getText().isEmpty() || brIndField.getText().isEmpty()
						|| godUpField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(parent, "Morate uneti sve podatke");
				} else {
					Status status;
					if(nacinFComboBox.getSelectedIndex()==1) {
						status=Status.B;
					}else {
						status=Status.S;
					}
				
					
					String s = datumRField.getText();
			        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy.");
					try {
						//StudentController.getInstance().dodajStudenta(imeField.getText(), prezimeField.getText(), format.parse(s), adresaSField.getText(),
								//		brojTField.getText(), emailField.getText(), brIndField.getText(), Integer.parseInt(godUpField.getText()), godStComboBox.getSelectedItem() , nacinFComboBox.getSelectedItem,9.0);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
				}
			}
		});

		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		add(panel);

		panel.add(textPanel, BorderLayout.NORTH);
		panel.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(imeLabela);
		textPanel.add(imeField);
		textPanel.add(prezimeLabela);
		textPanel.add(prezimeField);
		textPanel.add(datumRLabela);
		textPanel.add(datumRField);
		textPanel.add(adresaSLabela);
		textPanel.add(adresaSField);
		textPanel.add(brojTLabela);
		textPanel.add(brojTField);
		textPanel.add(emailLabela);
		textPanel.add(emailField);
		textPanel.add(brIndLabela);
		textPanel.add(brIndField);
		textPanel.add(godUpLabela);
		textPanel.add(godUpField);
		textPanel.add(godStLabela);
		textPanel.add(godStComboBox);
		textPanel.add(nacinFLabela);
		textPanel.add(nacinFComboBox);

		buttonsPanel.add(prihvati);
		buttonsPanel.add(odustani);
	}
}
