package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {

	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null ) {
			instance = new BazaProfesora();
		}
	  return instance;
	}
	
	private List<Profesor> profesori;
	

	private List<String>   profNazivi;
	
	
	private BazaProfesora() {
		super();
		
		this.profesori  = new ArrayList<Profesor>();
			
		this.profNazivi = new ArrayList<String>();
		this.profNazivi.add("Prezime");
		this.profNazivi.add("Ime");
		this.profNazivi.add("Datum rođenja");
		this.profNazivi.add("Adresa stanovanja");
		this.profNazivi.add("Kontakt telefon");
		this.profNazivi.add("Email");
		this.profNazivi.add("Adresa kancelarije");
		this.profNazivi.add("Broj lične karte");
		this.profNazivi.add("Titula");
		this.profNazivi.add("Zvanje");
		this.profNazivi.add("Spisak predmeta");
		
		this.profesori.add(new Profesor("Petorivc","Petar","18.12.1990","Beograd","0003","petorvic@gmail.com","Novi Sad","0008657"));
		this.profesori.add(new Profesor());
		
		
	}
	public int getColumnCount() {
		return 11;
	}
	
	public String getColumnName(int idx) {
		return this.profNazivi.get(idx);
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}
	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<String> getProfNazivi() {
		return profNazivi;
	}
	public void setProfNazivi(List<String> profNazivi) {
		this.profNazivi = profNazivi;
	}
	public static void setInstance(BazaProfesora instance) {
		BazaProfesora.instance = instance;
	}

	public Object getValueAt(int row, int column) {
		
		Profesor profesor = this.profesori.get(row);
		
		switch(column) {
		case 0:
			return profesor.getPrezime();
		case 1:
			return profesor.getIme();
		case 2: 
			return profesor.getDatumR();
		case 3:
			return profesor.getAdresaS();
		case 4:
			return profesor.getKontaktTel();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaK();
		case 7:
			return profesor.getBrlk();
		case 8:
			if (profesor.getTitula() == Titula.ProfDr) { 
				return "Prof. Dr.";
			} else if (profesor.getTitula() == Titula.Dr) {
				return "Doktor";
			} else {
				return "Master";
			}
		case 9:
			if (profesor.getZvanje() == Zvanje.Saradnik) {
				return "Saradnik u nastavi";
			} else if(profesor.getZvanje() == Zvanje.Asistent) {
				return "Asistent";
			} else if (profesor.getZvanje() == Zvanje.RProfesor) {
				return "Redovni profesor";  
			} else if (profesor.getZvanje() == Zvanje.VProfesor) {
				return "Vanredni profesor";
			}
			else if (profesor.getZvanje() == Zvanje.Docent) {
				return "Docent";
			}
			else {
				return "Docent";
			}
		default:
			return null;
		}
	}
	
	public void dodajProfesora(String prezime, String ime, String datumR, String adresaS, String kontaktTel, String email,
				  	           String adresaK, String brlk, Titula titula, Zvanje zvanje)
	{}
}

