package view;

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

import controller.IzmenaStudentaDocumentListener;
import controller.StudentController;
import model.BazaStudenata;
import model.Student;
import view.StudentTextFields.TipPolja;

public class IzmenaStudentaPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6871252857743880797L;
	public static StudentTextFields imeIzmena;
	public static StudentTextFields prezimeIzmena;
	public static StudentTextFields datumRIzmena;
	public static StudentTextFields adresaSIzmena;
	public static StudentTextFields brojTIzmena;
	public static StudentTextFields emailIzmena;
	public static StudentTextFields brIndIzmena;
	public static StudentTextFields godUpIzmena;
	public JButton odustaniIzmena;
	public static JButton prihvatiIzmena;
	public static JComboBox<String> godStIzmena;
	public static JComboBox<String> nacinFIzmena;

	public IzmenaStudentaPanel(JDialog parent) {
		
		Student st = BazaStudenata.getInstance().getRow(TabsPanel.tableStudent.getSelectedRow());	
	
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension velicina = new Dimension(100, 30);

		JLabel imeLabela = new JLabel("Ime*");
		imeLabela.setPreferredSize(velicina);
		imeLabela.setMaximumSize(velicina);
		imeIzmena = new StudentTextFields(TipPolja.Ime, "Ime");
		imeIzmena.setText(st.getIme());
		
		JLabel prezimeLabela = new JLabel("Prezime*");
		prezimeLabela.setPreferredSize(velicina);
		prezimeLabela.setMaximumSize(velicina);
		prezimeIzmena = new StudentTextFields(TipPolja.Prezime, "Prezime");
		prezimeIzmena.setText(st.getPrezime());
		
		JLabel datumRLabela = new JLabel("Datum rodjenja*");
		datumRLabela.setPreferredSize(velicina);
		datumRLabela.setMaximumSize(velicina);
		datumRIzmena = new StudentTextFields(TipPolja.DatumR, "dd.mm.yyyy.");
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy.");
		String datumR = formatter.format(st.getDatumR());
		datumRIzmena.setText(datumR);
	
		JLabel adresaSLabela = new JLabel("Adresa stanovanja*");
		adresaSLabela.setPreferredSize(velicina);
		adresaSLabela.setMaximumSize(velicina);
		adresaSIzmena = new StudentTextFields(TipPolja.AdresaS, "...");
		adresaSIzmena.setText(st.getAdresaSt());
		
		JLabel brojTLabela = new JLabel("Broj telefona*");
		brojTLabela.setPreferredSize(velicina);
		brojTLabela.setMaximumSize(velicina);
		brojTIzmena = new StudentTextFields(TipPolja.BrojTel, "--9 ili vise brojeva--");;
		brojTIzmena.setText(st.getKontaktTl());
		
		JLabel emailLabela = new JLabel("E-mail adresa*");
		emailLabela.setPreferredSize(velicina);
		emailLabela.setMaximumSize(velicina);
		emailIzmena = new StudentTextFields(TipPolja.Email, "..@..");;
		emailIzmena.setText(st.getEmail());
		
		JLabel brIndLabela = new JLabel("Broj indeksa*");
		brIndLabela.setPreferredSize(velicina);
		brIndLabela.setMaximumSize(velicina);
		brIndIzmena = new StudentTextFields(TipPolja.BrojInd, "...");;
		brIndIzmena.setText(st.getBrojInd());
		brIndIzmena.setEnabled(false);
		
		JLabel godUpLabela = new JLabel("Godina upisa*");
		godUpLabela.setPreferredSize(velicina);
		godUpLabela.setMaximumSize(velicina);
		godUpIzmena = new StudentTextFields(TipPolja.GodUp, "****");;
		godUpIzmena.setText(String.valueOf(st.getGodUp()));
		
		JLabel godStLabela = new JLabel("Trenutna godina studija*");
		godStLabela.setPreferredSize(velicina);
		godStLabela.setMaximumSize(velicina);
		String godSt[] = { "I(prva)", "II(druga)", "II(treca)", "IV(cetvrta)" };
		godStIzmena = new JComboBox<String>(godSt);
		godStIzmena.setSelectedItem(st.getGodSt());
		
		JLabel nacinFLabela = new JLabel("Nacin finansiranja*");
		nacinFLabela.setPreferredSize(velicina);
		nacinFLabela.setMaximumSize(velicina);
		String nacinF[] = { "Budzet", "Samofinansiranje" };
		nacinFIzmena = new JComboBox<String>(nacinF);
		nacinFIzmena.setSelectedItem(st.getStatus());

		prihvatiIzmena = new JButton("Potvrdi");
		prihvatiIzmena.setPreferredSize(velicina);
		prihvatiIzmena.setEnabled(false);
		odustaniIzmena = new JButton("Odustani");
		odustaniIzmena.setPreferredSize(velicina);

		IzmenaStudentaDocumentListener textChangeDocumentListener = new IzmenaStudentaDocumentListener();

		imeIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		prezimeIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		datumRIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		adresaSIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		emailIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		brIndIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		godUpIzmena.getDocument().addDocumentListener(textChangeDocumentListener);

		prihvatiIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(StudentController.getInstance().izmeniStudenta())
				parent.dispose();

			}

		});

		odustaniIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.dispose();
			}
		});

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
		textPanel.add(brojTLabela);
		textPanel.add(brojTIzmena);
		textPanel.add(emailLabela);
		textPanel.add(emailIzmena);
		textPanel.add(brIndLabela);
		textPanel.add(brIndIzmena);
		textPanel.add(godUpLabela);
		textPanel.add(godUpIzmena);
		textPanel.add(godStLabela);
		textPanel.add(godStIzmena);
		textPanel.add(nacinFLabela);
		textPanel.add(nacinFIzmena);

		buttonsPanel.add(prihvatiIzmena);
		buttonsPanel.add(odustaniIzmena);
		
		setVisible(true);
	}

}
