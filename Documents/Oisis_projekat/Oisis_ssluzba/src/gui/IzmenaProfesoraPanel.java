package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

import controller.DocumentListenerIzmenaProfesora;
import controller.ProfesorController;
import gui.FocusField.TipPolja;
import model.BazaProfesora;
import model.Profesor;

public class IzmenaProfesoraPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static FocusField imeIzmena;
	public static FocusField prezimeIzmena;
	public static FocusField datumRIzmena;
	public static FocusField adresaSIzmena;
	public static FocusField kontaktTelIzmena;
	public static FocusField emailIzmena;
	public static FocusField adresaKIzmena;
	public static FocusField brlkIzmena;
	public static JComboBox<String> combobox1Izmena;
	public static JComboBox<String> combobox2Izmena;
	public static JButton prihvatiIzmena;
	private DocumentListener docList = new DocumentListenerIzmenaProfesora();

	public IzmenaProfesoraPanel(JDialog parentDialog) {
		
		int indeks_profesora = TabsPanel.tableProfesor.getSelectedRow();
		Profesor prof = BazaProfesora.getInstance().getSelectedProfesor(indeks_profesora);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textPanel.setBackground(Color.WHITE);
		buttonsPanel.setBackground(Color.WHITE);
		
		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension polje = new Dimension(100, 30);

		JLabel imeLabela = new JLabel("Unesite ime");
		imeLabela.setPreferredSize(polje);
		imeLabela.setMaximumSize(polje);
		imeIzmena = new FocusField(TipPolja.Ime, "Ime");
        imeIzmena.setText(prof.getIme());
		
		JLabel prezimeLabela = new JLabel("Unesite prezime");
		prezimeLabela.setPreferredSize(polje);
		prezimeLabela.setMaximumSize(polje);
		prezimeIzmena = new FocusField(TipPolja.Prezime, "Prezime");
		prezimeIzmena.setText(prof.getPrezime());

		JLabel datumRLabela = new JLabel("Unesite datum rodjenja");
		datumRLabela.setPreferredSize(polje);
		datumRLabela.setMaximumSize(polje);
		datumRIzmena = new FocusField(TipPolja.DatumR, "dd.mm.yyyy."); 
	    SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy.");  
        String strDatumR = formatter.format(prof.getDatumR());
		datumRIzmena.setText(strDatumR);
		
		JLabel adresaSLabela = new JLabel("Unesite adresu stanovanja");
		adresaSLabela.setPreferredSize(polje);
		adresaSLabela.setMaximumSize(polje);
		adresaSIzmena = new FocusField(TipPolja.AdresaS, "...");
		adresaSIzmena.setText(prof.getAdresaS());
		
		JLabel kontaktTelLabela = new JLabel("Unesite kontakt telefon");
		kontaktTelLabela.setPreferredSize(polje);
		kontaktTelLabela.setMaximumSize(polje);
		kontaktTelIzmena = new FocusField(TipPolja.BrojTel, "9 ili vise  brojeva");
		kontaktTelIzmena.setText(prof.getKontaktTel());

		JLabel emailLabela = new JLabel("Unesite email");
		emailLabela.setPreferredSize(polje);
		emailLabela.setMaximumSize(polje);
		emailIzmena = new FocusField(TipPolja.Email, "...@...");
		emailIzmena.setText(prof.getEmail());
		
		JLabel adresaKLabela = new JLabel("Unesite adresu kancelarije");
		adresaKLabela.setPreferredSize(polje);
		adresaKLabela.setMaximumSize(polje);
		adresaKIzmena = new FocusField(TipPolja.AdresaK, "...");
		adresaKIzmena.setText(prof.getAdresaK());
		
		JLabel brlkLabela = new JLabel("Unesite broj lične karte");
		brlkLabela.setPreferredSize(polje);
		brlkLabela.setMaximumSize(polje);
		brlkIzmena = new FocusField(TipPolja.BrojLK, "mora imati 9 brojeva");
		brlkIzmena.setText(prof.getBrlk());
		brlkIzmena.setEnabled(false);
		
		JLabel titulaLabela = new JLabel("Izaberite titulu");
		titulaLabela.setPreferredSize(polje);
		titulaLabela.setMaximumSize(polje);
		String titule[] = { "Master", "Doktor", "Profesor doktor" };
		combobox1Izmena = new JComboBox<String>(titule);
		combobox1Izmena.setSelectedItem(prof.getTitula());

		JLabel zvanjeLabela = new JLabel("Izaberite zvanje");
		zvanjeLabela.setPreferredSize(polje);
		zvanjeLabela.setMaximumSize(polje);
		String zvanja[] = { "Saradnik", "Asistent", "Redovni Profesor", "Vanredni Profesor", "Docent" };
		combobox2Izmena = new JComboBox<String>(zvanja);
		combobox2Izmena.setSelectedItem(prof.getZvanje());

		prihvatiIzmena = new JButton("Potvrdi");
		prihvatiIzmena.setPreferredSize(polje);
		prihvatiIzmena.setEnabled(false);
		JButton odbaci = new JButton("Odustani");
		odbaci.setPreferredSize(polje);

		prihvatiIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (ProfesorController.getInstance().izmeniProfesora()) {
					parentDialog.dispose();
				}
			}
		});

		odbaci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				parentDialog.dispose();
			}
		});

		imeIzmena.getDocument().addDocumentListener(docList);
		prezimeIzmena.getDocument().addDocumentListener(docList);
		datumRIzmena.getDocument().addDocumentListener(docList);
		adresaSIzmena.getDocument().addDocumentListener(docList);
		kontaktTelIzmena.getDocument().addDocumentListener(docList);
		emailIzmena.getDocument().addDocumentListener(docList);
		adresaKIzmena.getDocument().addDocumentListener(docList);
		brlkIzmena.getDocument().addDocumentListener(docList);

		

		this.add(textPanel, BorderLayout.NORTH);
		this.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(imeLabela);
		textPanel.add(imeIzmena);
		textPanel.add(prezimeLabela);
		textPanel.add(prezimeIzmena);
		textPanel.add(datumRLabela);
		textPanel.add(datumRIzmena);
		textPanel.add(adresaSLabela);
		textPanel.add(adresaSIzmena);
		textPanel.add(kontaktTelLabela);
		textPanel.add(kontaktTelIzmena);
		textPanel.add(emailLabela);
		textPanel.add(emailIzmena);
		textPanel.add(adresaKLabela);
		textPanel.add(adresaKIzmena);
		textPanel.add(brlkLabela);
		textPanel.add(brlkIzmena);
		textPanel.add(titulaLabela);
		textPanel.add(combobox1Izmena);
		textPanel.add(zvanjeLabela);
		textPanel.add(combobox2Izmena);

		buttonsPanel.add(prihvatiIzmena);
		buttonsPanel.add(odbaci);
		
		
		
		
		
	}
}
