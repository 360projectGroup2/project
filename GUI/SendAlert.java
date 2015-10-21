package GUI;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SendAlert extends JPanel {
	
	/**
	 * ATTENTION:
	 * The patient does not select severity level. Severity level is included in database.
	 * Patient only enters health condition. System only notifies patient of severity level retrieved from database.
	 */
	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public TextArea textConcern;
	public JButton updateButton;
	public JLabel concernLabel;
	//public JComboBox healthRankDrop;

	/**
	 * Create the panel.
	 */
	
	//layout is not completed
	public SendAlert(ActionListener b) {
		setLayout(null);
		setSize(500,300);
		
		
	JLabel lblFirstName = new JLabel("First name:");
	lblFirstName.setBounds(30, 59, 65, 14);
	add(lblFirstName);
	
	textFieldFName = new JTextField();
	textFieldFName.setBounds(98, 56, 86, 20);
	add(textFieldFName);
	textFieldFName.setColumns(10);
	
	JLabel lblLastName = new JLabel("Last name:");
	lblLastName.setBounds(30, 90, 65, 14);
	add(lblLastName);
	
	textFieldLName = new JTextField();
	textFieldLName.setColumns(10);
	textFieldLName.setBounds(98, 87, 86, 20);
	add(textFieldLName);
	
	concernLabel = new JLabel("Concern:");
	concernLabel.setBounds(30, 150, 60, 20);
	add(concernLabel);
	
	textConcern = new TextArea();
	textConcern.setBounds(100, 150, 300, 75);
	add(textConcern);
	
	
	updateButton = new JButton("Send Alert");
	updateButton.setBounds(300, 250, 100, 23);
	add(updateButton );
	updateButton.addActionListener(b);
	
	/*
	JLabel lblRank = new JLabel("Rank your pain:");
	lblFirstName.setBounds(100, 559, 100, 14);
	add(lblRank);
		
	String [] problems = {"1","2","3","4","5","6","7","8","9","10"};
	healthRankDrop = new JComboBox<Object>(problems);
	healthRankDrop.setBounds(545, 559, 100, 23);
	add(healthRankDrop);
	healthRankDrop.addActionListener(b);
	 */
	}

	public void actionPerformed(ActionEvent ae)
	{
		// to be completed
	}
}
