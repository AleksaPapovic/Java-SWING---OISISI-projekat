/*REFERENCA: VEZBE 6, Igrac klasa*/
package model;

import java.util.ArrayList;
/**
 * This class implements constructors, getters and setters for subject entity.
 * 
 * @author Aleksa Papovic
 *
 */
public class Predmet {

	private String sifraP;
	private String imeP;
	private String semestar;
	private int godinaS;
	private Profesor predProf;
	private int brojESPB;
	private ArrayList<Student> studentiP;
	private ArrayList<Student> studentiNP;
	/**
	 * Default constructor without parameters.
	 */
	public Predmet() {
	}
	public Predmet(String sifraP, String imeP, int brojESPB, int godinaS, String semestar, Profesor predProf) {
		super();
		this.sifraP = sifraP;
		this.imeP = imeP;
		this.semestar = semestar;
		this.godinaS = godinaS;
		this.predProf = predProf;
		this.brojESPB = brojESPB;
		this.studentiP = new ArrayList<Student>();
		this.studentiNP = new ArrayList<Student>();
	}
	public Predmet(String sifraP, String imeP,int godinaS,int brojESPB,Profesor predProf,String semestar) {
		super();
		this.sifraP = sifraP;
		this.imeP = imeP;
		this.semestar = semestar;
		this.godinaS = godinaS;
		this.predProf = predProf;
		this.brojESPB = brojESPB;
		this.studentiP = new ArrayList<Student>();
		this.studentiNP = new ArrayList<Student>();
	}

	public Predmet(String sifraP, String imeP, int brojESPB, int godinaS, String semestar) {
		super();
		this.sifraP = sifraP;
		this.imeP = imeP;
		this.semestar = semestar;
		this.godinaS = godinaS;
		this.brojESPB = brojESPB;
		this.studentiP = new ArrayList<Student>();
		this.studentiNP = new ArrayList<Student>();
	}

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

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
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

	public ArrayList<Student> getStudentiP() {
		return studentiP;
	}

	public void setStudentiP(ArrayList<Student> studentiP) {
		this.studentiP = studentiP;
	}

	public ArrayList<Student> getStudentiNP() {
		return studentiNP;
	}

	public void setStudentiNP(ArrayList<Student> studentiNP) {
		this.studentiNP = studentiNP;
	}

}
