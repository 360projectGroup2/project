package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Doctor;

import controller.TableController;

public class PAT_VA extends JPanel {
	public JButton btnViewAppointments, btnEdit, btnSave;
	public ArrayList<JRadioButton> buttons;
	public ButtonGroup b2;
	public inHouse action;
	public ArrayList<String> docN, dates;
	public JLabel label1, label2, label3;
	public JTextField txtBox1, txtBox2, txtBox3; 
	private JButton btnDelete;
	public JComboBox doctorDrop,date;
	
	/**
	 * Create the panel.
	 */
	public PAT_VA(ActionListener e, ActionListener b) {
		setLayout(null);
		b2 = new ButtonGroup();
		buttons = new ArrayList<JRadioButton>();
		action = new inHouse();

		JLabel lblAppt = new JLabel("Your Appointments");
		lblAppt.setBounds(178, 11, 125, 14);
		add(lblAppt);

		btnViewAppointments = new JButton("Load Appointments");
		btnViewAppointments.setBounds(161, 36, 125, 23);
		add(btnViewAppointments);
		btnViewAppointments.addActionListener(e);


		btnEdit = new JButton("Edit");
		btnEdit.setBounds(116, 266, 79, 23);
		btnEdit.addActionListener(action);
		add(btnEdit);

		btnSave = new JButton("Save");
		btnSave.setBounds(294, 266, 79, 23);
		btnSave.addActionListener(b);
		btnSave.addActionListener(action);
		add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(205, 266, 79, 23);
		btnDelete.addActionListener(action);
		add(btnDelete);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 80, 109, 23);
		//add(rdbtnNewRadioButton);

		label1 = new JLabel("New label");
		label1.setBounds(189, 112, 232, 14);
		//add(label1);

		label2 = new JLabel("New label");
		label2.setBounds(189, 137, 232, 14);
		//add(label2);

		label3 = new JLabel("New label");
		label3.setBounds(189, 163, 232, 14);
		//add(label3);

		txtBox1 = new JTextField();
		txtBox1.setBounds(189, 112, 232, 14);

		txtBox2 = new JTextField();
		txtBox2.setBounds(189, 137, 232, 14);

