/*REFERENCA: VEZBE 6, Igrac klasa*/
package model;

import java.util.Date;
/**
 * This class implements constructors, getters and setters for grade entity.
 * @author Dusan Lekic
 *
 */
public class Ocena {
	
	private Student studentPl;
	private Predmet predmet;
    private int ocenaVr;
    private Date datumPl;
	/**
	 * Default constructor without parameters.
	 */
    public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}
    /**
     * Constructor with parameters.
     * @param studentPl student which the grade is given to
     * @param predmet subject of the grade
     * @param ocenaVr value of the grade 
     * @param datumPl date when the grade was given
     */
	public Ocena(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
		super();
		this.studentPl = studentPl;
		this.predmet = predmet;
		this.ocenaVr = ocenaVr;
		this.datumPl = datumPl;
	}
	
	/**
	 * Constructor with parameters.
	 * @param brojInd index number of the student which the grade is given to
	 * @param sifraP code of the subject of the grade
	 * @param ocenaVr value of the grade 
	 * @param datumPl date when the grade was given
	 */
	public Ocena(String brojInd, String sifraP, int ocenaVr, Date datumPl) {
		super();
		this.studentPl.setBrojInd(brojInd);;
		this.predmet.setSifraP(sifraP);
		this.ocenaVr = ocenaVr;
		this.datumPl = datumPl;
	}
	/**
	 * This method returns the student which the grade is given to.
	 * @return student
	 */
	public Student getStudentPl() {
		return studentPl;
	}
	/**
	 * This method sets the student which the the grade is given to.
	 * @param studentPl student which is set
	 */
	public void setStudentPl(Student studentPl) {
		this.studentPl = studentPl;
	}
	/**
	 * This method returns the subject of the grade
	 * @return subject of the grade
	 */
	public Predmet getPredmet() {
		return predmet;
	}
	/**
	 * This method sets the subject of the grade
	 * @param predmet subject of the grade
	 */
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	/**
	 * This method returns the value of the grade.
	 * @return value of the grade
	 */
	public int getOcenaVr() {
		return ocenaVr;
	}
	/**
	 * This method sets the value of the grade.
	 * @param ocenaVr value which is set
	 */
	public void setOcenaVr(int ocenaVr) {
		this.ocenaVr = ocenaVr;
	}
	/**
	 * This method returns the date when the grade was given.
	 * @return date when the grade was given.
	 */
	public Date getDatumPl() {
		return datumPl;
	}
	/**
	 * This method sets the date when the grade was given.
	 * @param datumPl date which is set
	 */
	public void setDatumPl(Date datumPl) {
		this.datumPl = datumPl;
	}
    
    
	
}
