// 10-27-15 1:00 AM UPDATE
package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Lab_Records extends JPanel implements ActionListener{
	// INSTANCE VARIABLES	

public JLabel pNameLabel, patientID, consultationID, testID,patientKey;
public JTextField name, pID,consultID, testIdent,pKey;
public JButton view, save; 
public String storeName, storePatientID, storeConsultID,storeTestID, storePkey;
		

	public Lab_Records(ActionListener b) {
		setLayout(null);
		setSize(500,300);
	

		// CREATE LABELS / TEXTFIELDS		
		pNameLabel		= new JLabel("Patient Name:");
		pNameLabel.setBounds(30, 59, 90, 14);
		add(pNameLabel);
		
		patientID 	 	= new JLabel("Patient ID:");
		patientID.setBounds(30, 90, 65, 14);
		add(patientID);

		consultationID  = new JLabel("Consultation ID:");
		consultationID.setBounds(30, 121, 120, 14);
		add(consultationID);
		
		testID   		= new JLabel("Test ID:");
		testID.setBounds(30, 152, 65, 14);
		add(testID);
		
		patientKey    	= new JLabel("Specialized Patient Key:");
		patientKey.setBounds(30, 183, 150, 14);
		add(patientKey);
		save 			= new JButton("Save");
		save.setBounds(180, 211, 86, 20);
		add(save);
		
		view 			= new JButton("View");
		view.setBounds(180, 242, 86, 20);
		add(view);
		save.addActionListener(this);
		view.addActionListener(this);

		//Text Field Initialization	
		name = new JTextField();
		name.setBounds(180, 56, 86, 20);
		add(name);
		name.setColumns(10);
		
		pID = new JTextField();
		pID.setColumns(20);
		pID.setBounds(180, 87, 86, 20);
		add(pID);
		
		consultID = new JTextField();
		consultID.setColumns(20);
		consultID.setBounds(180, 118, 86, 20);
		add(consultID);
		
		testIdent = new JTextField();
		testIdent.setColumns(20);
		testIdent.setBounds(180, 149, 86, 20);
		add(testIdent);
		
		pKey = new JTextField();
		pKey.setColumns(20);
		pKey.setBounds(180, 180, 86, 20);
		add(pKey);
		
	  } // End Controller	
	public void actionPerformed(ActionEvent e) {
		//Get Text
		Object source = e.getSource();
		if(source == save) {
			storeName 	  	= name.getText();
			storePatientID  = pID.getText();
			storeConsultID 	= consultID.getText();
			storeTestID 	= testIdent.getText();
			storePkey 	  	= pKey.getText();
			
			name.setText("");
			pID.setText("");
			consultID.setText("");
			testIdent.setText("");
			pKey.setText("");
		}
		else if(source == view)
		{
			storeName = name.getText();
			if(storeName.equals("hello")) 
			{
				pID.setText(storePatientID);
				consultID.setText(storeConsultID);
				testIdent.setText(storeTestID);
				pKey.setText(storePkey);
				
			}
		}
	} // End ActionListener
} // End Class

