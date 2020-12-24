package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private ArrayList<Student> Studenti;
	private ArrayList<String> kolone;

	private BazaStudenata() {

		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

		this.initStudente();
	}

	private void initStudente() {
		this.Studenti = new ArrayList<Student>();
		Studenti.add(new Student("Nikolic", "Nikola", parseDate("20.01.2011."), "Zmajevacka 112", "0635652214",
				"milenkozfk@gmail.com", "RA178-2016", 2015, "I(Prva)", Student.Status.B, 9.05));
	}

	public List<Student> getStudenti() {
		return Studenti;
	}

	public void setStudenti(ArrayList<Student> Studenti) {
		this.Studenti = Studenti;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.Studenti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Student Student = this.Studenti.get(row);
		switch (column) {
		case 0:
			return Student.getBrojInd();
		case 1:
			return Student.getIme();
		case 2:
			return Student.getPrezime();
		case 3:
			return Student.getGodSt();
		case 4:
			if (Student.getStatus() == Status.B)
				return "Budzet";
			else
				return "Samofinansiranje";
		case 5:
			return Double.toString(Student.getProsek());
		default:
			return null;
		}
	}

	public void dodajStudenata(String prezime, String ime, Date datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUp, String godSt, Student.Status status, double prosek) {
		this.Studenti.add(
				new Student(prezime, ime, datumR, adresaSt, kontaktTl, email, brojInd, godUp, godSt, status, prosek));
	}

	public void izbrisiStudenata(String brojInd) {
		for (Student i : Studenti) {
			if (i.getBrojInd() == brojInd) {
				Studenti.remove(i);
				break;
			}
		}
	}

	public void izmeniStudenata(String prezime, String ime, Date datumR, String adresaSt, String kontaktTl,
			String email, String brojInd, int godUp, String godSt, Student.Status status, double prosek,
			ArrayList<Ocena> polozeniIsp, ArrayList<Ocena> nepolozeniIsp) {
		for (Student i : Studenti) {
			if (i.getBrojInd() == brojInd) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setAdresaSt(adresaSt);
				i.setAdresaSt(adresaSt);
				i.setEmail(email);
				i.setGodUp(godUp);
				i.setKontaktTl(kontaktTl);
				i.setProsek(prosek);
				i.setPolozeniIsp(nepolozeniIsp);
				i.setNepolozeniIsp(nepolozeniIsp);
			}
		}
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
