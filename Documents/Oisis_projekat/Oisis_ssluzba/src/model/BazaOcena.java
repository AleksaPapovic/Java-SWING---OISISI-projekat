package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class serves as a database for a grade and implements methods for its modification.
 * @author Dusan Lekic
 *
 */
public class BazaOcena {

	private static BazaOcena instance = null;
	
	/**
	 * This method implements the instance as a singleton(it can only be instanced
	 * once).
	 * 
	 * @return the given instance
	 */
	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}

	private ArrayList<Ocena> Ocene;
	private ArrayList<String> kolone;
	
	/**
	 * Default constructor which initializes the columns and the data of the database.
	 */
	private BazaOcena() {
		
		this.Ocene = new ArrayList<Ocena>();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
		
		
		Ocene.add(new Ocena("RA 134/2015","p5",10,parseDate("12.12.2017.")));
		Ocene.add(new Ocena("RA 134/2015","p3",9,parseDate("10.11.2019.")));
		Ocene.add(new Ocena("RA 134/2015","p1",8,parseDate("11.11.2020.")));
		Ocene.add(new Ocena("RA 3/2019","p1",10,parseDate("20.11.2020.")));
		Ocene.add(new Ocena("RA 3/2019","p5",10,parseDate("30.10.2020.")));
		Ocene.add(new Ocena("RA 11/2018","p15",9,parseDate("10.01.2021.")));
		Ocene.add(new Ocena("RA 12/2018","p15",10,parseDate("12.01.2018.")));
		Ocene.add(new Ocena("RA 11/2018","p16",10,parseDate("01.01.2021.")));
		Ocene.add(new Ocena("RA 12/2018","p16",8,parseDate("04.02.2019.")));
	}
	
	/**
	 * This method returns the grades of a student.
	 * @return the grades of a student
	 */
	public List<Ocena> getOcene() {
		return Ocene;
	}
	
	/**
	 * This method sets the grades of a student.
	 * @param Ocene the grades which are set
	 */
	public void setOcene(ArrayList<Ocena> Ocene) {
		this.Ocene = Ocene;
	}

	/**
	 * This method returns the number of columns of the database(number of the entity characteristics).
	 * @return	number of columns
	 */
	public int getColumnCount() {
		return 5;
	}
	
	/**
	 * This method returns the name of a column
	 * @param index index of the column
	 * @return	name of the column
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * This method returns the selected grade.
	 * @param rowIndex index of the grade
	 * @return the grade with the selected index
	 */
	public Ocena getRow(int rowIndex) {
		return this.Ocene.get(rowIndex);
	}
	
	/**
	 * Returns the value of the database at the selected row and column.
	 * @param row index of the grade
	 * @param column field of a grade
	 * @return the data at the given row and column or null if the params are out of bounds
	 */
	public Object getValueAt(int row, int column) {
		Ocena Ocena = this.Ocene.get(row);
		switch (column) {
		case 0:
			return Ocena.getPredmet().getSifraP();
		case 1:
			return Ocena.getPredmet().getImeP();
		case 2:
			return Ocena.getPredmet().getBrojESPB();
		case 3:
			return Ocena.getOcenaVr();
		case 4:
			return Ocena.getDatumPl();
		default:
			return null;
		}
	}
	
	/**
	 * This method adds a grade to the database.
	 * @param studentPl student to which the grade was given
	 * @param predmet subject of the grade
	 * @param ocenaVr value of the grade
	 * @param datumPl date when the grade was given
	 */
	public void dodajOcenu(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
		this.Ocene.add(new Ocena(studentPl, predmet, ocenaVr, datumPl));
	}
	
	public void izbrisiOcenu(String sifraP) {
		/*
		 * for (Ocena i : Ocene) { if (i.getPredmet().getSifraP() == sifraP) {
		 * Ocene.remove(i); break; } }
		 */
	}

	public void izmeniOcenu(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
		/*
		 * for (Ocena i : Ocene) { if (i.getPredmet().getSifraP() ==
		 * predmet.getSifraP()) { i.setPredmet(predmet); i.setOcenaVr(ocenaVr);
		 * i.setDatumPl(datumPl);; } }
		 */
	}
	
	/**
	 * This method converts the date to the wanted format.
	 * @param date the date we want to convert
	 * @return converted date or null if the action failed
	 */
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
