/*REFERENCA: VEZBE 6, BazaIgraca klasa*/
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.MenuToolbar;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;
	private ArrayList<Profesor> profesoriPronadjeni;
	private ArrayList<Profesor> profesoriSvi;
	private ArrayList<String> profNazivi;
	private boolean pretraga = false;
	private ArrayList<String> profPredajeNazivi;

	private BazaProfesora() {
		super();

		this.profesori = new ArrayList<Profesor>();
		this.profNazivi = new ArrayList<String>();
		this.profPredajeNazivi = new ArrayList<String>();
		this.profNazivi.add("Ime");
		this.profNazivi.add("Prezime");
		this.profNazivi.add("Titula");
		this.profNazivi.add("Zvanje");
		this.profPredajeNazivi.add("Šifra");
		this.profPredajeNazivi.add("Naziv");
		this.profPredajeNazivi.add("Godina studija");
		this.profPredajeNazivi.add("Semestar");

		Date d1 = parseDate("12.12.2020.");
		Date d2 = parseDate("10.03.2019.");
		this.profesori.add(new Profesor("Petrović", "Petar", d1, "Beograd", "069373994234", "petorvic@gmail.com",
				"Novi Sad", "123857364", Titula.Dr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("Lekić", "Dušan", d2, "Kraljevo", "069373994234", "dlekic@gmail.com", "Beograd",
				"987456321", Titula.Ms, Zvanje.VProfesor));
		this.profesoriSvi = this.profesori;
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

	public ArrayList<Profesor> getProfesoriSvi() {
		return this.profesoriSvi;
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

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.mm.yyyy.").parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public void dodajProfesora(String prezime, String ime, Date datumR, String adresaS, String kontaktTel, String email,
			String adresaK, String brlk, Titula titula, Zvanje zvanje) {
		if (pretraga) {
			this.profesoriSvi
					.add(new Profesor(prezime, ime, datumR, adresaS, kontaktTel, email, adresaK, brlk, titula, zvanje));
			pretraziProfesora(MenuToolbar.searchbar.getText());
		} else {
			this.profesori
					.add(new Profesor(prezime, ime, datumR, adresaS, kontaktTel, email, adresaK, brlk, titula, zvanje));
		}

	}

	public Profesor getSelectedProfesor(int red) {
		return this.profesori.get(red);
	}

	public void izmeniProfesora(Profesor izmenjeniProfesor, int index_izmenjenog) {
		this.profesori.get(index_izmenjenog).setIme(izmenjeniProfesor.getIme());
		this.profesori.get(index_izmenjenog).setPrezime(izmenjeniProfesor.getPrezime());
		this.profesori.get(index_izmenjenog).setDatumR(izmenjeniProfesor.getDatumR());
		this.profesori.get(index_izmenjenog).setAdresaS(izmenjeniProfesor.getAdresaS());
		this.profesori.get(index_izmenjenog).setKontaktTel(izmenjeniProfesor.getKontaktTel());
		this.profesori.get(index_izmenjenog).setEmail(izmenjeniProfesor.getEmail());
		this.profesori.get(index_izmenjenog).setAdresaK(izmenjeniProfesor.getAdresaK());
		this.profesori.get(index_izmenjenog).setTitula(izmenjeniProfesor.getTitula());
		this.profesori.get(index_izmenjenog).setZvanje(izmenjeniProfesor.getZvanje());
		this.profesori.get(index_izmenjenog).setBrlk(izmenjeniProfesor.getBrlk());
	}

	public void izbrisiProfesora(int index) {
		int i = 0;
		for (Profesor p : this.profesoriSvi) {
			if (p.getBrlk().equals(this.profesori.get(index).getBrlk())) {
				this.profesoriSvi.remove(i);
				break;
			}
			i++;
		}
		this.profesori.remove(index);
	}

	public void pretraziProfesora(String text) {
		this.profesoriPronadjeni = new ArrayList<Profesor>();
		this.profesori = this.profesoriSvi;
		int i = 0;
		int k = 0;

		String[] podeli = text.trim().split(" ");
		String[] trag = new String[3];

		for (String s : podeli) {
			String pom = s.trim();
			trag[i] = pom;
			i++;
		}
		k = i;
		if (trag[0].equals("ime") && trag[1].equals("prezime")) {
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage mora biti:  Prezime Ime ", "GREŠKA",
					JOptionPane.ERROR_MESSAGE);

		} else {
			for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
				if (p.getPrezime().contains(trag[0]) && k < 2) {
					this.profesoriPronadjeni.add(p);
				} else if (p.getPrezime().contains(trag[0]) && p.getIme().contains(trag[1]) && k == 2) {
					this.profesoriPronadjeni.add(p);
				}
			}
		}

		if (text.isEmpty()) {
			this.profesori = this.profesoriSvi;
			pretraga = false;
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage mora biti:  Prezime Ime", "Neuspešna pretraga",
					JOptionPane.ERROR_MESSAGE);
		} else {
			pretraga = true;
			this.profesori = this.profesoriPronadjeni;
		}

	}
	
	public ArrayList<Predmet> getPredavaniPredmeti(Profesor profesor) {
		return profesor.getPredmeti();
	}
	public void setPredmeti(Profesor profesor, ArrayList<Predmet> predmeti) {
		profesor.setPredmeti(predmeti);
	}
	public int getColumnCountPredavaniPredmeti() {
	
		return this.profPredajeNazivi.size();
	}
	
	public String getColumnNamePredavaniPredmeti(int column) {
		return this.profPredajeNazivi.get(column);
	}

	public Object getValueAtPredavaniPredmeti(Profesor profesor, int row, int column) {
		Predmet predmet = profesor.getPredmeti().get(row);
		switch (column) {
		case 0:
			return predmet.getSifraP();
		case 1:
			return predmet.getImeP();
		case 2:
			return "" + predmet.getGodinaS();
		case 3:
			return predmet.getSemestar();
		default:
			return null;
		}
	}

}
