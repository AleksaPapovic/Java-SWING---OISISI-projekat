/*REFERENCA: VEZBE 6, Igrac klasa*/ 
package model;

import java.util.ArrayList;

public class Predmet {
	
	private String imeP;
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
	private int semestar;
	private int godinaS;
	private Profesor predProf;
	private int brojESPB;
	private ArrayList<Student> studentiP;
	private ArrayList<Student> studentiNP;
	
	
}
