package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;

public class PAT_ScAp extends JPanel implements ActionListener{
	// INSTANCE VARIABLES	
	private int width, height;
	private JLabel nameLabel, addressLabel, ssnLabel, doctorLabel,healthRank, healthConcern,dateLabel;
	private JTextField name, address,ssn, date;
	private JTextArea healthConcerns;
	private JComboBox doctorDrop, healthRankDrop;
	private JButton apply; 
	String storeName, storeAddress, storeSsn,storeDoctor, storeHealthRank,storeConcerns, storeDate;




	public PAT_ScAp(int width, int height) {
		this.width  = width;
		this.height = height;
		String [] doctors = {"Select Doctor","Dr. Frances H. Petersen","Dr. Kathryn	Price","Dr. Colin B. Todd",
				"Dr. Paul Gonzalez","Dr. Karen Brown"};

		String [] problems = {"1","2","3","4","5","6","7","8","9","10"};
		//CREATE PANELS	
		JPanel wholePanel = new JPanel();
		JPanel labelPanel = new JPanel(); // Left side of whole Panel
		JPanel textfPanel = new JPanel(); // Right side of whole Panel
		apply = new JButton("Apply");
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
		
		
				// CREATE LABELS / TEXTFIELDS		
				nameLabel     = new JLabel("Name:");
				labelPanel.add(nameLabel);

		labelPanel.add(Box.createVerticalStrut(10)); //Adds an invisible "box"
		addressLabel  = new JLabel("Address:");
		
				labelPanel.add(addressLabel);
		Component verticalStrut = Box.createVerticalStrut(10);
		labelPanel.add(verticalStrut);
		ssnLabel      = new JLabel("SSN:");
		
				labelPanel.add(ssnLabel);
		labelPanel.add(Box.createVerticalStrut(10));
		doctorLabel   = new JLabel("Doctors:");
		
				labelPanel.add(doctorLabel);
		dateLabel	  = new JLabel("Date: (mm/dd/yy)");
		
				labelPanel.add(dateLabel);
		healthRank    = new JLabel("Health Rank:");
		
				labelPanel.add(healthRank);
		labelPanel.add(Box.createVerticalStrut(10));
		healthConcern = new JLabel("Health Concerns:");
		
				labelPanel.add(healthConcern);
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(Box.createVerticalStrut(10));
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
