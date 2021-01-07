package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ProfesorController;

public class FocusField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipPolja {
		Ime, Prezime, DatumR, AdresaS, BrojTel, Email, AdresaK, BrojLK
	};

	private JTextField polje;
	private TipPolja tip;
	private String sablon;

	public String getSablon() {
		return sablon;
	}

	public FocusField(TipPolja tipPolja, String sablonPolja) {
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
			return ProfesorController.getInstance().proveriImeP(polje.getText().trim());
		case Prezime:
			return ProfesorController.getInstance().proveriImeP(polje.getText().trim());
		case DatumR:
			return ProfesorController.getInstance().proveriDatumR(polje.getText().trim());
		case AdresaS:
			return ProfesorController.getInstance().proveriAdresuSK(polje.getText().trim());
		case BrojTel:
			return ProfesorController.getInstance().proveriBrojTel(polje.getText().trim());
		case Email:
			return ProfesorController.getInstance().proveriEmail(polje.getText().trim());
		case AdresaK:
			return ProfesorController.getInstance().proveriAdresuSK(polje.getText().trim());
		case BrojLK:
			return ProfesorController.getInstance().proveriBrojLK(polje.getText().trim());
		default:
			return false;
		}
	}
}
