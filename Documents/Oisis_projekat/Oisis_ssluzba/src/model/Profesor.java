/*REFERENCA: VEZBE 6, Igrac klasa*/

package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor {

	public enum Titula {
		Ms, Dr, ProfDr
	};

	public enum Zvanje {
		Saradnik, Asistent, RProfesor, VProfesor, Docent
	};

	private String prezime;
	private String ime;
	private Date datumR;
	private String adresaS;
	private String kontaktTel;
	private String email;
	private String adresaK;
	private String brlk;
	private Titula titula;
	private Zvanje zvanje;
	ArrayList<Predmet> predmeti;

	public Profesor() {
	}

	public Profesor(String prezime, String ime, Date datumR, String adresaS, String kontaktTel, String email,
			String adresaK, String brlk, Titula titula, Zvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumR = datumR;
		this.adresaS = adresaS;
		this.kontaktTel = kontaktTel;
		this.email = email;
		this.adresaK = adresaK;
		this.brlk = brlk;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Profesor(String prezime, String ime, Date datumR, String adresaS, String kontaktTel, String email,
			String adresaK, String brlk) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumR = datumR;
		this.adresaS = adresaS;
		this.kontaktTel = kontaktTel;
		this.email = email;
		this.adresaK = adresaK;
		this.brlk = brlk;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Profesor(Profesor prof) {
		this.prezime = prof.prezime;
		this.ime = prof.ime;
		this.datumR = prof.datumR;
		this.adresaS = prof.adresaS;
		this.kontaktTel = prof.kontaktTel;
		this.email = prof.email;
		this.adresaK = prof.adresaK;
		this.brlk = prof.brlk;
		this.titula = prof.titula;
		this.zvanje = prof.zvanje;
		this.predmeti = prof.predmeti;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumR() {
		return this.datumR;
	}

	public void setDatumR(Date datumR) {
		this.datumR = datumR;
	}

	public String getAdresaS() {
		return adresaS;
	}

	public void setAdresaS(String adresaS) {
		this.adresaS = adresaS;
	}

	public String getKontaktTel() {
		return kontaktTel;
	}

	public void setKontaktTel(String kontaktTel) {
		this.kontaktTel = kontaktTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaK() {
		return adresaK;
	}

	public void setAdresaK(String adresaK) {
		this.adresaK = adresaK;
	}

	public String getBrlk() {
		return brlk;
	}

	public void setBrlk(String brlk) {
		this.brlk = brlk;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

}
