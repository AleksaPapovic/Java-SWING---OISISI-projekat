package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Entiteti {
	
	@Override
	public String toString() {
		return "Entiteti [predmeti=" + predmeti + ", profesori=" + profesori + ", studenti=" + studenti + "]";
	}

	private static Entiteti instance = null;

	public static Entiteti getInstance() {
		if (instance == null) {
			instance = new Entiteti();
		}
		return instance;
	}
	
	ArrayList<Predmet> predmeti ;
	ArrayList<Profesor> profesori ;
	ArrayList<Student> studenti ;
	
	private Entiteti() {}
	
	public void serializeToXML() throws IOException {
		
		 this.predmeti = BazaPredmeta.getInstance().getPredmetiSvi();
		 this.profesori = BazaProfesora.getInstance().getProfesoriSvi();
		 this.studenti = BazaStudenata.getInstance().getStudentiSvi();
		
		File f = new File("data" + File.separator + "entiteti.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {
			XStream xs = new XStream();
			xs.registerConverter(new DateConverter(TimeZone.getDefault()));
			xs.alias("Entiteti", Entiteti.class);
			xs.alias("Predmet", Predmet.class);
			xs.alias("Profesor", Profesor.class);
			xs.alias("Student", Student.class);
			xs.toXML(this, os);
		} finally {
			os.close();
		}
	}
	
	public void deserializeToXML() throws IOException {
		File f = new File("data" + File.separator + "entiteti.xml");
			XStream xsd = new XStream();
			XStream.setupDefaultSecurity(xsd);
			xsd.addPermission(AnyTypePermission.ANY);
			xsd.alias("Entiteti", Entiteti.class);
			xsd.alias("Predmet", Predmet.class);
			xsd.alias("Profesor", Profesor.class);
			xsd.alias("Student", Student.class);
		
			Entiteti e = (Entiteti) xsd.fromXML(new FileInputStream(f));
		  
		    
	     //   BazaProfesora.getInstance().setProfesori(e.profesori);
		
         //	BazaPredmeta.getInstance().setOPredmeti(e.predmeti);
		    
		  //  BazaStudenata.getInstance().setStudenti(e.studenti);
		    
			this.profesori = e.profesori;
			this.predmeti = e.predmeti;
		    this.studenti = e.studenti;
		    //test deserijalizacija
			File f1 = new File("data" + File.separator + "deserijalizovani.xml");
			OutputStream os = new BufferedOutputStream(new FileOutputStream(f1));
			try {
				XStream xs = new XStream();
				xs.registerConverter(new DateConverter(TimeZone.getDefault()));
				xs.alias("Entiteti", Entiteti.class);
				xs.alias("Predmet", Predmet.class);
				xs.alias("Profesor", Profesor.class);
				xs.alias("Student", Student.class);
				xs.toXML(e, os);
			} finally {
				os.close();
			}
		    
		    
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
}
