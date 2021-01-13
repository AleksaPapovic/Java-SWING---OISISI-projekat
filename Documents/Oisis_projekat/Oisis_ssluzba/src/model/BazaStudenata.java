/*REFERENCA: VEZBE 6, BazaIgraca klasa*/
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Student.Status;
import view.IzmenaStudentaTabs;
import view.MenuToolbar;
import view.TabsPanel;

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
	private ArrayList<String> kolonePolozeniP;
	private ArrayList<String> koloneNepolozeniP;
	private ArrayList<Student> studentiPronadjeni;
	private ArrayList<Student> studentiSvi;
	private boolean pretraga = false;

	private BazaStudenata() {
		this.Studenti = new ArrayList<Student>();

		this.kolone = new ArrayList<String>();
		this.koloneNepolozeniP = new ArrayList<String>();
		this.kolonePolozeniP = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		this.koloneNepolozeniP.add("Šifra predmeta");
		this.koloneNepolozeniP.add("Naziv predmeta");
		this.koloneNepolozeniP.add("ESPB");
		this.koloneNepolozeniP.add("Godina studija");
		this.koloneNepolozeniP.add("Semestar");
		this.kolonePolozeniP.add("Šifra predmeta");
		this.kolonePolozeniP.add("Naziv predmeta");
		this.kolonePolozeniP.add("ESPB");
		this.kolonePolozeniP.add("Godina studija");
		this.kolonePolozeniP.add("Datum");

		this.Studenti = Entiteti.getInstance().getStudenti();
		this.studentiSvi = this.Studenti;
	}

	@SuppressWarnings("unused")
	private void initStudente() {

	}
	
	public ArrayList<Student> getStudentiSvi() {
		return Studenti;
	}

	public void setStudentiSvi(ArrayList<Student> Studenti) {
		this.Studenti = Studenti;
		this.studentiSvi = Studenti;
	}
	
	public ArrayList<Student> getStudenti() {
		return Studenti;
	}

	public void setStudenti(ArrayList<Student> Studenti) {
		this.Studenti = Studenti;
		this.studentiSvi = Studenti;
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

	public void dodajStudenta(String prezime, String ime, Date datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUp, int godSt, Status status, double prosek) {
		if (pretraga) {
			this.studentiSvi.add(new Student(prezime, ime, datumR, adresaSt, kontaktTl, email, brojInd, godUp, godSt,
					status, prosek));
			pretraziStudenta(MenuToolbar.searchbar.getText());
		} else {
			this.Studenti.add(new Student(prezime, ime, datumR, adresaSt, kontaktTl, email, brojInd, godUp, godSt,
					status, prosek));
		}
	}

	public void izbrisiStudenta(String brojInd) {
		for (Student i : this.studentiSvi) {
			if (i.getBrojInd() == brojInd) {
				this.studentiSvi.remove(i);
				break;
			}
		}
	}

	public void izmeniStudenta(int index, String prezime, String ime, Date datumR, String adresaSt, String kontaktTl,
			String email, String brojInd, int godUp, int godSt, Student.Status status, double prosek) {

		if (Studenti.get(index).getBrojInd().equals(brojInd)) {
			Studenti.get(index).setIme(ime);
			Studenti.get(index).setPrezime(prezime);
			Studenti.get(index).setDatumR(datumR);
			Studenti.get(index).setAdresaSt(adresaSt);
			Studenti.get(index).setKontaktTl(kontaktTl);
			Studenti.get(index).setEmail(email);
			Studenti.get(index).setGodUp(godUp);
			Studenti.get(index).setGodSt(godSt);
			Studenti.get(index).setStatus(status);
			Studenti.get(index).setProsek(prosek);
		}
		if (pretraga) {
			pretraziStudenta(MenuToolbar.searchbar.getText());
		}

	}

	public void izbrisiStudenta(int index) {
		int i = 0;
		for (Student p : this.studentiSvi) {
			if (p.getBrojInd().equals(this.Studenti.get(index).getBrojInd())) {
				this.studentiSvi.remove(i);
				break;
			}
			i++;
		}
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Nevalidan datum", "GRESKA",
			// JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public ArrayList<Ocena> getPolozeniPredmeti(Student student) {
		return student.getPolozeniIsp();
	}

	public int getColumnCountPolozeniPredmeti() {
		return this.kolonePolozeniP.size();
	}

	public String getColumnNamePolozeniPredmeti(int column) {
		return this.kolonePolozeniP.get(column);
	}

	public ArrayList<Predmet> getNepolozeniPredmeti(Student student) {
		return student.getNepolozeniIsp();
	}

	public int getColumnCountNepolozeniPredmeti() {
		return this.koloneNepolozeniP.size();
	}

	public String getColumnNameNepolozeniPredmeti(int column) {
		return this.koloneNepolozeniP.get(column);
	}

	public Object getValueAtPolozeniPredmeti(Student student, int row, int column) {
		Ocena ocena = student.getPolozeniIsp().get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraP();
		case 1:
			return ocena.getPredmet().getImeP();
		case 2:
			return ocena.getPredmet().getBrojESPB();
		case 3:
			return ocena.getOcenaVr();
		case 4:
			return ocena.getDatumPl();
		default:
			return null;
		}
	}

	public Object getValueAtNepolozeniPredmeti(Student student, int row, int column) {
		Predmet predmet = student.getNepolozeniIsp().get(row);
		switch (column) {
		case 0:
			return predmet.getSifraP();
		case 1:
			return predmet.getImeP();
		case 2:
			return "" + predmet.getBrojESPB();
		case 3:
			return "" + predmet.getGodinaS();
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}

	public void upisiOcenu(String sifraP, String imeP, Integer ocena, String datumUpisa) {
		Date upisDatum = parseDate(datumUpisa);
		Student s = getSelectedStudent(TabsPanel.tableStudent.getSelectedTableRow());
		Predmet p = BazaPredmeta.getInstance().nadjiPredmet(sifraP);
		s.getPolozeniIsp().add(new Ocena(s, p, ocena, upisDatum));
		s.getNepolozeniIsp().remove(IzmenaStudentaTabs.tableNepolozeniPredmeti.getSelectedRow());
		IzmenaStudentaTabs.tableNepolozeniPredmeti.azurirajNepolozene();
		IzmenaStudentaTabs.tablePolozeniPredmeti.update();
	}

	public void brisanjeNepolozenih() {
		Student s = getSelectedStudent(TabsPanel.tableStudent.getSelectedTableRow());
		int index = IzmenaStudentaTabs.tableNepolozeniPredmeti.getSelectedRow();
		Predmet pr = s.getNepolozeniIsp().get(index);
		s.getNepolozeniIsp().remove(index);
		BazaPredmeta.getInstance().dodajPredmet(pr.getSifraP(), pr.getImeP(), pr.getBrojESPB(), pr.getGodinaS(),
				pr.getSemestar());
		IzmenaStudentaTabs.tableNepolozeniPredmeti.azurirajNepolozene();

	}

	public Student getSelectedStudent(int red) {
		return this.Studenti.get(red);
	}

	public void izbrisiPredmet(Predmet obrisaniPredmet) {
		for (Student s : this.Studenti) {
			for (Predmet p : s.getNepolozeniIsp()) {
				if (p.getSifraP().equals(obrisaniPredmet.getSifraP())) {
					s.getNepolozeniIsp().remove(p);
					break;
				}
			}
			for (Ocena o : s.getPolozeniIsp()) {
				if (o.getPredmet().getSifraP().equals(obrisaniPredmet.getSifraP())) {
					s.getPolozeniIsp().remove(o);
					break;
				}
			}
		}
	}

	public void pretraziStudenta(String text) {
		this.studentiPronadjeni = new ArrayList<Student>();
		this.Studenti = this.studentiSvi;
		int i = 0;
		int k = 0;

		String[] podeli = text.trim().split(" ");
		String[] trag = new String[4];

		for (String s : podeli) {
			String pom = s.trim();
			trag[i] = pom;
			i++;
		}
		k = i;

		for (Student s : this.Studenti) {
			if (s.getPrezime().contains(trag[0]) && k < 2) {
				this.studentiPronadjeni.add(s);
			} else if (s.getPrezime().contains(trag[0]) && s.getIme().contains(trag[1]) && k < 3) {
				this.studentiPronadjeni.add(s);
			} else if (s.getPrezime().contains(trag[0]) && s.getIme().contains(trag[1])
					&& s.getBrojInd().contains(trag[2]) && k == 3) {
				this.studentiPronadjeni.add(s);
			}
		}

		if (text.isEmpty()) {
			this.Studenti = this.studentiSvi;
			pretraga = false;
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage mora biti:  Prezime Ime BrojIndeksa",
					"Neuspešna pretraga", JOptionPane.ERROR_MESSAGE);
		} else {
			pretraga = true;
			this.Studenti = this.studentiPronadjeni;
		}

	}

	public void dodajPredmeteStudentu(Student student, Predmet predmet) {
		student.getNepolozeniIsp().add(predmet);
	}

	public ArrayList<Predmet> getNeradjeneIspite(Student student) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		for (Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			boolean radjenPol = false;
			boolean radjenNep = false;
			boolean istiSem = false;
			for (Ocena pol : student.getPolozeniIsp()) {
				if (p.getSifraP().equals(pol.getPredmet().getSifraP())) {
					radjenPol = true;
				}
			}
			for (Predmet nep : student.getNepolozeniIsp()) {
				if (p.getSifraP().equals(nep.getSifraP())) {
					radjenNep = true;
				}
			}
			if (student.getGodSt() >= p.getGodinaS()) {
				istiSem = true;
			}
			if (!radjenPol && !radjenNep && istiSem) {
				predmeti.add(p);
			}

		}
		return predmeti;
	}
}
