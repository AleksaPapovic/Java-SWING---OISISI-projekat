/*REFERENCA: VEZBE 6, Igrac klasa*/
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements constructors, getters and setters for student entity.
 * 
 * @author Dusan Lekic
 *
 */
public class Student {

	public enum Status {
		B, S
	};

	public static int brojac = 0;
	private String prezime;
	private String ime;
	private Date datumR;
	private String adresaSt;
	private String kontaktTl;
	private String email;
	private String brojInd;
	private int godUp;
	private int godSt;
	private Status status;
	private double prosek;
	private ArrayList<Ocena> polozeniIsp;
	private ArrayList<Predmet> nepolozeniIsp;

	/**
	 * Default constructor without parameters.
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param prezime   surname of the student
	 * @param ime       name of the student
	 * @param datumR    birth date of the student
	 * @param adresaSt  address of the student
	 * @param kontaktTl contact info of the student
	 * @param email     email of the student
	 * @param brojInd   index number of the student
	 * @param godUp     enrollment year of the student
	 * @param godSt     current year of study of the student
	 * @param status    status of the student
	 * @param prosek    GPA of the student
	 */
	public Student(String ime, String prezime, Date datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUp, int godSt, Status status, double prosek) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumR = datumR;
		this.adresaSt = adresaSt;
		this.kontaktTl = kontaktTl;
		this.email = email;
		this.brojInd = brojInd;
		this.godUp = godUp;
		this.godSt = godSt;
		this.status = status;
		this.prosek = prosek;
		this.nepolozeniIsp = new ArrayList<Predmet>();
		this.polozeniIsp = new ArrayList<Ocena>();
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param brojInd   index number of the student
	 * @param ime       name of the student
	 * @param prezime   surname of the student
	 * @param godSt     current year of study of the student
	 * @param datumR    birth date of the student
	 * @param adresaSt  address of the student
	 * @param kontaktTl contact info of the student
	 * @param email     email of the student
	 * @param status    status of the student
	 * @param godUp     enrollment year of the student
	 */
	public Student(String brojInd, String ime, String prezime, int godSt, Date datumR, String adresaSt,
			String kontaktTl, String email, Status status, int godUp) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumR = datumR;
		this.adresaSt = adresaSt;
		this.kontaktTl = kontaktTl;
		this.email = email;
		this.brojInd = brojInd;
		this.godUp = godUp;
		this.godSt = godSt;
		this.status = status;
		this.nepolozeniIsp = new ArrayList<Predmet>();
		this.polozeniIsp = new ArrayList<Ocena>();
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param brojInd index number of the student
	 * @param ime     name of the student
	 * @param prezime surname of the student
	 * @param godSt   current year of study of the student
	 * @param status  status of the student
	 * @param prosek  GPA of the student
	 */
	public Student(String brojInd, String ime, String prezime, int godSt, Status status, double prosek) {
		super();
		this.brojInd = brojInd;
		this.ime = ime;
		this.prezime = prezime;
		this.godSt = godSt;
		this.status = status;
		this.prosek = prosek;
		this.nepolozeniIsp = new ArrayList<Predmet>();
		this.polozeniIsp = new ArrayList<Ocena>();
	}

	/**
	 * This method returns the surname of the student.
	 * 
	 * @return surname of the student
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * This method sets the surname of the student.
	 * 
	 * @param prezime surname which is set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * This method returns the name of the student.
	 * 
	 * @return name of the student
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * This method sets the name of the student.
	 * @param ime name of the student
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * This method returns the birth date of the student.
	 * 
	 * @return birth date of the student
	 */
	public Date getDatumR() {
		return datumR;
	}

	/**
	 * This method sets the birth date of the student.
	 * @param datumR birth date of the student
	 */
	public void setDatumR(Date datumR) {
		this.datumR = datumR;
	}

	/**
	 * This method returns the address of the student.
	 * 
	 * @return address of the student
	 */
	public String getAdresaSt() {
		return adresaSt;
	}

	/**
	 * This method sets the address of the student.
	 * @param adresaSt address of the student.
	 */
	public void setAdresaSt(String adresaSt) {
		this.adresaSt = adresaSt;
	}

	/**
	 * This method returns the contact info of the student.
	 * 
	 * @return contact info of the student
	 */
	public String getKontaktTl() {
		return kontaktTl;
	}

	/**
	 * This method sets the contact info of the student.
	 * @param kontaktTl contact info of the student.
	 */
	public void setKontaktTl(String kontaktTl) {
		this.kontaktTl = kontaktTl;
	}

	/**
	 * This method returns the email of the student.
	 * 
	 * @return email of the student
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets the email of the student.
	 * @param email email of the student.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns the index number of the student.
	 * 
	 * @return index number of the student
	 */
	public String getBrojInd() {
		return brojInd;
	}

	/**
	 * This method sets the index number of the student.
	 * @param brojInd index number of the student.
	 */
	public void setBrojInd(String brojInd) {
		this.brojInd = brojInd;
	}

	/**
	 * This method returns the enrollment year of the student.
	 * 
	 * @return enrollment year of the student
	 */
	public int getGodUp() {
		return godUp;
	}

	/**
	 * This method sets the enrollment year of the student.
	 * @param godUp enrollment year of the student.
	 */
	public void setGodUp(int godUp) {
		this.godUp = godUp;
	}

	/**
	 * This method returns the year of study of the student.
	 * 
	 * @return year of study of the student
	 */
	public int getGodSt() {
		return godSt;
	}

	/**
	 * This method sets the year of study of the student.
	 * @param godSt year of study of the student.
	 */
	public void setGodSt(int godSt) {
		this.godSt = godSt;
	}

	/**
	 * This method returns the status of the student.
	 * 
	 * @return status of the student
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * This method sets the status of the student.
	 * @param status status of the student.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * This method returns the GPA of the student.
	 * 
	 * @return GPA of the student
	 */
	public double getProsek() {
		int brOcena = 0;
		int sum = 0;
		for (Ocena ocena : polozeniIsp) {
			sum += ocena.getOcenaVr();
			brOcena++;
		}
		try {
			prosek = sum / brOcena;
		} catch (ArithmeticException e) {
			// TODO: handle exception
		}
		;
		return prosek;
	}

	/**
	 * This method sets the GPA of the student.
	 * @param prosek GPA of the student
	 */
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	/**
	 * This method returns the passed exams of the student.
	 * 
	 * @return passed exams of the student
	 */
	public ArrayList<Ocena> getPolozeniIsp() {
		return polozeniIsp;
	}

	/**
	 * This method sets the passed exams of the student.
	 * @param polozeniIsp passed exams of the student
	 */
	public void setPolozeniIsp(ArrayList<Ocena> polozeniIsp) {
		this.polozeniIsp = polozeniIsp;
	}

	/**
	 * This method returns the failed exams of the student.
	 * 
	 * @return failed exams of the student
	 */
	public ArrayList<Predmet> getNepolozeniIsp() {
		return nepolozeniIsp;
	}

	/**
	 * This method sets the failed exams of the student.
	 * @param nepolozeniIsp failed exams of the student
	 */
	public void setNepolozeniIsp(ArrayList<Predmet> nepolozeniIsp) {
		this.nepolozeniIsp = nepolozeniIsp;
	}

}
