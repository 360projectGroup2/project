package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class T1_MR extends JPanel {
	public JTextField algText;
	public JTextField hlConField;
	public JTextField otherField;

	/**
	 * Create the panel.
	 */
	public T1_MR() {
		setLayout(null);
		setSize(325,200);
		JLabel lblMedicalHistory = new JLabel("Medical Records");
		lblMedicalHistory.setBounds(77, 11, 111, 14);
		add(lblMedicalHistory);
		
		JLabel lblAllergies = new JLabel("Allergies:");
		lblAllergies.setBounds(10, 36, 70, 14);
		add(lblAllergies);
		
		JLabel lblHealthConditions = new JLabel("Health Conditions");
		lblHealthConditions.setBounds(10, 77, 111, 14);
		add(lblHealthConditions);
		
		algText = new JTextField();
		algText.setBounds(122, 36, 149, 20);
		add(algText);
		algText.setColumns(10);
		
		hlConField = new JTextField();
		hlConField.setBounds(121, 74, 150, 20);
		add(hlConField);
		hlConField.setColumns(10);
		
		JLabel lblOther = new JLabel("Other:");
		lblOther.setBounds(10, 126, 111, 14);
		add(lblOther);
		
		otherField = new JTextField();
		otherField.setColumns(10);
		otherField.setBounds(121, 123, 150, 20);
		add(otherField);

	}
}
