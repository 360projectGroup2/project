package GUI;

import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendAlert extends JPanel {
	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public TextArea textAreaMedicalHistory;
	public TextArea textAreaAllergies;
	public JButton updateButton;
	

	/**
	 * Create the panel.
	 */
	
	//layout is not completed 
	public SendAlert(ActionListener b) {
	
	JLabel lblFirstName = new JLabel("First name:");
	lblFirstName.setBounds(49, 59, 65, 14);
	add(lblFirstName);
	
	textFieldFName = new JTextField();
	textFieldFName.setBounds(124, 56, 86, 20);
	add(textFieldFName);
	textFieldFName.setColumns(10);
	
	JLabel lblLastName = new JLabel("Last name:");
	lblLastName.setBounds(49, 90, 65, 14);
	add(lblLastName);
	
	textFieldLName = new JTextField();
	textFieldLName.setColumns(10);
	textFieldLName.setBounds(124, 87, 86, 20);
	add(textFieldLName);
	
	JLabel label_1 = new JLabel("Concern:");
	label_1.setBounds(10, 563, 100, 20);
	add(label_1);
	
	textAreaAllergies = new TextArea();
	textAreaAllergies.setBounds(104, 563, 380, 75);
	add(textAreaAllergies);
	
	
	
	}
}
