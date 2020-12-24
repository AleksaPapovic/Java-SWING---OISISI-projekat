package controller;

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

	public void dodajStudenta() {
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
		} else {

			st.setIme(DodavanjeStudentaDialog.imeField.getText());
			st.setPrezime(DodavanjeStudentaDialog.prezimeField.getText());
			st.setDatumR(BazaStudenata.parseDate(DodavanjeStudentaDialog.datumRField.getText()));
			st.setAdresaSt(DodavanjeStudentaDialog.adresaSField.getText());
			st.setKontaktTl(DodavanjeStudentaDialog.brojTField.getText());
			st.setEmail(DodavanjeStudentaDialog.emailField.getText());
			st.setBrojInd(DodavanjeStudentaDialog.brIndField.getText());
			st.setGodUp(Integer.parseInt(DodavanjeStudentaDialog.godUpField.getText()));
			st.setGodSt(DodavanjeStudentaDialog.godStComboBox.getSelectedItem().toString());
			Status status;

			if (DodavanjeStudentaDialog.godStComboBox.getSelectedIndex() == 0) {
				status = Status.B;
			} else {
				status = Status.S;
			}

			BazaStudenata.getInstance().dodajStudenata(st.getIme(), st.getPrezime(), st.getDatumR(), st.getAdresaSt(),
					st.getKontaktTl(), st.getEmail(), st.getBrojInd(), st.getGodUp(), st.getGodSt(), status, 0);
			TabsPanel.tableStudent.update();
		}

	}

}