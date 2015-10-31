package GUI;

import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NursePanel extends JPanel  {
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public TextArea textAreaMedicalHistory;
	public TextArea textAreaAllergies;
	public JButton updateButton;
	public JLabel lblName;
	public JLabel lblAddress;
	public JButton btnSearch;
	public TextArea medicalHistoryDisplay;
	
	/**
	 * Create the panel.
	 **/
	
	@SuppressWarnings("unchecked")
	public NursePanel(ActionListener b) {
		
		setLayout(null);
		setSize(680,653);
		
		JLabel lblScheduleAppt = new JLabel("Health Condition Update");
		lblScheduleAppt.setBounds(95, 11, 128, 14);
		add(lblScheduleAppt);
		
		JLabel lblSearchForA = new JLabel("Search for a patient:");
		lblSearchForA.setBounds(10, 39, 118, 14);
		add(lblSearchForA);
		
	
		
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
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(121, 118, 89, 23);
		add(btnSearch);
		btnSearch.addActionListener(b);
		
		JLabel lblPatientInfo = new JLabel("Patient Info:");
		lblPatientInfo.setBounds(10, 150, 80, 14);
		add(lblPatientInfo);
		
		lblName = new JLabel("Name: ???");
		lblName.setBounds(49, 175, 65, 14);
		add(lblName);
		
		lblAddress = new JLabel("Address: ???");
		lblAddress.setBounds(49, 200, 161, 14);
		add(lblAddress);
		
		JLabel lblMedicalHistory = new JLabel("Medical History:");
		lblMedicalHistory.setBounds(10, 247, 90, 14);
		add(lblMedicalHistory);
		
		medicalHistoryDisplay = new TextArea();
		medicalHistoryDisplay.setBounds(104, 247, 380, 75);
		add(medicalHistoryDisplay);
		
		JLabel lblAllergies = new JLabel("Allergies:");
		lblAllergies.setBounds(10, 339, 90, 14);
		add(lblAllergies);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(104, 340, 380, 75);
		add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Add New Information");
		lblNewLabel.setBounds(95, 443, 215, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Medical History:");
		label.setBounds(10, 481, 90, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Allergies:");
		label_1.setBounds(10, 563, 90, 14);
		add(label_1);
		
		textAreaMedicalHistory = new TextArea();
		textAreaMedicalHistory.setBounds(104, 482, 380, 75);
		add(textAreaMedicalHistory);
		
		textAreaAllergies = new TextArea();
		textAreaAllergies.setBounds(104, 563, 380, 75);
		add(textAreaAllergies);
		
		
		updateButton = new JButton("Update");
		updateButton.setBounds(545, 559, 89, 23);
		add(updateButton );
		updateButton.addActionListener(b);
		
		
		
	
	}
}
