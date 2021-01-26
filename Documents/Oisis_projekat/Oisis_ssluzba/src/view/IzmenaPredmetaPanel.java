package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.IzmenaPredmetaDocumentListener;
import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;
import view.PredmetTextFields.TipPolja;
/**
 * This class implements a panel which is used for editing a selected existing subject.
 * This panel is added as a tab to the dialog for editing a subject.
 * @author Dusan Lekic
 *
 */
public class IzmenaPredmetaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2444365237246739680L;

	public static PredmetTextFields sifraIzmena;
	public static PredmetTextFields imePredIzmena;
	public static JComboBox<String> semestarIzmena;
	public static JComboBox<String> godinaIzmena;
	public static PredmetTextFields espbIzmena;
	public static JTextField profesorIzmena;
	public JButton plusIzmena;
	public static JButton minusIzmena;
	public JButton odustaniIzmena;
	public static JButton prihvatiIzmena;
	/**
	 * Constructor with parameters where the panel is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 */
	public IzmenaPredmetaPanel(JDialog parent) {

		Predmet pr = BazaPredmeta.getInstance().getRow(TabsPanel.tablePredmet.getSelectedTableRow());

		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension velicina = new Dimension(100, 30);

		JLabel sifraLabela = new JLabel("Sifra*");
		sifraLabela.setPreferredSize(velicina);
		sifraLabela.setMaximumSize(velicina);
		sifraIzmena = new PredmetTextFields(TipPolja.Sifra, "Sifra predmeta");
		sifraIzmena.setText(pr.getSifraP());

		JLabel imePredLabela = new JLabel("Ime*");
		imePredLabela.setPreferredSize(velicina);
		imePredLabela.setMaximumSize(velicina);
		imePredIzmena = new PredmetTextFields(TipPolja.Ime, "Ime predmeta");
		imePredIzmena.setText(pr.getImeP());

		JLabel godLabela = new JLabel("Godina*");
		godLabela.setPreferredSize(velicina);
		godLabela.setMaximumSize(velicina);
		String god[] = { "I(prva)", "II(druga)", "II(treca)", "IV(cetvrta)" };
		godinaIzmena = new JComboBox<String>(god);
		godinaIzmena.setSelectedItem(pr.getGodinaS());

		JLabel semestarLabela = new JLabel("Semestar*");
		semestarLabela.setPreferredSize(velicina);
		semestarLabela.setMaximumSize(velicina);
		String semestar[] = { "zimski", "letnji" };
		semestarIzmena = new JComboBox<String>(semestar);
		semestarIzmena.setSelectedItem(pr.getSemestar());

		JLabel espbLabela = new JLabel("ESPB*");
		espbLabela.setPreferredSize(velicina);
		espbLabela.setMaximumSize(velicina);
		espbIzmena = new PredmetTextFields(TipPolja.ESPB, "Broj ESPB poena");
		espbIzmena.setText(String.valueOf(pr.getBrojESPB()));

		JLabel profesorLabela = new JLabel("Profesor*");
		profesorLabela.setPreferredSize(velicina);
		profesorLabela.setMaximumSize(velicina);
		profesorIzmena = new JTextField("Profesor");
		try {
			profesorIzmena.setText(pr.getPredProf().getIme()+" "+pr.getPredProf().getPrezime());
		} catch (NullPointerException np) {
			// TODO: handle exception
		}
		profesorIzmena.setEnabled(false);

		prihvatiIzmena = new JButton("Potvrdi");
		prihvatiIzmena.setPreferredSize(velicina);
		prihvatiIzmena.setEnabled(false);
		odustaniIzmena = new JButton("Odustani");
		odustaniIzmena.setPreferredSize(velicina);
		plusIzmena = new JButton("+");
		plusIzmena.setPreferredSize(velicina);
		minusIzmena = new JButton("-");
		minusIzmena.setPreferredSize(velicina);

		IzmenaPredmetaDocumentListener textChangeDocumentListener = new IzmenaPredmetaDocumentListener();

		sifraIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		imePredIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		espbIzmena.getDocument().addDocumentListener(textChangeDocumentListener);
		profesorIzmena.getDocument().addDocumentListener(textChangeDocumentListener);

		prihvatiIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (PredmetController.getInstance().izmeniPredmet())
					parent.dispose();

			}

		});

		odustaniIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				parent.dispose();
			}
		});

		plusIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				DodavanjeProfesoraPredmetuDialog dodavanjeProfesoraPredmetuDialog = new DodavanjeProfesoraPredmetuDialog(
						parent);
				profesorIzmena.setText(pr.getPredProf().getIme());
			}
		});

		minusIzmena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				UklanjanjeProfesoruSaPredmetaDialog uklananjeProfesoraSaPredmeta = new UklanjanjeProfesoruSaPredmetaDialog(
						parent, "Ukloni Profesora", true, profesorIzmena);

			}
		});
		
		godinaIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (PredmetController.getInstance().proveriIme(IzmenaPredmetaPanel.imePredIzmena.getText().trim())
						
						&& PredmetController.getInstance().proveriSifru(IzmenaPredmetaPanel.sifraIzmena.getText().trim())
						
						&& PredmetController.getInstance().proveriESPB(IzmenaPredmetaPanel.espbIzmena.getText().trim()))
						{

					prihvatiIzmena.setEnabled(true);
				}
			}
		});
		
		semestarIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (PredmetController.getInstance().proveriIme(IzmenaPredmetaPanel.imePredIzmena.getText().trim())
						
						&& PredmetController.getInstance().proveriSifru(IzmenaPredmetaPanel.sifraIzmena.getText().trim())
						
						&& PredmetController.getInstance().proveriESPB(IzmenaPredmetaPanel.espbIzmena.getText().trim()))
						{

					prihvatiIzmena.setEnabled(true);
				}
			}
		});

	


		this.add(textPanel, BorderLayout.NORTH);
		this.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(sifraLabela);
		textPanel.add(sifraIzmena);
		textPanel.add(imePredLabela);
		textPanel.add(imePredIzmena);
		textPanel.add(espbLabela);
		textPanel.add(espbIzmena);
		textPanel.add(godLabela);
		textPanel.add(godinaIzmena);
		textPanel.add(semestarLabela);
		textPanel.add(semestarIzmena);
		textPanel.add(profesorLabela);
		textPanel.add(profesorIzmena);
		textPanel.add(plusIzmena);
		textPanel.add(minusIzmena);

		buttonsPanel.add(prihvatiIzmena);
		buttonsPanel.add(odustaniIzmena);

		setVisible(true);
	}

}
