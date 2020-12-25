package model;

public class Predmet {
	
	
	private String sifraP;
	public String getSifraP() {
		return sifraP;
	}
	public void setSifraP(String sifraP) {
		this.sifraP = sifraP;
	}
	public String getImeP() {
		return imeP;
	}
	public void setImeP(String imeP) {
		this.imeP = imeP;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodinaS() {
		return godinaS;
	}
	public void setGodinaS(int godinaS) {
		this.godinaS = godinaS;
	}
	public Profesor getPredProf() {
		return predProf;
	}
	public void setPredProf(Profesor predProf) {
		this.predProf = predProf;
	}
	public int getBrojESPB() {
		return brojESPB;
	}
	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}
	private String imeP;
	private int semestar;
	private int godinaS;
	private Profesor predProf;
	private int brojESPB;
	//private ArrayList<Student> studentiP;
	//private ArrayList<Student> studentiNP;
}
