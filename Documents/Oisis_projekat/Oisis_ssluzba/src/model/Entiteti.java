package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class Entiteti {
	
	private static Entiteti instance = null;

	public static Entiteti getInstance() {
		if (instance == null) {
			instance = new Entiteti();
		}
		return instance;
	}
	
	List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
	ArrayList<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
	List<Student> studenti = BazaStudenata.getInstance().getStudenti();
	
	private Entiteti() {}
	
	public void serializeToXML() throws IOException {
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
	
}
