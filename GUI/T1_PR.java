package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class T1_PR extends JPanel {
	public JTextField nameField;
	public JTextField addField;
	public JTextField conInfoText;

	/**
	 * Create the panel.
	 */
	public T1_PR() {
		setLayout(null);
		setSize(325,200);
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(98, 11, 111, 14);
		add(lblProfile);
		
		JLabel lblAllergies = new JLabel("Patient Name:");
		lblAllergies.setBounds(10, 36, 102, 14);
		add(lblAllergies);
		
		JLabel lblHealthConditions = new JLabel("Address");
		lblHealthConditions.setBounds(10, 77, 111, 14);
		add(lblHealthConditions);
		
		nameField = new JTextField();
		nameField.setBounds(122, 36, 149, 20);
		add(nameField);
		nameField.setColumns(10);
		
		addField = new JTextField();
		addField.setBounds(121, 74, 150, 20);
		add(addField);
		addField.setColumns(10);
		
		JLabel lblOther = new JLabel("Contact Info");
		lblOther.setBounds(10, 126, 111, 14);
		add(lblOther);
		
		conInfoText = new JTextField();
		conInfoText.setColumns(10);
		conInfoText.setBounds(121, 123, 150, 20);
		add(conInfoText);

	}
}
