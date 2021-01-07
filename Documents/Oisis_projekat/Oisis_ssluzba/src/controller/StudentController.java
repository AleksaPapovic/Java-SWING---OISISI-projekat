/*REFERENCA: VEZBE 6, IgraciController klasa*/ 
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gui.DodavanjeStudentaDialog;
import gui.TabsPanel;
import model.BazaStudenata;
import model.Student;
import model.Student.Status;

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
		
		String email=DodavanjeStudentaDialog.emailField.getText();
		st.setEmail(email);
		
		st.setBrojInd(DodavanjeStudentaDialog.brIndField.getText());
		
		String godUp= DodavanjeStudentaDialog.godUpField.getText();
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
		
		Status status=null;

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
		
		BazaStudenata.getInstance().dodajStudenata(st.getIme(), st.getPrezime(), st.getDatumR(), st.getAdresaSt(),
				st.getKontaktTl(), st.getEmail(), st.getBrojInd(), st.getGodUp(), st.getGodSt(), st.getStatus(), 0);
		TabsPanel.tableStudent.update();
		return true;
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

}