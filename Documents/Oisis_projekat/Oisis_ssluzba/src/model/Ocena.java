package model;

public class Ocena {
	
	private Student studentPl;
	private Predmet predmet;
    private int ocenaVr;
    private String datumPl;
	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ocena(Student studentPl, Predmet predmet, int ocenaVr, String datumPl) {
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
	public String getDatumPl() {
		return datumPl;
	}
	public void setDatumPl(String datumPl) {
		this.datumPl = datumPl;
	}
    
    
	
}
