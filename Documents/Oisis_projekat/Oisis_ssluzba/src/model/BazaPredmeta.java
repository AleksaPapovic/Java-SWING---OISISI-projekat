package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.MenuToolbar;
import view.TabsPanel;

/**
 * This class serves as a database for a subject and implements methods for its
 * modification.
 * 
 * @author Aleksa Papovic
 *
 */
public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	/**
	 * This method implements the instance as a singleton(it can only be instanced
	 * once).
	 * 
	 * @return the given instance
	 */
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

	/**
	 * Default constructor which initializes the columns.
	 */
	private BazaPredmeta() {

		this.predmeti = new ArrayList<Predmet>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

//		this.predmeti.add(new Predmet("ktet", "Osnovi elektrotehnike", 9, 1, "letnji"));
//		this.predmeti.add(new Predmet("ra", "Osnovi elektrotehnike", 9, 1, "letnji"));
//		this.predmetiSvi = this.predmeti;
		this.predmeti = Entiteti.getInstance().getPredmeti();
		// initPredmeta();
		this.predmetiSvi = this.predmeti;
	}

	/**
	 * This metod used to initialize subjects.
	 */
	public void initPredmeta() {
		this.predmeti.add(new Predmet("p1", "osnove programiranja", 1, 7, null, "zimski"));
		this.predmeti.add(new Predmet("p2", "statistika", 3, 8, null, "letnji"));
		this.predmeti.add(new Predmet("p3", "algoritmi i strukture podataka", 2, 9, null, "letnji"));
		this.predmeti.add(new Predmet("p4", "LPRS", 3, 7, null, "zimski"));
		this.predmeti.add(new Predmet("p5", "matematika", 1, 11, null, "letnji"));
		this.predmeti.add(new Predmet("p6", "xml i web servisi", 4, 6, null, "letnji"));
		this.predmeti.add(new Predmet("p7", "Metode optimizacije", 3, 6, null, "zimski"));
		this.predmeti.add(new Predmet("p8", "osnove elektortehnike", 1, 11, null, "letnji"));
		this.predmeti.add(new Predmet("p9", "Sociologija", 1, 10, null, "zimski"));
		this.predmeti.add(new Predmet("p10", "Filozofija", 1, 4, null, "zimski"));
		this.predmeti.add(new Predmet("p11", "ORT", 2, 7, null, "letnji"));
		this.predmeti.add(new Predmet("p12", "NANS", 2, 5, null, "letnji"));
		this.predmeti.add(new Predmet("p13", "Organizacija podataka", 2, 7, null, "zimski"));
		this.predmeti.add(new Predmet("p14", "Baze podataka", 2, 6, null, "zimski"));
		this.predmeti.add(new Predmet("p15", "paralelno programiranje", 2, 8, null, "zimski"));
		this.predmeti.add(new Predmet("p16", "konkurentno programiranje", 2, 9, null, "letnji"));
		this.predmeti.add(new Predmet("p17", "Operativni sistemi", 2, 8, null, "letnji"));
		this.predmeti.add(new Predmet("p18", "Algebra", 1, 15, null, "zimski"));
		this.predmeti.add(new Predmet("p19", "Verovatnoca", 3, 14, null, "letnji"));
		this.predmeti.add(new Predmet("ps20", "Upravljacki sistemi", 3, 8, null, "letnji"));
		this.predmeti.add(new Predmet("ps21", "Osnovi elektronike", 2, 7, null, "zimski"));
		this.predmeti.add(new Predmet("ps22", "Slucajni procesi", 4, 9, null, "letnji"));
		this.predmeti.add(new Predmet("ps23", "Racunarstvo visokih performansi", 4, 10, null, "letnji"));
		this.predmeti.add(new Predmet("p24", "Analiza 1", 1, 20, null, "zimski"));
		this.predmeti.add(new Predmet("it25", "Informaciona bezbednost", 4, 9, null, "letnji"));
		this.predmeti.add(new Predmet("it26", "Elektronsko placanje", 3, 8, null, "zimski"));
		this.predmeti.add(new Predmet("it27", "Distribuirani sistemi", 4, 6, null, "zimski"));
		this.predmeti.add(new Predmet("p28", "Projektovanje softvera", 3, 5, null, "zimski"));
		this.predmeti.add(new Predmet("p29", "Informacioni sistemi", 4, 6, null, "zimski"));
		this.predmeti.add(new Predmet("p30", "Masinsko ucenje", 4, 7, null, "letnji"));

	}

	/**
	 * This method returns the subjects.
	 * 
	 * @return the subjects
	 */
	public ArrayList<Predmet> getPredmeti() {
		return this.predmeti;
	}

	/**
	 * This method returns all the subjects.
	 * 
	 * @return all the subjects
	 */
	public ArrayList<Predmet> getPredmetiSvi() {
		return this.predmetiSvi;
	}

	/**
	 * This method sets all the subjects.
	 * 
	 * @param predmeti all the subjects
	 */

	public void setOPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
		this.predmetiSvi = this.predmeti;
	}

	/**
	 * Returns the number of the columns of the database(number of the entity
	 * characteristics).
	 * 
	 * @return number of columns
	 */
	public int getColumnCount() {
		return 5;
	}

	/**
	 * This method returns the name of a column
	 * 
	 * @param index index of the column
	 * @return name of the column
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * This method returns the selected subject.
	 * 
	 * @param rowIndex index of the subject
	 * @return the subject with the selected index
	 */
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	/**
	 * Returns the value of the database at the selected row and column.
	 * 
	 * @param row    index of the grade
	 * @param column field of a grade
	 * @return the data at the given row and column or null if the params are out of
	 *         bounds
	 */
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

	/**
	 * This method adds a subject to the database.
	 * 
	 * @param sifraP   code of the subject
	 * @param imeP     name of the subject
	 * @param semestar semester of the subject
	 * @param brojESPB number of ESPB for the subject
	 * @param godinaS  year of study of the subject
	 */
	public void dodajPredmet(String sifraP, String imeP, int brojESPB, int godinaS, String semestar) {
		if (pretraga) {
			this.predmetiSvi.add(new Predmet(sifraP, imeP, brojESPB, godinaS, semestar));
			pretraziPredmete(MenuToolbar.searchbar.getText());
		} else {
			this.predmeti.add(new Predmet(sifraP, imeP, brojESPB, godinaS, semestar));
		}
	}

	/**
	 * This method deletes the subject with the selected index.
	 * 
	 * @param index_predmeta selected index of the subject which we want to delete
	 */
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

	/**
	 * This method find the subject with the selected code.
	 * 
	 * @param sifraP the selected ID number
	 * @return subject if exists with that ID number
	 */
	public Predmet nadjiPredmet(String sifraP) {
		for (Predmet p : this.predmeti) {
			if (p.getSifraP().equals(sifraP)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * This method returns the subject with the given index.
	 * 
	 * @param red selected index
	 * @return the subject with the given index
	 */
	public Predmet getSelectedPredmet(int red) {
		return this.predmeti.get(red);
	}

	/**
	 * This method changes the info of the subject with the given index.
	 * 
	 * @param index    index of the professor which we want to change
	 * @param sifraP   code of the subject
	 * @param imeP     name of the subject
	 * @param semestar semester of the subject
	 * @param brojESPB number of ESPB for the subject
	 * @param godinaS  year of study of the subject
	 */
	public void izmeniPredmet(int index, String sifraP, String imeP, int brojESPB, int godinaS, String semestar) {
		predmeti.get(index).setSifraP(sifraP);
		predmeti.get(index).setImeP(imeP);
		predmeti.get(index).setBrojESPB(brojESPB);
		predmeti.get(index).setGodinaS(godinaS);
	}

	/**
	 * This method implements the action of searching trough a list of subjects with
	 * a key word.
	 * 
	 * @param text key word which subject contains
	 */
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

	/**
	 * This method adds professor to the subject
	 * 
	 * @param predmet  selected subject
	 * @param profesor selected professor
	 */
	public void dodajProfesoraPredmetu(Predmet predmet, Profesor profesor) {
		predmet.setPredProf(profesor);
	}
}
