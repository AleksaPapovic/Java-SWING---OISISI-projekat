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
/**
 * This class implements a panel which is used for editing a selected existing student.
 * This panel is added as a tab to the dialog for editing a student.
 * @author Dusan Lekic
 *
 */
public class IzmenaStudentaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871252857743880797L;
	/**
	 *  This is a static text field for the first name of the selected student.
	 */
	public static StudentTextFields imeIzmena;
	/**
	 *  This is a static text field for the surname of the selected student.
	 */
	public static StudentTextFields prezimeIzmena;
	/**
	 *  This is a static text field for the birth date of the selected student.
	 */
	public static StudentTextFields datumRIzmena;
	/**
	 *  This is a static text field for the address of the selected student.
	 */
	public static StudentTextFields adresaSIzmena;
	/**
	 *  This is a static text field for the contact info of the selected student.
	 */
	public static StudentTextFields brojTIzmena;
	/**
	 * This is a static text field for the email of the selected student.
	 */
	public static StudentTextFields emailIzmena;
	/**
	 *  This is a static text field for the index number of the selected student.
	 */
	public static StudentTextFields brIndIzmena;
	/**
	 *  This is a static text field for the enrollment year of the selected student.
	 */
	public static StudentTextFields godUpIzmena;
	public JButton odustaniIzmena;
	/**
	 *   This is a static button for confirmation.
	 */
	public static JButton prihvatiIzmena;
	/**
	 *   This is a static combo box for the year of study of the selected student.
	 */
	public static JComboBox<String> godStIzmena;
	/**
	 *	 This is a static combo box for the type of financing of the selected student.
	 */
	public static JComboBox<String> nacinFIzmena;
	/**
	 * Constructor with parameters where the panel is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 */
	public IzmenaStudentaPanel(JDialog parent) {

		Student st = BazaStudenata.getInstance().getRow(TabsPanel.tableStudent.getSelectedTableRow());

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
		brojTIzmena = new StudentTextFields(TipPolja.BrojTel, "--9 ili vise brojeva--");
		;
		brojTIzmena.setText(st.getKontaktTl());

		JLabel emailLabela = new JLabel("E-mail adresa*");
		emailLabela.setPreferredSize(velicina);
		emailLabela.setMaximumSize(velicina);
		emailIzmena = new StudentTextFields(TipPolja.Email, "..@..");
		;
		emailIzmena.setText(st.getEmail());

		JLabel brIndLabela = new JLabel("Broj indeksa*");
		brIndLabela.setPreferredSize(velicina);
		brIndLabela.setMaximumSize(velicina);
		brIndIzmena = new StudentTextFields(TipPolja.BrojInd, "...");
		;
		brIndIzmena.setText(st.getBrojInd());
		brIndIzmena.setEnabled(false);

		JLabel godUpLabela = new JLabel("Godina upisa*");
		godUpLabela.setPreferredSize(velicina);
		godUpLabela.setMaximumSize(velicina);
		godUpIzmena = new StudentTextFields(TipPolja.GodUp, "****");
		;
		godUpIzmena.setText(String.valueOf(st.getGodUp()));

		JLabel godStLabela = new JLabel("Trenutna godina studija*");
		godStLabela.setPreferredSize(velicina);
		godStLabela.setMaximumSize(velicina);
		String godSt[] = { "I(prva)", "II(druga)", "III(treca)", "IV(cetvrta)" };
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

				if (StudentController.getInstance().izmeniStudenta())
					parent.dispose();

			}

		});

		odustaniIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.dispose();
			}
		});

		godStIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StudentController.getInstance().proveriIme(IzmenaStudentaPanel.imeIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriIme(IzmenaStudentaPanel.prezimeIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriDatumR(IzmenaStudentaPanel.datumRIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriAdresuSt(IzmenaStudentaPanel.adresaSIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriKontaktTl(IzmenaStudentaPanel.brojTIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriEmail(IzmenaStudentaPanel.emailIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriGodUp(IzmenaStudentaPanel.godUpIzmena.getText().trim())) {

					prihvatiIzmena.setEnabled(true);
				}
			}
		});

		nacinFIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StudentController.getInstance().proveriIme(IzmenaStudentaPanel.imeIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriIme(IzmenaStudentaPanel.prezimeIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriDatumR(IzmenaStudentaPanel.datumRIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriAdresuSt(IzmenaStudentaPanel.adresaSIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriKontaktTl(IzmenaStudentaPanel.brojTIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriEmail(IzmenaStudentaPanel.emailIzmena.getText().trim())

						&& StudentController.getInstance()
								.proveriGodUp(IzmenaStudentaPanel.godUpIzmena.getText().trim())) {

					prihvatiIzmena.setEnabled(true);
				}
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
