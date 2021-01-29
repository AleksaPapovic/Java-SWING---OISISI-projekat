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
import javax.swing.event.DocumentListener;

import controller.DocumentListenerIzmenaProfesora;
import controller.ProfesorController;
import model.BazaProfesora;
import model.Profesor;
import view.FocusField.TipPolja;
/**
 * This class implements a panel which is used for editing a selected existing professor.
 * This panel is added as a tab to the dialog for editing a professor.
 * @author Aleksa Papovic
 *
 */
public class IzmenaProfesoraPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  This is static text field for first name  of selected professor
	 */
	public static FocusField imeIzmena;
	/**
	 *  This is static text field for surname  of selected professor
	 */
	public static FocusField prezimeIzmena;
	/**
	 *  This is static text field for date of birth  of selected professor
	 */
	public static FocusField datumRIzmena;
	/**
	 *  This is static text field for address  of selected professor
	 */
	public static FocusField adresaSIzmena;
	/**
	 *  This is static text field for contact info  of selected professor
	 */
	public static FocusField kontaktTelIzmena;
	/**
	 *  This is static text field for email  of selected professor
	 */
	public static FocusField emailIzmena;
	/**
	 *  This is static text field for office address  of selected professor
	 */
	public static FocusField adresaKIzmena;
	/**
	 *  This is static text field for ID number  of selected professor
	 */
	public static FocusField brlkIzmena;
	/**
	 *  This is static combobox for the title
	 */
	public static JComboBox<String> combobox1Izmena;
	/**
	 *  This is static combobox for the title
	 */
	public static JComboBox<String> combobox2Izmena;
	/**
	 *  This is static button for the confirmation
	 */
	public static JButton prihvatiIzmena;
	private DocumentListener docList = new DocumentListenerIzmenaProfesora();
	/**
	 * Constructor with parameters where the panel is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parentDialog the window which the dialog is relative to
	 */
	public IzmenaProfesoraPanel(JDialog parentDialog) {

		int indeks_profesora = TabsPanel.tableProfesor.getSelectedTableRow();
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

		JLabel brlkLabela = new JLabel("Unesite broj licne karte");
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
		String combo1S;
		switch (prof.getTitula()) {
		case Ms:
			combo1S = titule[0];
			break;
		case Dr:
			combo1S = titule[1];
			break;
		case ProfDr:
			combo1S = titule[2];
			break;
		default:
			combo1S = "";
		}
		combobox1Izmena.setSelectedItem(combo1S);

		JLabel zvanjeLabela = new JLabel("Izaberite zvanje");
		zvanjeLabela.setPreferredSize(polje);
		zvanjeLabela.setMaximumSize(polje);
		String zvanja[] = { "Asistent", "Docent", "Vanredni Profesor", "Redovni Profesor", "Saradnik" };
		combobox2Izmena = new JComboBox<String>(zvanja);
		String combo2S;
		switch (prof.getZvanje()) {
		case Asistent:
			combo2S = zvanja[0];
			break;
		case Docent:
			combo2S = zvanja[1];
			break;
		case VProfesor:
			combo2S = zvanja[2];
			break;
		case RProfesor:
			combo2S = zvanja[3];
			break;
		case Saradnik:
			combo2S = zvanja[4];
			break;
		default:
			combo2S = "";
		}
		combobox2Izmena.setSelectedItem(combo2S);

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

		combobox1Izmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ProfesorController.getInstance().proveriImeP(IzmenaProfesoraPanel.imeIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriImeP(IzmenaProfesoraPanel.prezimeIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriDatumR(IzmenaProfesoraPanel.datumRIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriAdresuSK(IzmenaProfesoraPanel.adresaSIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriBrojTel(IzmenaProfesoraPanel.kontaktTelIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriEmail(IzmenaProfesoraPanel.emailIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriAdresuSK(IzmenaProfesoraPanel.adresaKIzmena.getText().trim())) {

					prihvatiIzmena.setEnabled(true);
				}
			}
		});

		combobox2Izmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ProfesorController.getInstance().proveriImeP(IzmenaProfesoraPanel.imeIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriImeP(IzmenaProfesoraPanel.prezimeIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriDatumR(IzmenaProfesoraPanel.datumRIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriAdresuSK(IzmenaProfesoraPanel.adresaSIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriBrojTel(IzmenaProfesoraPanel.kontaktTelIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriEmail(IzmenaProfesoraPanel.emailIzmena.getText().trim())
						&& ProfesorController.getInstance()
								.proveriAdresuSK(IzmenaProfesoraPanel.adresaKIzmena.getText().trim())) {

					prihvatiIzmena.setEnabled(true);
				}
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
