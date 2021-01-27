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

	/**
	 * Constructor with parameters.
	 * 
	 * @param sifrap   code of the subject
	 * @param imeP     name of the subject
	 * @param semestar semester of the subject
	 * @param godinaS  year of study of the subject
	 * @param predProf the professor which teaches the subject
	 */
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

	/**
	 * 
	 * @param sifraP   code of the subject
	 * @param imeP     name of the subject
	 * @param godinaS  year of study of the subject
	 * @param brojESPB number of ESPB for the subject
	 * @param predProf the professor which teaches the subject
	 * @param semestar semester of the subject
	 */
	public Predmet(String sifraP, String imeP, int godinaS, int brojESPB, Profesor predProf, String semestar) {
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

	/**
	 * 
	 * @param sifraP   code of the subject
	 * @param imeP     name of the subject
	 * @param brojESPB number of ESPB for the subject
	 * @param godinaS  year of study of the subject
	 * @param semestar semester of the subject
	 */
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

	/**
	 * This method returns the code of the subject.
	 * 
	 * @return the code of the subject
	 */
	public String getSifraP() {
		return sifraP;
	}

	/**
	 *  This method returns the code of the subject.
	 * 
	 * @param sifraP the code of the subject
	 */
	public void setSifraP(String sifraP) {
		this.sifraP = sifraP;
	}

	/**
	 *  This method returns the name of the subject.
	 * 
	 * @return the name of the subject
	 */
	public String getImeP() {
		return imeP;
	}

	/**
	 * This method returns the name of the subject.
	 * 
	 * @param imeP the name of the subject
	 */
	public void setImeP(String imeP) {
		this.imeP = imeP;
	}

	/**
	 *  This method returns the semester of the subject.
	 * 
	 * @return the semester of the subject
	 */ 
	public String getSemestar() {
		return semestar;
	}

	/**
	 * This method sets  the semester of the subject.
	 * 
	 * @param semestar the semester of the subject
	 */
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	/**
	 * This method returns the year of study of the subject.
	 * 
	 * @return  the year of study of the subject
	 */
	public int getGodinaS() {
		return godinaS;
	}

	/**
	 *  This method sets  the year of study of the subject.
	 * 
	 * @param godinaS  the year of study of the subject
	 */
	public void setGodinaS(int godinaS) {
		this.godinaS = godinaS;
	}

	/**
	 * This method returns the professor which teaches the subject.
	 * 
	 * @return the professor which teaches the subject
	 */
	public Profesor getPredProf() {
		return predProf;
	}

	/**
	 *  This method sets the professor which teaches the subject.
	 * 
	 * @param predProf the professor which teaches the subject
	 */
	public void setPredProf(Profesor predProf) {
		this.predProf = predProf;
	}

	/**
	 * This method returns number of ESPB for the subject.
	 * 
	 * @return number of ESPB for the subject
	 */
	public int getBrojESPB() {
		return brojESPB;
	}

	/**
	 *  This method sets the number of ESPB for the subject.
	 * 
	 * @param brojESPB the number of ESPB for the subject
	 */ 
	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}

	/**
	 * This method returns list of students which are passed the subject.
	 * 
	 * @return list of students 
	 */
	public ArrayList<Student> getStudentiP() {
		return studentiP;
	}

	/**
	 *  This method sets list of students which are passed the subject.
	 * 
	 * @param studentiP list of students which are passed the subject
	 */
	public void setStudentiP(ArrayList<Student> studentiP) {
		this.studentiP = studentiP;
	}

	/**
	 * This method returns list of students which are not passed the subject.
	 * 
	 * @return list of students 
	 */
	public ArrayList<Student> getStudentiNP() {
		return studentiNP;
	}

	/**
	 * This method sets list of students which are not passed the subject.
	 * 
	 * @param studentiNP list of students which are not passed the subject
	 */
	public void setStudentiNP(ArrayList<Student> studentiNP) {
		this.studentiNP = studentiNP;
	}

}
