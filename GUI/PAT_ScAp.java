package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.Doctor;

public class PAT_ScAp extends JPanel implements ActionListener{
	// INSTANCE VARIABLES	
	private int width, height;
	private JLabel nameLabel, addressLabel, ssnLabel, doctorLabel,healthRank, healthConcern,dateLabel;
	private JTextField name, address,ssn;
	private JTextArea healthConcerns;
	private JComboBox doctorDrop, healthRankDrop, date;
	private JButton apply; 
	String storeName, storeAddress, storeSsn,storeDoctor, storeHealthRank,storeConcerns, storeDate;

	ArrayList<Doctor> doctorList = new Doctor().getDoctor(0);


	public PAT_ScAp(int width, int height) throws SQLException{
		this.width  = width;
		this.height = height;
	//	String [] doctors = {"Select Doctor","Dr. Frances H. Petersen","Dr. Kathryn	Price","Dr. Colin B. Todd",
	//			"Dr. Paul Gonzalez","Dr. Karen Brown"};

		
		ArrayList<String> doctorNames= new ArrayList<String>();
		for(int i=0; i < doctorList.size(); i++){
			doctorNames.add("Dr. "+doctorList.get(i).getFirstName() +" "+doctorList.get(i).getLastName() + " - " + doctorList.get(i).specialty);
		}
		String[] doctors = doctorNames.toArray(new String[doctorNames.size()]);
		
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


		//DropDown (combo) Boxes
		doctorDrop     = new JComboBox<String>(doctors);
		doctorDrop.addActionListener(this);
		healthRankDrop = new JComboBox<String>(problems);
		healthRankDrop.addActionListener(this);
		date = new JComboBox<String>();
		
		
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
			
			storeDoctor = storeDoctor.substring(storeDoctor.indexOf(".")+2);
			String speciality = storeDoctor.substring(storeDoctor.lastIndexOf("-")+2);
			storeDoctor = storeDoctor.substring(0, storeDoctor.lastIndexOf(" -"));
			String lName = storeDoctor.substring(storeDoctor.lastIndexOf(" ")+1);
			String fName = storeDoctor.substring(0,storeDoctor.indexOf(" "));
			
			String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
			
			
			for(int i=0; i<doctorList.size();i++){
				
				if(doctorList.get(i).lastName.equals(lName) && doctorList.get(i).firstName.equals(fName) && doctorList.get(i).specialty.equals(speciality)){
					
					ArrayList<String> timings=new ArrayList<String>();
					
					Calendar cal = Calendar.getInstance();
					
					for(int j=0; j<3; j++){
						
						cal.add(Calendar.DATE, 1);
						
						String day = days[cal.get(Calendar.DAY_OF_WEEK) - 1];
						
						if(doctorList.get(i).availble.getWeekday().contains(day)){
								String start_hour = doctorList.get(i).availble.getStartHour();
								int start_mins = Integer.parseInt(start_hour.substring(start_hour.indexOf(":")+1));
								
								int start_hours = Integer.parseInt(start_hour.substring(0,start_hour.indexOf(":")));
								
								String end_hour = doctorList.get(i).availble.getEndHour();
								int end_mins = Integer.parseInt(end_hour.substring(end_hour.indexOf(":")+1));
								int end_hours = Integer.parseInt(end_hour.substring(0,end_hour.indexOf(":")));
								
								cal.set(Calendar.HOUR_OF_DAY, end_hours);
								cal.set(Calendar.MINUTE, end_mins);
								Date endTime = cal.getTime();
								
								cal.set(Calendar.HOUR_OF_DAY, start_hours);
								cal.set(Calendar.MINUTE, start_mins);
								Date startTime = cal.getTime();
								
								while(startTime.before(endTime)){
									String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(startTime);
									timings.add(time);
								//	System.out.println("time:"+time);
									cal.set(Calendar.HOUR_OF_DAY, ++start_hours);
									startTime = cal.getTime();
								}
								
						}
					}
					date.setModel(new DefaultComboBoxModel(timings.toArray()));
					break;
				}
			}
		}
		else if (source == apply)
		{
			storeName 	  = name.getText();
			storeAddress  = address.getText();
			storeSsn 	  = ssn.getText();
			storeConcerns = healthConcerns.getText();
			storeDate 	  = (String)date.getSelectedItem();
			//store these values
		}
		else if(source == healthRankDrop)
		{
			JComboBox db = (JComboBox)e.getSource();
			storeHealthRank = (String)db.getSelectedItem();
		}

	} // End ActionListener
} // End Class