		txtBox3 = new JTextField();
		txtBox3.setBounds(189, 163, 232, 14);
	}

	public void loadAppts(ArrayList<String> a, ArrayList<String> b, ArrayList<String> c){
		docN = b;
		dates = c;

		TableController tc = new TableController();
		String[] attributes = {"DoctorGkey","ScheduledOn"};
		ArrayList appts=null;
		try{
			appts = tc.get("Appointments", attributes, "Status='Scheduled' and PatientGkey="+TableController.activePatient.patientId);
		}catch(SQLException se){
			System.out.println("Exception in get Appointments");
		}
		
		for(int i=0 ; i < appts.size();i++){
			System.out.println(appts.get(i));
			System.out.println(appts.get(i+1));
			String[] attrs = {"FirstName", "LastName"};
			ArrayList doc=null;
			try{
				doc = tc.get("Doctor", attrs, "Gkey="+appts.get(i));
			}catch(SQLException se){
				System.out.println("Exception in : Get Appointments - Doctor name");
			}
			String buttonName = appts.get(++i).toString();
			buttonName = buttonName.substring(0,buttonName.lastIndexOf("."));
			buttonName = doc.get(0)+" "+doc.get(1)+" "+ buttonName;
			System.out.println(buttonName);
			JRadioButton button = new JRadioButton(buttonName);
			b2.add(button);
			button.setBounds(130, 112+(10*(i+1)), 260, 14);
			add(button);
		
		}
		
	/*	for(int i=0; i<a.size(); i++){
			buttons.add(new JRadioButton(a.get(i)));
			buttons.get(i).setBounds(6,83+i*26, 109, 23);
			buttons.get(i).addActionListener(action);
			b2.add(buttons.get(i));
			add(buttons.get(i));

		}*/
	
	/*	add(label1);
		add(label2);
		add(label3);*/
		add(btnEdit);
		add(btnSave);
		
		//now show them
		revalidate();
		repaint();

	}
	public class inHouse implements ActionListener{
		public void actionPerformed (ActionEvent event){
			ArrayList<Doctor> doctorList=null;
			if(event.getSource()==btnEdit){
				String apptInfo="";
				for (Enumeration<AbstractButton> buttons = b2.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();

		            if (button.isSelected()) {
		                apptInfo = button.getText();
		            }
		        }
			//	ArrayList<Doctor> doctorList=null;
				try{
					doctorList = new Doctor().getDoctor(0);
				}catch(SQLException se){
					System.out.println("Exception edit APPOINTMENTS");
				}
				
				ArrayList<String> doctorNames= new ArrayList<String>();
				for(int i=0; i < doctorList.size(); i++){
					doctorNames.add("Dr. "+doctorList.get(i).getFirstName() +" "+doctorList.get(i).getLastName() + " - " + doctorList.get(i).specialty);
				}
				String[] doctors = doctorNames.toArray(new String[doctorNames.size()]);
				
			//	String [] problems = {"1","2","3","4","5","6","7","8","9","10"};
				
				doctorDrop     = new JComboBox<String>(doctors);
				doctorDrop.addActionListener(this);
				//JComboBox healthRankDrop = new JComboBox<String>(problems);
			//	healthRankDrop.addActionListener(this);
				date = new JComboBox<String>();
				
				
				// Text Area
				JTextArea healthConcerns = new JTextArea();
				healthConcerns.setColumns(10);
				healthConcerns.setRows(2);
				healthConcerns.setLineWrap(true);
				healthConcerns.setWrapStyleWord(true);
				
				
				
				add(txtBox1);
				txtBox1.setText(label1.getText());
				add(txtBox2);
				txtBox2.setText(label2.getText());
				add(txtBox3);
				txtBox3.setText(label3.getText());
				remove(label1);
				remove(label2);
				remove(label3);
				revalidate();
				repaint();
			}

			if (event.getSource()== doctorDrop)
			{
				JComboBox cb = (JComboBox)event.getSource();
				String storeDoctor  = (String)cb.getSelectedItem();
				
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
						ApplicationRunner.docId = doctorList.get(i).getID();
						break;
					}
				}
			}
			
			if(event.getSource() == btnDelete){
				for(int i=0; i<buttons.size(); i++){
					if(buttons.get(i).isSelected()){
						/*
						//buttons.remove(i);
						//docN.remove(i);
						for(int j=i;j<buttons.size()-1; j++){
							buttons.get(j).setText(buttons.get(j+1).getText());
							label1.setText(buttons.get(j+1).getText());
							docN.set(j, docN.get(j+1));
							label2.setText(docN.get(j));
							dates.set(j, dates.get(j+1));
							label3.setText(dates.get(j));
						}
						buttons.remove(buttons.size()-1);
						docN.remove(docN.size()-1);
						dates.remove(dates.size()-1);
						b2.remove(buttons.get(buttons.size()-1));
						remove(buttons.get(buttons.size()-1));
						revalidate();
						repaint();
						 */
						remove(buttons.get(i));
						if(label1.isDisplayable()){
							remove(label1);
							remove(label2);
							remove(label3);
						}
						else{
							remove(txtBox1);
							remove(txtBox2);
							remove(txtBox3);
						}
						revalidate();
						repaint();
					}
				}
			}

			else if(event.getSource()==btnSave&&txtBox1.isShowing()){
				remove(txtBox1);
				remove(txtBox2);
				remove(txtBox3);
				add(label1);
				label1.setText(txtBox1.getText());
				add(label2);
				label2.setText(txtBox2.getText());
				add(label3);
				label3.setText(txtBox3.getText());
				for(int i=0; i<buttons.size(); i++)
					if(buttons.get(i).isSelected()){
						buttons.get(i).setText(label1.getText());
						docN.set(i, label2.getText());
						dates.set(i, label3.getText());
					}

				revalidate();
				repaint();
			}
			else{
				for(int i=0; i<buttons.size(); i++){
					if(event.getSource() == buttons.get(i)){
						if(txtBox1.isShowing()){
							remove(txtBox1);
							remove(txtBox2);
							remove(txtBox3);
						}
			
						revalidate();
						repaint();
						
						label1.setText(buttons.get(i).getText());
						label2.setText(docN.get(i));
						label3.setText(dates.get(i));
					}
				}
			}

		}
	}
}
