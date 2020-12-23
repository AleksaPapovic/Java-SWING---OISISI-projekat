package controller;

import java.util.Date;

import model.BazaStudenata;
import model.Student;

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

	public void dodajStudenta(String prezime, String ime, Date datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUp, String godSt, Student.Status status, double prosek) {

		BazaStudenata.getInstance().dodajStudenata(prezime, ime, datumR, adresaSt, kontaktTl, email, brojInd, godUp,
				godSt, status, prosek);
	}
}