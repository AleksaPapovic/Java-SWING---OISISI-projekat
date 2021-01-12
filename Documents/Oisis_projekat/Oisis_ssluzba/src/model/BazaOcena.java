package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaOcena {

	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}

	private ArrayList<Ocena> Ocene;
	private ArrayList<String> kolone;

	private BazaOcena() {
		
		this.Ocene = new ArrayList<Ocena>();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
		
		
		//Ocene.add(new Ocena("MA2", "Matematicka Analiza 2", 9 ,parseDate("20.01.2000.")));
	}


	public List<Ocena> getOcene() {
		return Ocene;
	}

	public void setOcene(ArrayList<Ocena> Ocene) {
		this.Ocene = Ocene;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Ocena getRow(int rowIndex) {
		return this.Ocene.get(rowIndex);
	}

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

	public void dodajOcenu(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
		this.Ocene.add(new Ocena(studentPl, predmet, ocenaVr, datumPl));
	}

	public void izbrisiOcenu(String sifraP) {
		/*for (Ocena i : Ocene) {
			if (i.getPredmet().getSifraP() == sifraP) {
				Ocene.remove(i);
				break;
			}
		}*/
	}

	public void izmeniOcenu(Student studentPl, Predmet predmet, int ocenaVr, Date datumPl) {
	/*	for (Ocena i : Ocene) {
			if (i.getPredmet().getSifraP() == predmet.getSifraP()) {
				i.setPredmet(predmet);
				i.setOcenaVr(ocenaVr);
				i.setDatumPl(datumPl);;
			}
		}*/
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
