package view;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;

import controller.StudentController;
import view.StudentTextFields.TipPolja;
import controller.DodavanjeStudentaDocumentListener;

/**
 * This class implements a dialog which is used for adding a new student to the
 * model.
 * 
 * @author Dusan Lekic
 *
 */	
public class DodavanjeStudentaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871252857743880797L;
	/**
	 *  This is a static text field for the first name of the student.
	 */
	public static StudentTextFields imeField;
	/**
	 *  This is a static text field for the surname of the student.
	 */
	public static StudentTextFields prezimeField;
	/**
	 *  This is a static text field for the birth date of the student.
	 */
	public static StudentTextFields datumRField;
	/**
	 *  This is a static text field for the address of the student.
	 */
	public static StudentTextFields adresaSField;
	/**
	 *  This is a static text field for the contact info of the student.
	 */
	public static StudentTextFields brojTField;
	/**
	 * This is a static text field for the email of the student.
	 */
	public static StudentTextFields emailField;
	/**
	 *  This is a static text field for the index number of the student.
	 */
	public static StudentTextFields brIndField;
	/**
	 *  This is a static text field for the enrollment year of the student.
	 */
	public static StudentTextFields godUpField;
	private JButton odustani;
	/**
	 *   This is a static button for confirmation.
	 */
	public static JButton prihvati;
	/**
	 *   This is a static combo box for the year of study of the student.
	 */
	public static JComboBox<String> godStComboBox;
	/**
	 *	 This is a static combo box for the type of financing of the student.
	 */
	public static JComboBox<String> nacinFComboBox;
	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and components are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public DodavanjeStudentaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setSize(450, 550);
		setLocationRelativeTo(parent);
		setResizable(false);
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
		imeField = new StudentTextFields(TipPolja.Ime, "Ime");

		JLabel prezimeLabela = new JLabel("Prezime*");
		prezimeLabela.setPreferredSize(velicina);
		prezimeLabela.setMaximumSize(velicina);
		prezimeField = new StudentTextFields(TipPolja.Prezime, "Prezime");

		JLabel datumRLabela = new JLabel("Datum rodjenja*");
		datumRLabela.setPreferredSize(velicina);
		datumRLabela.setMaximumSize(velicina);
		datumRField = new StudentTextFields(TipPolja.DatumR, "dd.mm.yyyy.");

		JLabel adresaSLabela = new JLabel("Adresa stanovanja*");
		adresaSLabela.setPreferredSize(velicina);
		adresaSLabela.setMaximumSize(velicina);
		adresaSField = new StudentTextFields(TipPolja.AdresaS, "...");

		JLabel brojTLabela = new JLabel("Broj telefona*");
		brojTLabela.setPreferredSize(velicina);
		brojTLabela.setMaximumSize(velicina);
		brojTField = new StudentTextFields(TipPolja.BrojTel, "--9 ili vise brojeva--");;

		JLabel emailLabela = new JLabel("E-mail adresa*");
		emailLabela.setPreferredSize(velicina);
		emailLabela.setMaximumSize(velicina);
		emailField = new StudentTextFields(TipPolja.Email, "..@..");;

		JLabel brIndLabela = new JLabel("Broj indeksa*");
		brIndLabela.setPreferredSize(velicina);
		brIndLabela.setMaximumSize(velicina);
		brIndField = new StudentTextFields(TipPolja.BrojInd, "...");;

		JLabel godUpLabela = new JLabel("Godina upisa*");
		godUpLabela.setPreferredSize(velicina);
		godUpLabela.setMaximumSize(velicina);
		godUpField = new StudentTextFields(TipPolja.GodUp, "****");;

		JLabel godStLabela = new JLabel("Trenutna godina studija*");
		godStLabela.setPreferredSize(velicina);
		godStLabela.setMaximumSize(velicina);
		String godSt[] = { "I(prva)", "II(druga)", "II(treca)", "IV(cetvrta)" };
		godStComboBox = new JComboBox<String>(godSt);

		JLabel nacinFLabela = new JLabel("Nacin finansiranja*");
		nacinFLabela.setPreferredSize(velicina);
		nacinFLabela.setMaximumSize(velicina);
		String nacinF[] = { "Budzet", "Samofinansiranje" };
		nacinFComboBox = new JComboBox<String>(nacinF);

		prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(velicina);
		prihvati.setEnabled(false);
		odustani = new JButton("Odustani");
		odustani.setPreferredSize(velicina);

		DodavanjeStudentaDocumentListener textChangeDocumentListener = new DodavanjeStudentaDocumentListener();

		DodavanjeStudentaDialog.imeField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.prezimeField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.datumRField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.adresaSField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.emailField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.brIndField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjeStudentaDialog.godUpField.getDocument().addDocumentListener(textChangeDocumentListener);

		prihvati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(StudentController.getInstance().dodajStudenta())
				dispose();

			}

		});

		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		setVisible(true);
	}
}
