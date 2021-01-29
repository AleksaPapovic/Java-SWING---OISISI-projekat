package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PredmetController;
import controller.PredmetDocumentListener;
import view.PredmetTextFields.TipPolja;

/**
 * This class implements a dialog which is used for adding a new subject to the
 * model.
 * 
 * @author Dusan Lekic
 *
 */
public class DodavanjePredmetaDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871252857743880797L;
	/**
	 * This is static text field for the code
	 */
	public static PredmetTextFields sifraField;
	/**
	 * This is static text field for the name
	 */
	public static PredmetTextFields imeField;
	/**
	 * This is static text field for the semester
	 */
	public static JComboBox<String> semestarComboBox;
	/**
	 * This is static combobox for the year
	 */
	public static JComboBox<String> godinaComboBox;
	/**
	 * This is static text field for the ESPB
	 */
	public static PredmetTextFields espbField;
	public JButton odustani;
	/**
	 * This is static button for the confirmation
	 */
	public static JButton prihvati;

	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and components are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public DodavanjePredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setSize(450, 550);
		setLocationRelativeTo(parent);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension velicina = new Dimension(100, 30);

		JLabel sifraLabela = new JLabel("Sifra*");
		sifraLabela.setPreferredSize(velicina);
		sifraLabela.setMaximumSize(velicina);
		sifraField = new PredmetTextFields(TipPolja.Sifra, "Sifra predmeta");

		JLabel imeLabela = new JLabel("Naziv*");
		imeLabela.setPreferredSize(velicina);
		imeLabela.setMaximumSize(velicina);
		imeField = new PredmetTextFields(TipPolja.Ime, "Naziv predmeta");

		JLabel godLabela = new JLabel("Godina*");
		godLabela.setPreferredSize(velicina);
		godLabela.setMaximumSize(velicina);
		String god[] = { "I(prva)", "II(druga)", "II(treca)", "IV(cetvrta)" };
		godinaComboBox = new JComboBox<String>(god);

		JLabel semestarLabela = new JLabel("Semestar*");
		semestarLabela.setPreferredSize(velicina);
		semestarLabela.setMaximumSize(velicina);
		String semestar[] = { "zimski", "letnji" };
		semestarComboBox = new JComboBox<String>(semestar);

		JLabel espbLabela = new JLabel("ESPB*");
		espbLabela.setPreferredSize(velicina);
		espbLabela.setMaximumSize(velicina);
		espbField = new PredmetTextFields(TipPolja.ESPB, "Broj ESPB poena");

		prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(velicina);
		prihvati.setEnabled(false);
		odustani = new JButton("Odustani");
		odustani.setPreferredSize(velicina);

		PredmetDocumentListener textChangeDocumentListener = new PredmetDocumentListener();

		DodavanjePredmetaDialog.sifraField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjePredmetaDialog.imeField.getDocument().addDocumentListener(textChangeDocumentListener);
		DodavanjePredmetaDialog.espbField.getDocument().addDocumentListener(textChangeDocumentListener);
		
		/**
		 * This action listener specifies the action for the 'prihvati' button.
		 */
		prihvati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (PredmetController.getInstance().dodajPredmet())
					dispose();

			}

		});
		
		/**
		 * This action listener specifies the action for the 'odustani' button.
		 */
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		add(panel);

		panel.add(textPanel, BorderLayout.NORTH);
		panel.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(sifraLabela);
		textPanel.add(sifraField);
		textPanel.add(imeLabela);
		textPanel.add(imeField);
		textPanel.add(espbLabela);
		textPanel.add(espbField);
		textPanel.add(godLabela);
		textPanel.add(godinaComboBox);
		textPanel.add(semestarLabela);
		textPanel.add(semestarComboBox);

		buttonsPanel.add(prihvati);
		buttonsPanel.add(odustani);

		setVisible(true);
	}
}