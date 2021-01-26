/*REFERENCA: VEZBE 6, IgraciController klasa*/
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaStudenata;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.DodavanjePredmetaStudentuDialog;
import view.DodavanjeStudentaDialog;
import view.IzmenaStudentaPanel;
import view.IzmenaStudentaTabs;
import view.TabsPanel;

/**
 * This class connects the model and view components for the selected student
 * and calls the methods which are used to modify him.
 * 
 * @author Dusan Lekic
 *
 */
public class StudentController {

	public static StudentController instance = null;

	/**
	 * This method implements the instance as a singleton(it can only be instanced
	 * once).
	 * 
	 * @return the given instance
	 */
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	/**
	 * Default constructor with no parameters.
	 */
	private StudentController() {

	}

	/**
	 * This method implements the action of getting data from the dialog ,creating
	 * an instance of the student and adding that instance to the model of a
	 * student.
	 * 
	 * @return true or false depending on the success of the method
	 */
	public boolean dodajStudenta() {
		Student st = new Student();

		st.setIme(DodavanjeStudentaDialog.imeField.getText());
		st.setPrezime(DodavanjeStudentaDialog.prezimeField.getText());

		Date datumr = BazaStudenata.parseDate(DodavanjeStudentaDialog.datumRField.getText());
		st.setDatumR(datumr);

		st.setAdresaSt(DodavanjeStudentaDialog.adresaSField.getText());
		st.setKontaktTl(DodavanjeStudentaDialog.brojTField.getText());

		String email = DodavanjeStudentaDialog.emailField.getText();
		st.setEmail(email);

		st.setBrojInd(DodavanjeStudentaDialog.brIndField.getText());

		String godUp = DodavanjeStudentaDialog.godUpField.getText();
		st.setGodUp(Integer.parseInt(godUp));

		switch (DodavanjeStudentaDialog.godStComboBox.getSelectedItem().toString()) {
		case "I(prva)":
			st.setGodSt(1);
			break;
		case "II(druga)":
			st.setGodSt(2);
			break;

		case "III(treca)":
			st.setGodSt(3);
			break;

		case "IV(cetvrta)":
			st.setGodSt(4);
			break;

		default:
			break;
		}

		Status status = null;

		switch (DodavanjeStudentaDialog.nacinFComboBox.getSelectedItem().toString()) {
		case "Budzet":
			status = Status.B;
			break;
		case "Samofinansiranje":
			status = Status.S;
			break;

		default:
			break;
		}

		st.setStatus(status);

		BazaStudenata.getInstance().dodajStudenta(st.getIme(), st.getPrezime(), st.getDatumR(), st.getAdresaSt(),
				st.getKontaktTl(), st.getEmail(), st.getBrojInd(), st.getGodUp(), st.getGodSt(), st.getStatus(),
				st.getProsek());
		TabsPanel.tableStudent.update();
		return true;
	}

	/**
	 * This method implements the action of getting data from the dialog ,changing
	 * the data of a student and adding those changes model of a student.
	 * 
	 * @return true or false depending on the success of the method
	 */

	public boolean izmeniStudenta() {

		String ime = IzmenaStudentaPanel.imeIzmena.getText();
		String prezime = IzmenaStudentaPanel.prezimeIzmena.getText();

		Date datumr = BazaStudenata.parseDate(IzmenaStudentaPanel.datumRIzmena.getText());

		String adresa = IzmenaStudentaPanel.adresaSIzmena.getText();
		String kontakt = IzmenaStudentaPanel.brojTIzmena.getText();

		String email = IzmenaStudentaPanel.emailIzmena.getText();

		String brojInd = IzmenaStudentaPanel.brIndIzmena.getText();

		int godUp = Integer.parseInt(IzmenaStudentaPanel.godUpIzmena.getText());

		int godSt = 0;
		switch (IzmenaStudentaPanel.godStIzmena.getSelectedItem().toString()) {
		case "I(prva)":
			godSt = 1;
			break;
		case "II(druga)":
			godSt = 2;
			break;

		case "III(treca)":
			godSt = 3;
			break;

		case "IV(cetvrta)":
			godSt = 4;
			break;

		default:
			break;
		}

		Status status = null;

		switch (IzmenaStudentaPanel.nacinFIzmena.getSelectedItem().toString()) {
		case "Budzet":
			status = Status.B;
			break;
		case "Samofinansiranje":
			status = Status.S;
			break;

		default:
			break;
		}

		int index = TabsPanel.tableStudent.getSelectedTableRow();
		BazaStudenata.getInstance().izmeniStudenta(index, ime, prezime, datumr, adresa, kontakt, email, brojInd, godUp,
				godSt, status, BazaStudenata.getInstance().getStudenti().get(index).getProsek());
		TabsPanel.tableStudent.update();
		return true;
	}

