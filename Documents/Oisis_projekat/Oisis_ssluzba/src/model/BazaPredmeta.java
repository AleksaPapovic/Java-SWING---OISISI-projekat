package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;

	private BazaPredmeta() {

		this.predmeti = new ArrayList<Predmet>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

		this.predmeti.add(new Predmet("ktet", "Osnovi elektrotehnike", 9, 1, "letnji"));
	}

	public List<Predmet> getPredmeti() {
		return this.predmeti;
	}

	public void setOPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraP();
		case 1:
			return predmet.getImeP();
		case 2:
			return predmet.getBrojESPB();
		case 3:
			return predmet.getGodinaS();
		case 4:
			return predmet.getSemestar();
		default:
			return null;
		}
	}

	public void dodajPredmet() {

	}
}
