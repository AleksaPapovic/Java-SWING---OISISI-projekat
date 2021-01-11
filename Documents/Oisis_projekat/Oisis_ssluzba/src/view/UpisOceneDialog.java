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
import javax.swing.JTextField;

import controller.ProfesorController;
import model.BazaPredmeta;
import model.Predmet;
import view.FocusField.TipPolja;

public class UpisOceneDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static FocusField datumUpisaField;
	public static JComboBox<String> comboboxUpisa;

	public static JButton prihvati;
	//private DocumentListener docList = new DocumentListenerProfesorFields();

	public UpisOceneDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setTitle(title);
		setSize(450, 300);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(4, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension polje = new Dimension(100, 30);
        
		JLabel sifraPredmetaLabela = new JLabel("Šifra predmeta");
		sifraPredmetaLabela.setPreferredSize(polje);
		sifraPredmetaLabela.setMaximumSize(polje);
		JTextField sifraPredmetaField = new JTextField();
		sifraPredmetaField.setEnabled(false);
      
		
		JLabel imePredmetaLabela = new JLabel("Unesite prezime");
		imePredmetaLabela.setPreferredSize(polje);
		imePredmetaLabela.setMaximumSize(polje);
		JTextField imePredmetaField = new JTextField();
		imePredmetaField.setEnabled(false);

		JLabel datumUpisaLabela = new JLabel("Unesite datum rodjenja");
		datumUpisaLabela.setPreferredSize(polje);
		datumUpisaLabela.setMaximumSize(polje);
		datumUpisaField = new FocusField(TipPolja.DatumR, "dd.mm.yyyy.");
        
		JLabel ocenaLabela = new JLabel("Ocena");
		ocenaLabela.setPreferredSize(polje);
		ocenaLabela.setMaximumSize(polje);
	

		JLabel titulaLabela = new JLabel("Izaberite titulu");
		titulaLabela.setPreferredSize(polje);
		titulaLabela.setMaximumSize(polje);
		String titule[] = { "Master", "Doktor", "Profesor doktor" };
		comboboxUpisa = new JComboBox<String>(titule);

	

		prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(polje);
		prihvati.setEnabled(false);
		JButton odbaci = new JButton("Odustani");
		odbaci.setPreferredSize(polje);

		prihvati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (ProfesorController.getInstance().dodatiProfesora())
					dispose();

			}
		});

		odbaci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

	//	imeField.getDocument().addDocumentListener(docList);
	//	prezimeField.getDocument().addDocumentListener(docList);
	//	datumRField.getDocument().addDocumentListener(docList);
		add(panel);

		panel.add(textPanel, BorderLayout.NORTH);
		panel.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(sifraPredmetaLabela);
		textPanel.add(sifraPredmetaField);
		textPanel.add(imePredmetaLabela);
		textPanel.add(imePredmetaField);
		textPanel.add(ocenaLabela);
		textPanel.add(comboboxUpisa);
		textPanel.add(datumUpisaLabela);
		textPanel.add(datumUpisaField);

		buttonsPanel.add(prihvati);
		buttonsPanel.add(odbaci);

		setVisible(true);
	}
}
