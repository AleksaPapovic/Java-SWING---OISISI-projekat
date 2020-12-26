/*REFERENCA: VEZBE 6, BazaIgraca klasa*/ 
package model;

import java.util.ArrayList;

import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;

	private ArrayList<String> profNazivi;

	private BazaProfesora() {
		super();

		this.profesori = new ArrayList<Profesor>();

		this.profNazivi = new ArrayList<String>();
		this.profNazivi.add("Ime");
		this.profNazivi.add("Prezime");
		this.profNazivi.add("Titula");
		this.profNazivi.add("Zvanje");

		this.profesori.add(new Profesor("Petrović", "Petar", "18.12.1990.", "Beograd", "069373994234", "petorvic@gmail.com",
				"Novi Sad", "123857364", Titula.Dr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("Lekić", "Dušan", "20.10.2000.", "Kraljevo", "069373994234", "dlekic@gmail.com",
				"Beograd", "987456321", Titula.Ms, Zvanje.VProfesor));

	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int idx) {
		return this.profNazivi.get(idx);
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<String> getProfNazivi() {
		return profNazivi;
	}

	public void setProfNazivi(ArrayList<String> profNazivi) {
		this.profNazivi = profNazivi;
	}

	public static void setInstance(BazaProfesora instance) {
		BazaProfesora.instance = instance;
	}

	public String getValueAt(int row, int column) {

		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			if (profesor.getTitula() == Titula.ProfDr) {
				return "Profesor doktor";
			} else if (profesor.getTitula() == Titula.Dr) {
				return "Doktor";
			} else {
				return "Master";
			}
		case 3:
			if (profesor.getZvanje() == Zvanje.Saradnik) {
				return "Saradnik u nastavi";
			} else if (profesor.getZvanje() == Zvanje.Asistent) {
				return "Asistent";
			} else if (profesor.getZvanje() == Zvanje.RProfesor) {
				return "Redovni profesor";
			} else if (profesor.getZvanje() == Zvanje.VProfesor) {
				return "Vanredni profesor";
			} else if (profesor.getZvanje() == Zvanje.Docent) {
				return "Docent";
			} else {
				return "Docent";
			}
		default:
			return null;
		}
	}

	public void dodajProfesora(String prezime, String ime, String datumR, String adresaS, String kontaktTel,
			String email, String adresaK, String brlk, Titula titula, Zvanje zvanje) {
		this.profesori
				.add(new Profesor(prezime, ime, datumR, adresaS, kontaktTel, email, adresaK, brlk, titula, zvanje));

	}
}
