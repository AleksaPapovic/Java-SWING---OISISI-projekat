/*REFERENCA: VEZBE 6, IgraciController klasa*/ 
package controller;

import java.util.Date;

import javax.swing.JOptionPane;

import gui.DodavanjeStudentaDialog;
import gui.MainFrame;
import gui.TabsPanel;
import model.BazaStudenata;
import model.Student;
import model.Student.Status;

public class StudentController {

	public static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	private StudentController() {

	}

	public boolean dodajStudenta() {
		Student st = new Student();

		if (DodavanjeStudentaDialog.imeField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.prezimeField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.datumRField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.adresaSField.getText().isEmpty()
				|| DodavanjeStudentaDialog.brojTField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.emailField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.brIndField.getText().trim().isEmpty()
				|| DodavanjeStudentaDialog.godUpField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate uneti sve podatke");
			return false;
		}

		for (Student s : BazaStudenata.getInstance().getStudenti()) {
			if (s.getBrojInd().equals(DodavanjeStudentaDialog.brIndField.getText())) {
				JOptionPane.showMessageDialog(null, "Student za zadatim indeksom vec postoji.", "GRESKA",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		st.setIme(DodavanjeStudentaDialog.imeField.getText());
		st.setPrezime(DodavanjeStudentaDialog.prezimeField.getText());
		
		Date datumr = BazaStudenata.parseDate(DodavanjeStudentaDialog.datumRField.getText());
		if (datumr == null) {
			JOptionPane.showMessageDialog(null, "Nevalidan datum", "GRESKA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		st.setDatumR(datumr);
		
		st.setAdresaSt(DodavanjeStudentaDialog.adresaSField.getText());
		st.setKontaktTl(DodavanjeStudentaDialog.brojTField.getText());
		
		String email=DodavanjeStudentaDialog.emailField.getText();
		
		if (!email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+")) {
			JOptionPane.showMessageDialog(null, "Nevalidna email adresa", "GRESKA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		st.setEmail(DodavanjeStudentaDialog.emailField.getText());
		st.setBrojInd(DodavanjeStudentaDialog.brIndField.getText());
		
		String godUp= DodavanjeStudentaDialog.godUpField.getText();
		
		if (!godUp.matches("[1-2][0-9]{3,}")) {
			JOptionPane.showMessageDialog(null, "Nevalidna godina upisa", "GRESKA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		st.setGodUp(Integer.parseInt(godUp));
		
	    switch (DodavanjeStudentaDialog.godStComboBox.getSelectedItem().toString()) {
		case "I(prva)":
			st.setGodSt("1");
			break;
		case "II(druga)":
			st.setGodSt("2");
			break;

		case "III(treca)":
			st.setGodSt("3");
			break;

		case "IV(cetvrta)":
			st.setGodSt("4");
			break;
	
		default:
			break;
		}
		
		Status status=null;

		switch (DodavanjeStudentaDialog.nacinFComboBox.getSelectedItem().toString()) {
		case "Budzet":
			status = Status.B;
			break;
		case "Samofinansiranje":
			status = Status.S;
			break;

		default:
			break;
		}		
		
		st.setStatus(status);
		
		BazaStudenata.getInstance().dodajStudenata(st.getIme(), st.getPrezime(), st.getDatumR(), st.getAdresaSt(),
				st.getKontaktTl(), st.getEmail(), st.getBrojInd(), st.getGodUp(), st.getGodSt(), st.getStatus(), 0);
		TabsPanel.tableStudent.update();
		return true;
	}

}