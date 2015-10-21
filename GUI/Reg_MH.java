package GUI;


import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Reg_MH extends JPanel {
	//globals
	public JTextField allergies;
	public JTextArea medHis;
	public JButton save;
	/**
	 * Create the panel.
	 */
	public Reg_MH(ActionListener b) {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblNewLabel = new JLabel("Medical History");
		lblNewLabel.setBounds(125, 11, 88, 14);
		add(lblNewLabel);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(10, 36, 88, 14);
		add(lblAllergies);
		
		JLabel lblPastMedicalHistory = new JLabel("Past Medical\r\n History");
		lblPastMedicalHistory.setBounds(10, 108, 130, 38);
		add(lblPastMedicalHistory);
		
		save = new JButton("Save");
		save.setBounds(125, 176, 89, 23);
		add(save);
		
		allergies = new JTextField();
		allergies.setBounds(172, 36, 130, 20);
		add(allergies);
		allergies.setColumns(10);
		
		medHis = new JTextArea();
		medHis.setBounds(172, 84, 130, 81);
		add(medHis);
	}
}
