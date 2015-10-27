package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Lab_Records extends JPanel implements ActionListener{
	// INSTANCE VARIABLES	

private JLabel pNameLabel, patientID, consultationID, testID,patientKey;
private JTextField name, pID,consultID, testIdent,pKey;
private JButton view, save; 
public String storeName, storePatientID, storeConsultID,storeTestID, storePkey;
		
//

	public Lab_Records(ActionListener b) {
		setLayout(null);
		setSize(500,300);
	
		//CREATE PANELS	
		JPanel wholePanel = new JPanel();
		JPanel labelPanel = new JPanel(); // Left side of whole Panel
		JPanel textfPanel = new JPanel(); // Right side of whole Panel
	   

		// CREATE LABELS / TEXTFIELDS		
		pNameLabel		= new JLabel("Patient Name:");
		patientID 	 	= new JLabel("Patient ID:");
		consultationID  = new JLabel("Consultation ID:");
		testID   		= new JLabel("Test ID:");
		patientKey    	= new JLabel("Specialized Patient Key:");
		save 			= new JButton("Save");
		view 			= new JButton("View");
		save.addActionListener(this);
		view.addActionListener(this);

		//Text Field Initialization	
		name = new JTextField();
		pID = new JTextField();
		consultID = new JTextField();
		testIdent = new JTextField();
		pKey = new JTextField();

	// LabelPanel -- (Left Side)
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		
		labelPanel.add(Box.createVerticalStrut(10)); //Adds an invisible "box"
		labelPanel.add(pNameLabel);
		labelPanel.add(Box.createVerticalStrut(10));
			
		labelPanel.add(patientID);
		labelPanel.add(Box.createVerticalStrut(10));
			
		labelPanel.add(consultationID);
		labelPanel.add(Box.createVerticalStrut(10));
			
		labelPanel.add(testID);
		labelPanel.add(Box.createVerticalStrut(10));
		
		labelPanel.add(patientKey);
		labelPanel.add(Box.createVerticalStrut(10));
	
	// Text Panel -- (Right Side)		
		textfPanel.setLayout(new BoxLayout(textfPanel, BoxLayout.Y_AXIS));
		
		textfPanel.add(name);
		textfPanel.add(pID);
		textfPanel.add(consultID);
		textfPanel.add(testIdent);
		textfPanel.add(pKey);
		textfPanel.add(save);
		textfPanel.add(view);

		//PIECES THE LABEL AND TEXTS TOGETHER
			wholePanel.setLayout(new GridLayout(0,3));
			wholePanel.add(labelPanel);
			wholePanel.add(textfPanel);
		    add(wholePanel);
		    
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

