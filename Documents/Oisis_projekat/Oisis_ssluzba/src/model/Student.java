package model;

import java.util.ArrayList;

public class Student {

	public enum Status {
		B, S
	};

	private String prezime;
	private String ime;
	private String datumR;
	private String adresaSt;
	private String kontaktTl;
	private String email;
	private String brojInd;
	private int godUP;
	private String godSt;
	private Status status;
	private double prosek;
	private ArrayList<Integer> polozeni;
	private ArrayList<Integer> nepolozeni;
	// treba da budu Student liste

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String prezime, String ime, String datumR, String adresaSt, String kontaktTl, String email,
			String brojInd, int godUP, String godSt, Status status, double prosek, ArrayList<Integer> polozeni,
			ArrayList<Integer> nepolozeni) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumR = datumR;
		this.adresaSt = adresaSt;
		this.kontaktTl = kontaktTl;
		this.email = email;
		this.brojInd = brojInd;
		this.godUP = godUP;
		this.godSt = godSt;
		this.status = status;
		this.prosek = prosek;
		this.polozeni = polozeni;
		this.nepolozeni = nepolozeni;
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

	public String getDatumR() {
		return datumR;
	}

	public void setDatumR(String datumR) {
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

	public int getGodUP() {
		return godUP;
	}

	public void setGodUP(int godUP) {
		this.godUP = godUP;
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

	public ArrayList<Integer> getPolozeni() {
		return polozeni;
	}

	public void setPolozeni(ArrayList<Integer> polozeni) {
		this.polozeni = polozeni;
	}

	public ArrayList<Integer> getNepolozeni() {
		return nepolozeni;
	}

	public void setNepolozeni(ArrayList<Integer> nepolozeni) {
		this.nepolozeni = nepolozeni;
	}

}