	/**
	 * 
	 * This method implements the action of deleting a selected student from the model.
	 * 
	 * 
	 * @param index the index from the selected table row
	 * @return true or false depending on the success of the method
	 */
	public boolean izbrisiStudenta(int index) {

		BazaStudenata.getInstance().izbrisiStudenta(index);
		TabsPanel.tableStudent.update();
		return true;

	}
	
	/**
	 *  This method implements the action of searching for a given text through the searchbar.
	 * @param text text forwarded through the searchbar
	 */
	public void pretragaStudenta(String text) {
		BazaStudenata.getInstance().pretraziStudenta(text);
		TabsPanel.tableStudent.update();
	}
	
	/**
	 * This method checks if the name of a student is valid.
	 * @param ime the name of the student
	 * @return true or false depending on the validity of the name
	 */
	public boolean proveriIme(String ime) {
		boolean ret = true;

		if (ime.isEmpty() || Character.isLowerCase(ime.charAt(0))) {
			ret = false;
		}
		return ret;

	}
	
	/**
	 * This method checks if the birth date of a student is valid.
	 * @param datumR the birth date of a student
	 * @return true or false depending on the validity of the birth date
	 */
	public boolean proveriDatumR(String datumR) {

		boolean ret = true;
		@SuppressWarnings("unused")
		Date dateR = new Date();
		try {
			dateR = new SimpleDateFormat("dd.mm.yyyy.").parse(datumR);
			ret = true;
		} catch (ParseException e) {
			ret = false;
		}
		return ret;
	}

	/**
	 * This method checks if the birth date of a student is valid.
	 * @param adresaSt the address of a student
	 * @return	true or false depending on the validity of the address
	 */
	public boolean proveriAdresuSt(String adresaSt) {
		boolean ret = true;
		if (adresaSt.isEmpty()) {
			ret = false;
		}
		return ret;

	}

	/**
	 * This method checks if the contact info of a student is valid.
	 * @param kontaktTl phone number of a student
	 * @return true or false depending on the validity of the phone number
	 */
	public boolean proveriKontaktTl(String kontaktTl) {
		boolean ret = true;
		if (!kontaktTl.matches("[0-9]{9,}")) {
			ret = false;
		}
		return ret;

	}
	
	/**
	 * This method checks if the email of a student is valid.
	 * @param email e-mail of a student
	 * @return true or false depending on the validity of the e-mail
	 */
	public boolean proveriEmail(String email) {
		boolean ret = true;
		if (!email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+")) {
			ret = false;
		}
		return ret;
	}
	
	/**
	 * This method checks if the index number of a student is valid.
	 * @param brojInd index number of a student
	 * @return true or false depending on the validity of the index number
	 */
	public boolean proveriBrojInd(String brojInd) {
		boolean ret = true;
		if (brojInd.isEmpty()) {
			ret = false;
		}
		for (Student s : BazaStudenata.getInstance().getStudenti()) {
			if (s.getBrojInd().equals(brojInd)) {
				return false;
			}
		}
		return ret;
	}
	
	/**
	 * This method checks if the year of enrollment of a student is valid.
	 * @param godUp enrollment year
	 * @return true or false depending on the validity of the enrollment year
	 */
	public boolean proveriGodUp(String godUp) {
		boolean ret = true;
		if (!godUp.matches("[1-2][0-9]{3}")) {
			ret = false;
		}
		return ret;

	}
	
	/**
	 * This methods implements giving a grade to a student.
	 * @param sifraP code of the subject
	 * @param imeP	the name of the subject
	 * @param ocena	the given grade
	 * @param datum	the date when the grade was given
	 * @return true or false depending on success of the action
	 */
	public boolean upisi(String sifraP, String imeP, int ocena, String datum) {
		BazaStudenata.getInstance().upisiOcenu(sifraP, imeP, ocena, datum);
		return true;
	}

	/**
	 * This methods implements deleting a subject from the failed exams.
	 * @return true or false depending on success of the action
	 */
	public boolean obrisi() {
		BazaStudenata.getInstance().brisanjeNepolozenih();
		return true;
	}
	
	/**
	 * This method implements adding a subject to the student.
	 * @param predmet the subject which is added to the student
	 */
	public void dodajStudentuPredmet(Predmet predmet) {
		// TODO Auto-generated method stub
		Student student = BazaStudenata.getInstance().getSelectedStudent(TabsPanel.tableStudent.getSelectedTableRow());
		BazaStudenata.getInstance().dodajPredmeteStudentu(student, predmet);
		DodavanjePredmetaStudentuDialog.tabelaListaPredmetaStudenta.update();
		IzmenaStudentaTabs.tableNepolozeniPredmeti.azurirajNepolozene();
	}

}