package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {

	public enum Status {
		B, S
	};

	private String prezime;
	private String ime;
	private Date datumR;
	private String adresaSt;
	private String kontaktTl;
	private String email;
	private String brojInd;
	private int godUp;
	private String godSt;
	private Status status;
	private double prosek;
	private ArrayList<Ocena> polozeniIsp;
	private ArrayList<Ocena> nepolozeniIsp;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String prezime, String ime, Date datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUp, String godSt, Status status, double prosek, ArrayList<Ocena> polozeniIsp,
			ArrayList<Ocena> nepolozeniIsp) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumR = datumR;
		this.adresaSt = adresaSt;
		this.kontaktTl = kontaktTl;
		this.email = email;
		this.brojInd = brojInd;
		this.godUp = godUp;
		this.godSt = godSt;
		this.status = status;
		this.prosek = prosek;
		this.polozeniIsp = polozeniIsp;
		this.nepolozeniIsp = nepolozeniIsp;
	}
	
	

	public Student(String brojInd, String ime, String prezime, String godSt, Status status, double prosek) {
		super();
		this.brojInd = brojInd;
		this.ime = ime;
		this.prezime = prezime;
		this.godSt = godSt;
		this.status = status;
		this.prosek = prosek;
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
		return datumR;
	}

	public void setDatumR(Date datumR) {
		this.datumR = datumR;
	}

	public String getAdresaSt() {
		return adresaSt;
	}

	public void setAdresaSt(String adresaSt) {
		this.adresaSt = adresaSt;
	}

	public String getKontaktTl() {
		return kontaktTl;
	}

	public void setKontaktTl(String kontaktTl) {
		this.kontaktTl = kontaktTl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojInd() {
		return brojInd;
	}

	public void setBrojInd(String brojInd) {
		this.brojInd = brojInd;
	}

	public int getGodUp() {
		return godUp;
	}

	public void setGodUp(int godUp) {
		this.godUp = godUp;
	}

	public String getGodSt() {
		return godSt;
	}

	public void setGodSt(String godSt) {
		this.godSt = godSt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	public ArrayList<Ocena> getPolozeniIsp() {
		return polozeniIsp;
	}

	public void setPolozeniIsp(ArrayList<Ocena> polozeniIsp) {
		this.polozeniIsp = polozeniIsp;
	}

	public ArrayList<Ocena> getNepolozeniIsp() {
		return nepolozeniIsp;
	}

	public void setNepolozeniIsp(ArrayList<Ocena> nepolozeniIsp) {
		this.nepolozeniIsp = nepolozeniIsp;
	}

}
