package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.StudentController;

public class StudentTextFields extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipPolja {
		Ime, Prezime, DatumR, AdresaS, BrojTel, Email, BrojInd, GodUp
	};

	private JTextField polje;
	private TipPolja tip;
	private String sablon;

	public String getSablon() {
		return sablon;
	}

	public StudentTextFields(TipPolja tipPolja, String sablonPolja) {
		polje = this;
		this.tip = tipPolja;
		this.sablon = sablonPolja;
		this.setText(sablonPolja);
		this.setForeground(new Color(200, 200, 200));

		this.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent fe) {
				// TODO Auto-generated method stub
				if (!proveraPolja() || polje.getText().trim().equals(sablonPolja)
						|| polje.getText().trim().isEmpty() == true) {
					if (!polje.getText().trim().equals(sablonPolja) && !polje.getText().trim().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Unesite u formatu " + sablonPolja, "Greška",
								JOptionPane.ERROR_MESSAGE);
					}
					polje.setForeground(new Color(200, 200, 200));
					polje.setText(sablonPolja);
				}

			}

			@Override
			public void focusGained(FocusEvent fe) {
				// TODO Auto-generated method stub
				polje.setForeground(Color.BLACK);
				if (polje.getText().trim().equals(sablonPolja)) {
					polje.setText("");
				}
			}
		});
	}

	public boolean proveraPolja() {
		switch (tip) {
		case Ime:
			return StudentController.getInstance().proveriIme(polje.getText().trim());
		case Prezime:
			return StudentController.getInstance().proveriIme(polje.getText().trim());
		case DatumR:
			return StudentController.getInstance().proveriDatumR(polje.getText().trim());
		case AdresaS:
			return StudentController.getInstance().proveriAdresuSt(polje.getText().trim());
		case BrojTel:
			return StudentController.getInstance().proveriKontaktTl(polje.getText().trim());
		case Email:
			return StudentController.getInstance().proveriEmail(polje.getText().trim());
		case BrojInd:
			return StudentController.getInstance().proveriBrojInd(polje.getText().trim());
		case GodUp:
			return StudentController.getInstance().proveriGodUp(polje.getText().trim());
		default:
			return false;
		}
	}
}