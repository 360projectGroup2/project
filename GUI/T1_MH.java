package DoctorStuff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class T1_MH extends JPanel {
	public JTextField algText;
	public JTextArea healthConds;

	/**
	 * Create the panel.
	 */
	public T1_MH() {
		setLayout(null);
		setSize(325,200);
		JLabel lblMedicalHistory = new JLabel("Medical History");
		lblMedicalHistory.setBounds(112, 11, 111, 14);
		add(lblMedicalHistory);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(10, 36, 70, 14);
		add(lblAllergies);
		
		JLabel lblHealthConditions = new JLabel("Health Conditions");
		lblHealthConditions.setBounds(10, 77, 111, 14);
		add(lblHealthConditions);
		
		algText = new JTextField();
		algText.setBounds(122, 36, 149, 20);
		add(algText);
		algText.setColumns(10);
		
		healthConds = new JTextArea();
		healthConds.setBounds(122, 72, 149, 67);
		add(healthConds);

	}
}
