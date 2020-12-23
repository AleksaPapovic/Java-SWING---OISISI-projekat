package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodavanjeProfesoraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodavanjeProfesoraDialog(Frame parent, String title, boolean modal) {
		setTitle(title);
		setSize(450, 550);
		setLocationRelativeTo(parent);
		setResizable(false);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1,2,20,20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension polje = new Dimension(100, 30);
		
		
		JLabel imeLabela = new JLabel("Unesite ime");
		imeLabela.setPreferredSize(polje);
		imeLabela.setMaximumSize(polje);
		JTextField imeField = new JTextField();

		JLabel prezimeLabela = new JLabel("Unesite prezime");
		prezimeLabela.setPreferredSize(polje);
		prezimeLabela.setMaximumSize(polje);
		JTextField prezimeField = new JTextField();

		JLabel datumRLabela = new JLabel("Unesite datum rodjenja");
		datumRLabela.setPreferredSize(polje);
		datumRLabela.setMaximumSize(polje);
		JTextField datumRField = new JTextField();

		JLabel adresaSLabela = new JLabel("Unesite adresu stanovanja");
		adresaSLabela.setPreferredSize(polje);
		adresaSLabela.setMaximumSize(polje);
		JTextField adresaSField = new JTextField();

		JLabel kontaktTelLabela = new JLabel("Unesite kontakt telefon");
		kontaktTelLabela.setPreferredSize(polje);
		kontaktTelLabela.setMaximumSize(polje);
		JTextField kontaktTelField = new JTextField();

		JLabel emailLabela = new JLabel("Unesite email");
		emailLabela.setPreferredSize(polje);
		emailLabela.setMaximumSize(polje);
		JTextField emailField = new JTextField();

		JLabel adresaKLabela = new JLabel("Unesite adresu kancelarije");
		adresaKLabela.setPreferredSize(polje);
		adresaKLabela.setMaximumSize(polje);
		JTextField adresaKField = new JTextField();

		JLabel brlkLabela = new JLabel("Unesite broj licne karte");
		brlkLabela.setPreferredSize(polje);
		brlkLabela.setMaximumSize(polje);
		JTextField brlkField = new JTextField();

		JLabel titulaLabela = new JLabel("Izaberite titulu");
		titulaLabela.setPreferredSize(polje);
		titulaLabela.setMaximumSize(polje);
		String titule[] = { "Ms", "Dr", "ProfDr" };
		JComboBox combobox1 = new JComboBox(titule);

		JLabel zvanjeLabela = new JLabel("Izaberite titulu");
		zvanjeLabela.setPreferredSize(polje);
		zvanjeLabela.setMaximumSize(polje);
		String zvanja[] = { "Saradnik", "Asistent", "RProfesor", 
				            "VProfesor", "Docent " };
		JComboBox combobox2 = new JComboBox(zvanja);
		
		JButton prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(polje);
		JButton odbaci  = new JButton("Odbaci");
		odbaci.setPreferredSize(polje);
		
		prihvati.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(imeField.getText().isEmpty() || prezimeField.getText().isEmpty() ||
					datumRField.getText().isEmpty() || adresaSField.getText().isEmpty() ||	
					kontaktTelField.getText().isEmpty() || emailField.getText().isEmpty() ||
					adresaKField.getText().isEmpty() || brlkField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(parent, "Morate uneti sve podatke");
					}
					else {
					
				}
			}	
		});
		
		odbaci.addActionListener(new ActionListener() {
			
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
		textPanel.add(kontaktTelLabela);
		textPanel.add(kontaktTelField);
		textPanel.add(emailLabela);
		textPanel.add(emailField);
		textPanel.add(adresaKLabela);
		textPanel.add(adresaKField);
		textPanel.add(brlkLabela);
		textPanel.add(brlkField);
		textPanel.add(titulaLabela);
		textPanel.add(combobox1);
		textPanel.add(zvanjeLabela);
		textPanel.add(combobox2);
		
		buttonsPanel.add(prihvati);
		buttonsPanel.add(odbaci);
	}
}
