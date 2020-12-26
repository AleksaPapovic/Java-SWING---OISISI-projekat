/*REFERENCA: VEZBE 6, Igrac klasa*/
package model;

import java.util.Date;

public class Ocena {
	
	private Student studentPl;
	private Predmet predmet;
    private int ocenaVr;
    private Date datumPl;
	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ocena(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
		super();
		this.studentPl = studentPl;
		this.predmet = predmet;
		this.ocenaVr = ocenaVr;
		this.datumPl = datumPl;
	}
	public Student getStudentPl() {
		return studentPl;
	}
	public void setStudentPl(Student studentPl) {
		this.studentPl = studentPl;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int getOcenaVr() {
		return ocenaVr;
	}
	public void setOcenaVr(int ocenaVr) {
		this.ocenaVr = ocenaVr;
	}
	public Date getDatumPl() {
		return datumPl;
	}
	public void setDatumPl(Date datumPl) {
		this.datumPl = datumPl;
	}
    
    
	
}
