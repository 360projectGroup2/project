package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller extends JPanel implements ActionListener{
// INSTANCE VARIABLES	
	private int width, height;
	private JLabel nameLabel, addressLabel, ssnLabel, doctorLabel,healthRank, healthConcern,dateLabel;
	private JTextField name, address,ssn, date;
	private JTextArea healthConcerns;
	private JComboBox doctorDrop, healthRankDrop;
	private JButton apply; 
	public String storeName, storeAddress, storeSsn,storeDoctor, storeHealthRank,storeConcerns, storeDate;
	


public Controller(int width, int height) {
	this.width  = width;
	this.height = height;
	String [] doctors = {"Select Doctor","Dr. Frances H. Petersen","Dr. Kathryn	Price","Dr. Colin B. Todd",
					     "Dr. Paul Gonzalez","Dr. Karen Brown"};
	
	String [] problems = {"1","2","3","4","5","6","7","8","9","10"};
	//CREATE PANELS	
	JPanel wholePanel = new JPanel();
	JPanel labelPanel = new JPanel(); // Left side of whole Panel
	JPanel textfPanel = new JPanel(); // Right side of whole Panel
   

	// CREATE LABELS / TEXTFIELDS		
	nameLabel     = new JLabel("Name:");
	addressLabel  = new JLabel("Address:");
	ssnLabel      = new JLabel("SSN:");
	doctorLabel   = new JLabel("Doctors:");
	dateLabel	  = new JLabel("Date: (mm/dd/yy)");
	healthRank    = new JLabel("Health Rank:");
	healthConcern = new JLabel("Health Concerns:");
	apply         = new JButton("Apply");
	apply.addActionListener(this);

	//Text Field Initialization	
	name    = new JTextField();
	address = new JTextField();
	ssn     = new JTextField();
	date 	= new JTextField();
	

	
	
	//DropDown (combo) Boxes
	doctorDrop     = new JComboBox(doctors);
	doctorDrop.addActionListener(this);
	healthRankDrop = new JComboBox(problems);
	healthRankDrop.addActionListener(this);
	
	// Text Area
	healthConcerns = new JTextArea();
	healthConcerns.setColumns(10);
	healthConcerns.setRows(2);
	healthConcerns.setLineWrap(true);
	healthConcerns.setWrapStyleWord(true);
	
// LabelPanel -- (Left Side)
	labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
	
	labelPanel.add(Box.createVerticalStrut(10)); //Adds an invisible "box"
	labelPanel.add(nameLabel);
	labelPanel.add(Box.createVerticalStrut(10));
		
	labelPanel.add(addressLabel);
	labelPanel.add(Box.createVerticalStrut(10));
		
	labelPanel.add(ssnLabel);
	labelPanel.add(Box.createVerticalStrut(10));
		
	labelPanel.add(doctorLabel);
	labelPanel.add(Box.createVerticalStrut(10));
	
	labelPanel.add(dateLabel);
	labelPanel.add(Box.createVerticalStrut(10));
		
	labelPanel.add(healthRank);
	labelPanel.add(Box.createVerticalStrut(10));
	
	labelPanel.add(healthConcern);
	labelPanel.add(Box.createVerticalStrut(10));
// Text Panel -- (Right Side)		
	textfPanel.setLayout(new BoxLayout(textfPanel, BoxLayout.Y_AXIS));
	
	textfPanel.add(name);
	textfPanel.add(address);
	textfPanel.add(ssn);
	textfPanel.add(doctorDrop);
	textfPanel.add(date);
	textfPanel.add(healthRankDrop);
	textfPanel.add(healthConcerns);
	textfPanel.add(apply);
	

	//PIECES THE LABEL AND TEXTS TOGETHER
		wholePanel.setLayout(new GridLayout(0,3));
		wholePanel.add(labelPanel);
		wholePanel.add(textfPanel);
	    add(wholePanel);
	    
  } // End Controller	
public void actionPerformed(ActionEvent e) {
	//Get Text
	Object source = e.getSource();
	if (source == doctorDrop)
	{
		JComboBox cb = (JComboBox)e.getSource();
	    storeDoctor  = (String)cb.getSelectedItem();
	}
	else if (source == apply)
	{
		storeName 	  = name.getText();
		storeAddress  = address.getText();
		storeSsn 	  = ssn.getText();
		storeConcerns = healthConcerns.getText();
		storeDate 	  = date.getText();
	}
	else if(source == healthRankDrop)
	{
		JComboBox db = (JComboBox)e.getSource();
		storeHealthRank = (String)db.getSelectedItem();
	}
	
	} // End ActionListener
} // End Class

