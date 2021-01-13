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

public class StudentController {

	public static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	private StudentController() {

	}

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
				st.getKontaktTl(), st.getEmail(), st.getBrojInd(), st.getGodUp(), st.getGodSt(), st.getStatus(), 0);
		TabsPanel.tableStudent.update();
		return true;
	}

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
				godSt, status, 0.0);
		TabsPanel.tableStudent.update();
		return true;
	}

	public boolean izbrisiStudenta(int index) {

		BazaStudenata.getInstance().izbrisiStudenta(index);
		TabsPanel.tableStudent.update();
		return true;

	}

	public void pretragaStudenta(String text) {
		BazaStudenata.getInstance().pretraziStudenta(text);
		TabsPanel.tableStudent.update();
		;
	}

	public boolean proveriIme(String ime) {
		boolean ret = true;

		if (ime.isEmpty() || Character.isLowerCase(ime.charAt(0))) {
			ret = false;
		}
		return ret;

	}

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

	public boolean proveriAdresuSt(String adresaSt) {
		boolean ret = true;
		if (adresaSt.isEmpty()) {
			ret = false;
		}
		return ret;

	}

	public boolean proveriKontaktTl(String kontaktTl) {
		boolean ret = true;
		if (!kontaktTl.matches("[0-9]{9,}")) {
			ret = false;
		}
		return ret;

	}

	public boolean proveriEmail(String email) {
		boolean ret = true;
		if (!email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+")) {
			ret = false;
		}
		return ret;
	}

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

	public boolean proveriGodUp(String godUp) {
		boolean ret = true;
		if (!godUp.matches("[1-2][0-9]{3}")) {
			ret = false;
		}
		return ret;

	}

	public boolean upisi(String sifraP, String imeP, int ocena, String datum) {
		BazaStudenata.getInstance().upisiOcenu(sifraP, imeP, ocena, datum);
		return true;
	}

	public boolean obrisi() {
		BazaStudenata.getInstance().brisanjeOcene();
		return true;
	}

	public void dodajStudentuPredmet(Predmet predmet) {
		// TODO Auto-generated method stub
		Student student = BazaStudenata.getInstance().getSelectedStudent(TabsPanel.tableStudent.getSelectedTableRow());
		BazaStudenata.getInstance().dodajPredmeteStudentu(student, predmet);
		DodavanjePredmetaStudentuDialog.tabelaListaPredmetaStudenta.update();
		IzmenaStudentaTabs.tableNepolozeniPredmeti.azurirajNepolozene();
	}

}