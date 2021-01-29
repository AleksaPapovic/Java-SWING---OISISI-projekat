/*REFERENCA: VEZBE 6, Igrac klasa*/

package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements constructors, getters and setters for professor entity.
 * 
 * @author Aleksa Papovic
 *
 */
public class Profesor {
  /**
   * 
   * This is enumeration for professor title,
   * title could be Master , Doktor, Profesor Doktor
   * @author Aleksa Papovic
   * 
   */
	public enum Titula {
		Ms, Dr, ProfDr
	};
	/**
	 * This is enumeration for professor title,
     * title could be Saradnik, Asistent, Redovni Profesor, Vanredni Profesor, Docent
	 * @author Aleksa Papovic
	 *
	 */
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

	/**
	 * Default constructor without parameters.
	 */
	public Profesor() {
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param prezime    surname of the professor
	 * @param ime        name of the professor
	 * @param datumR     birth date of the professor
	 * @param adresaS    address of the professor
	 * @param kontaktTel contact info of the professor
	 * @param email      email of the professor
	 * @param adresaK    professor's office address
	 * @param brlk       ID number of the professor
	 * @param titula     title of the professor
	 * @param zvanje     title of the professor
	 */
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

	/**
	 * Constructor with parameters.
	 * 
	 * @param prezime    surname of the professor
	 * @param ime        name of the professor
	 * @param datumR     birth date of the professor
	 * @param adresaS    address of the professor
	 * @param kontaktTel contact info of the professor
	 * @param email      email of the professor
	 * @param adresaK    professor's office address
	 * @param brlk       ID number of the professor
	 * @param titula     title of the professor
	 * @param zvanje     title of the professor
	 */
	public Profesor(String brlk, String ime, String prezime, Date datumR, String adresaS, String kontaktTel,
			String email, String adresaK, Titula titula, Zvanje zvanje) {
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

	/**
	 * Constructor with parameters.
	 * 
	 * @param prezime    surname of the professor
	 * @param ime        name of the professor
	 * @param datumR     birth date of the professor
	 * @param adresaS    address of the professor
	 * @param kontaktTel contact info of the professor
	 * @param email      email of the professor
	 * @param adresaK    professor's office address
	 * @param brlk       ID number of the professor
	 */
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

	/**
	 * Constructor with parameter of type Profesor.
	 * 
	 * @param prof the professor 
	 */
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

	/**
	 * This method returns the surname of the professor.
	 * 
	 * @return surname of the professor
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * This method sets the surname of the professor.
	 * 
	 * @param prezime surname which is set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * This method returns the name of the professor.
	 * 
	 * @return name of the professor
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * This method sets the first name of the professor.
	 * 
	 * @param ime first name which is set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * This method returns the birth date of the professor.
	 * 
	 * @return birth date of the professor
	 */
	public Date getDatumR() {
		return this.datumR;
	}

	/**
	 * This method sets the birth date of the professor.
	 * 
	 * @param datumR birth date of the professor
	 */
	public void setDatumR(Date datumR) {
		this.datumR = datumR;
	}

	/**
	 * This method returns address of the professor.
	 * 
	 * @return address of the professor
	 */
	public String getAdresaS() {
		return adresaS;
	}

	/**
	 * This method sets address of the professor.
	 * 
	 * @param adresaS address of the professor
	 */
	public void setAdresaS(String adresaS) {
		this.adresaS = adresaS;
	}

	/**
	 * This method returns contact info of the professor.
	 * 
	 * @return contact info of the professor.
	 */
	public String getKontaktTel() {
		return kontaktTel;
	}

	/**
	 * This method sets contact info of the professor.
	 * 
	 * @param kontaktTel contact info of the professor
	 */
	public void setKontaktTel(String kontaktTel) {
		this.kontaktTel = kontaktTel;
	}

	/**
	 * This method returns email of the professor.
	 * 
	 * @return email of the professor.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets email of the professor.
	 * 
	 * @param email email of the professor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns  professor's office address
	 * 
	 * @return  professor's office address
	 */
	public String getAdresaK() {
		return adresaK;
	}

	/**
	 * This method sets professor's office address of the professor.
	 * 
	 * @param adresaK professor's office address
	 */
	public void setAdresaK(String adresaK) {
		this.adresaK = adresaK;
	}

	/**
	 * This method returns ID number of the professor
	 * 
	 * @return ID number
	 */
	public String getBrlk() {
		return brlk;
	}

	/**
	 * This method sets ID number of the professor.
	 * 
	 * @param brlk ID number of the professor
	 */
	public void setBrlk(String brlk) {
		this.brlk = brlk;
	}

	/**
	 * This method returns title of the professor
	 * 
	 * @return title
	 */
	public Titula getTitula() {
		return titula;
	}

	/**
	 * This method sets title of the professor.
	 * 
	 * @param titula title
	 */
	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	/**
	 * This method returns title of the professor
	 * 
	 * @return title
	 */
	public Zvanje getZvanje() {
		return zvanje;
	}

	/**
	 * This method sets title of the professor.
	 * 
	 * @param zvanje title
	 */
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	/**
	 * This method returns list of subjects for the professor
	 * 
	 * @return list of subjects for the professor
	 */
	public ArrayList<Predmet> getPredmeti() {
		return this.predmeti;
	}

	/**
	 * This method sets list of subjects for the professor.
	 * 
	 * @param predmeti list of subjects
	 */
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

}
