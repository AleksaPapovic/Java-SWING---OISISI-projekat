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

//		Date d1 = parseDate("12.12.2020.");
//		Date d2 = parseDate("10.03.2019.");
//		this.profesori.add(new Profesor("Petrović", "Petar", d1, "Beograd", "069373994234", "petorvic@gmail.com",
//				"Novi Sad", "123857364", Titula.Dr, Zvanje.RProfesor));
//		this.profesori.add(new Profesor("Lekić", "Dušan", d2, "Kraljevo", "069373994234", "dlekic@gmail.com", "Beograd",
//				"987456321", Titula.Ms, Zvanje.VProfesor));
//		this.profesoriSvi = this.profesori;
		this.profesori = Entiteti.getInstance().getProfesori();
		//initProfesora();
		this.profesoriSvi = this.profesori;
	}

	public void initProfesora() {
		this.profesori.add(new Profesor("123123123", "Milos", "Nikolic", parseDate("12.12.1965."),
				"Temerinska 15, Novi Sad", "021356785", "milos.nikolic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 600", Titula.ProfDr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("321321321", "Nikola", "Mirkovic", parseDate("01.01.1978."),
				"Jovana Cvjica 25, Subotica", "021368456", "nikola.mirkovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 601", Titula.ProfDr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("456456456", "Ilija", "Petkovic", parseDate("03.09.1988."),
				"Gogoljeva 1, Novi Sad", "021215314", "ilija.petkovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 602", Titula.Dr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("789789789", "Mitar", "Petrovic", parseDate("25.07.1976."),
				"Marka Kraljevica 102, Beograd", "021884640", "mitar.petrovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 603", Titula.Dr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("001001001", "Vasa", "Micic", parseDate("14.02.1970."),
				"Tolstojeva 55, Novi Sad", "021212114", "vasa.micic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 604", Titula.Dr, Zvanje.Docent));
		this.profesori.add(new Profesor("002002002", "Srdjan", "Miletic", parseDate("20.04.1966."),
				"Šekspirova 12, Novi Sad", "021978225", "srdjan.miletic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 605", Titula.Dr, Zvanje.Docent));
		this.profesori.add(new Profesor("559585632", "Branislav", "Mihajlovic", parseDate("28.06.1980."),
				"Jovana Subotica 99, Novi Sad", "021778323", "branislav.mihajlovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 606", Titula.ProfDr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("334968855", "Marko", "Markovic", parseDate("31.01.1985."),
				"Mirka Markovica 101, Kraljevo", "021899659", "marko.markovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 607", Titula.ProfDr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("073070365", "Miloš", "Milakovic", parseDate("21.09.1975."),
				"Brace Jugovic 1, Kragujevac", "021122326", "milos.milakovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 608", Titula.Dr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("006003786", "Lazar", "Bratic", parseDate("13.11.1973."),
				"Jovanke Orleanke 3, Niš", "021156326", "lazar.bratic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 609", Titula.Dr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("158496152", "Ljeposava", "Dražic", parseDate("11.08.1964."),
				"Vojvode Stepe 1100, Beograd", "021888156", "ljeposava.drazic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 610", Titula.Dr, Zvanje.Docent));
		this.profesori.add(new Profesor("777348595", "Miroljub", "Dragic", parseDate("02.03.1959."),
				"Miše Ljubibratice 123, Aleksandrovac", "021456125", "miroljub.dragic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 611", Titula.Dr, Zvanje.Docent));
		this.profesori.add(new Profesor("721254363", "Bogdan", "Rekavic", parseDate("23.06.1977."),
				"Resavska 12, Beograd", "021886455", "bogdan.rekavic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 612", Titula.Dr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("225533448", "Stanka", "Milic", parseDate("03.03.1990."),
				"Vidakoviceva 90, Novi Sad", "021945255", "stanka.milic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 613", Titula.Dr, Zvanje.Docent));
		this.profesori.add(new Profesor("111555888", "Milica", "Vukovic", parseDate("18.10.1967."),
				"Nikoliceva 12, Novi Sad", "021746659", "milica.vukovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 614", Titula.ProfDr, Zvanje.VProfesor));
		this.profesori.add(new Profesor("003003003", "Miša", "Mišic", parseDate("20.10.1969."), "Šojiceva 10, Subotica",
				"021489326", "misa.misic@mailinator.com", "Dositeja Obradovica 6, Novi Sad, NTP 615", Titula.Dr,
				Zvanje.Docent));
		this.profesori.add(new Profesor("004004004", "Branko", "Maricic", parseDate("18.01.1973."),
				"Nikole Tesle 25, Sombor", "021487265", "branko.maricic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 616", Titula.ProfDr, Zvanje.Docent));
		this.profesori.add(new Profesor("005005005", "Branislav", "Lukovic", parseDate("08.04.1982."),
				"Živojina Mišica 7, Apatin", "021159478", "branislav.lukovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 617", Titula.Dr, Zvanje.RProfesor));
		this.profesori.add(new Profesor("006006006", "Branimir", "Obradovic", parseDate("07.01.1979."),
				"Stari šor 18, Sremska Mitrovica", "021922333", "branimir.obradovic@mailinator.com",
				"Dositeja Obradovica 6, Novi Sad, NTP 618", Titula.ProfDr, Zvanje.Docent));

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
		this.profesoriSvi = this.profesori;
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
	}

	public Profesor nadjiProfesora(String brlk) {
		for (Profesor p : this.profesori) {
			if (p.getBrlk().equals(brlk)) {
				return p;
			}
		}
		return null;
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

	public ArrayList<Predmet> getNePredajePredmeteProfesor(Profesor profesor) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
		// predmeti.removeAll(profesor.getPredmeti());
		return predmeti;
	}

	public void dodajPredmetePofesoru(Profesor profesor, ArrayList<Predmet> predmeti) {
		profesor.getPredmeti().addAll(predmeti);
	}

	public void izbrisiPredmet(Predmet obrisaniPredmet) {
		for (Profesor prof : profesori) {
			for (Predmet p : prof.getPredmeti()) {
				if (p.getSifraP().equals(obrisaniPredmet.getSifraP())) {
					prof.getPredmeti().remove(p);
					break;
				}
			}
		}

	}
	
	public void dodajPredmetPofesoru(Profesor profesor, Predmet predmet) {
		profesor.getPredmeti().add(predmet);
	} 

	public void uklanjanjeProfesoruSaPredmeta(Predmet p) {
	p.setPredProf(null);
		
	}


}
