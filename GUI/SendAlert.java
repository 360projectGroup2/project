package GUI;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendAlert extends JPanel {
	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public TextArea textConcern;
	public JButton updateButton;
	public JComboBox healthRankDrop;

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
	
	textConcern = new TextArea();
	textConcern.setBounds(104, 563, 380, 75);
	add(textConcern);
	
	
	updateButton = new JButton("Update");
	updateButton.setBounds(545, 559, 89, 23);
	add(updateButton );
	updateButton.addActionListener(b);
	
	JLabel lblRank = new JLabel("Rank your pain:");
	lblFirstName.setBounds(100, 559, 100, 14);
	add(lblRank);
	
	
	String [] problems = {"1","2","3","4","5","6","7","8","9","10"};
	healthRankDrop = new JComboBox<Object>(problems);
	healthRankDrop.setBounds(545, 559, 100, 23);
	add(healthRankDrop);
	healthRankDrop.addActionListener(b);
	
	
	
	}
}
