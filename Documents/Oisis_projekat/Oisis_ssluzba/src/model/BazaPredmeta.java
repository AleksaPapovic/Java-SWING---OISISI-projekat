package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import view.MenuToolbar;
import view.TabsPanel;

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
	private ArrayList<Predmet> predmetiSvi;
	private boolean pretraga = false;

	private BazaPredmeta() {

		this.predmeti = new ArrayList<Predmet>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

		this.predmeti.add(new Predmet("ktet", "Osnovi elektrotehnike", 9, 1, "letnji"));
		this.predmeti.add(new Predmet("ra", "Osnovi elektrotehnike", 9, 1, "letnji"));
		this.predmetiSvi = this.predmeti;
	}

	public List<Predmet> getPredmeti() {
		return this.predmeti;
	}

	public List<Predmet> getPredmetiSvi() {
		return this.predmetiSvi;
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

	public void dodajPredmet(String sifraP, String imeP, int brojESPB, int godinaS, String semestar) {
		if (pretraga) {
			this.predmetiSvi.add(new Predmet(sifraP, imeP, brojESPB, godinaS, semestar));
			pretraziPredmete(MenuToolbar.searchbar.getText());
		} else {
			this.predmeti.add(new Predmet(sifraP, imeP, brojESPB, godinaS, semestar));
		}
	}

	public void izbrisiPredmet(int index_predmeta) {
		int i = 0;
		Predmet obrisaniPredmet = this.predmeti.get(index_predmeta);

		BazaProfesora.getInstance().izbrisiPredmet(obrisaniPredmet);
		BazaStudenata.getInstance().izbrisiPredmet(obrisaniPredmet);

		for (Predmet p : this.predmetiSvi) {
			if (p.getSifraP().equals(this.predmeti.get(index_predmeta).getSifraP())) {
				this.predmetiSvi.remove(i);
				break;
			}
			i++;
		}
		
		if (pretraga) {
			pretraziPredmete(MenuToolbar.searchbar.getText());
		}
		TabsPanel.tablePredmet.azuriranjeTabelePredmet();
		TabsPanel.tableProfesor.azuriranjeTabeleProfesor();
		TabsPanel.tableStudent.update();
	}

	public Predmet nadjiPredmet(String sifraP) {
		for (Predmet p : this.predmeti) {
			if (p.getSifraP().equals(sifraP)) {
				return p;
			}
		}
		return null;
	}

	public Predmet getSelectedPredmet(int red) {
		return this.predmeti.get(red);
	}

	public void izmeniPredmet(int index, String sifraP, String imeP, int brojESPB, int godinaS, String semestar) {
		predmeti.get(index).setSifraP(sifraP);
		predmeti.get(index).setImeP(imeP);
		predmeti.get(index).setBrojESPB(brojESPB);
		predmeti.get(index).setGodinaS(godinaS);
	}

	public void pretraziPredmete(String text) {
		ArrayList<Predmet> predmetiPronadjeni = new ArrayList<Predmet>();
		this.predmeti = this.predmetiSvi;
		int i = 0;
		int k = 0;

		String[] podeli = text.trim().split(" ");
		String[] trag = new String[3];

		for (String s : podeli) {
			String pom = s.trim();
			trag[i] = pom;
			i++;
		}
		if (trag[0].equals("ime") && trag[1].equals("prezime")) {
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage mora biti:  Prezime Ime ", "GREŠKA",
					JOptionPane.ERROR_MESSAGE);

		} else {
			for (Predmet p : this.predmeti) {
				if (p.getSifraP().contains(trag[0]) && k < 2) {
					predmetiPronadjeni.add(p);
				}
			}
		}

		if (text.isEmpty()) {
			this.predmeti = this.predmetiSvi;
			pretraga = false;
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage mora biti:  Prezime Ime", "Neuspešna pretraga",
					JOptionPane.ERROR_MESSAGE);
		} else {
			pretraga = true;
			this.predmeti = predmetiPronadjeni;
		}

	}
}
