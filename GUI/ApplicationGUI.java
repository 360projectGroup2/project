package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jfree.ui.RefineryUtilities;

import model.*;
import controller.TableController;

/**EDIT TEST
 *THIS IS THE FIRST MAJOR PANEL
 *THIS CODE STRUCTURE IS BAD I KNOW, I'LL CLEAN IT UP OVER THE WEEKEND AS MUCH AS I POSSIBLY CAN
 *THERE ARE TWO ACTIONLISTENERS, READ WHAT I SAID ON THEM ON THE SDD
 *YOU CAN IGNORE THE METHODS THAT I PUT IN FOR THE MOST PART FOR EVENTHANDLER
 *SORRY THAT I AM ON A PLANE FLIGHT ATM BUT THERE IS NOTHING I CAN DO
 *IF THERE ARE ANY MAJOR PROBLEMS I APOLOGIZE PROFUSELY BUT I THINK I GOT ALL OF THE KINKS OUT
 *THERE IS NO LOGON PANEL SINCE THAT DOES NOT NEED TO BE MADE ACCORDING TO THE DOCS
 *ALL PANEL BLOCKS ARE APPROPIATELY LABELED AS SUCH
 *HAVE FUN CONNECTING THIS TO THE MAIN STUFF RUNNING BEHIND THE SCENES
 *CHEERS, JOHN SHALLLER
 *PS I USED ABSOLUTE LAYOUT DO NOT GET RID OF THE STATEMENT .setLayout(null); IT IS THERE FOR A REASON



 *ONE OTHER IMPORTANT THING
 *THE HEALTHCARE CONDITION UPDATE AND SCHEDULE APPOINTMENT PANELS ARE NOT DONE AS THEY WERE NOT LABELED IN THE SDD
 *I HAVE NO CLUE HOW THOSE TWO WOULD WORK ANYWAYS DATAWISE SO CANT REALLY DESIGN THEM
 *IF YOU GIVE ME A PICTURE OUR DESCRIBE IT TO ME I CAN HAVE IT DONE BY 1AM 10/10/2015

 *

 *EXPECT SOME CHANGES TO THIS LAYOUT


 */

public class ApplicationGUI extends JFrame {

	private JPanel contentPane;
	//Reg_PI reg_PI;
	//JPanel RegistrationBase, reg_II, reg_CI, reg_MH, reg_LI;
	//login panels
	//THIS IS THE THINGY THAT GETS UPDATED
	String user;	
	
	LoginScreen loginS;
	ForgotPW forgotPanel;
	TestPatient_Registration1 RegistrationBase;


	TestStandardScreen general2;
	
	TestP1 start;
	//patient schedule appt
	PAT_ScAp pat_ScAp;
	PAT_VA pat_VA;
	//patient update health condition
	PAT_HCU pat_HCU;
	SendAlert sendAlert;
	Patient pat;
	Lab_Records lab_rec;
	NursePanel nurse_panel;
	HSPGenStats hspGenStats;
	Pharmacist_Panel pharmacist_panel;


	//Controller test_app;
	Reg_PI reg_PI;
	Reg_II reg_II;
	Reg_CI reg_CI;
	Reg_MH reg_MH;
	Reg_LI reg_LI;

	//add in the tabs
	HSPBase h_Base;
	HSP2_Base hspPanel;

	HSPTab1 H_tab1;
	HSPTab2 H_tab2;
	HSPTab3 H_tab3;
	HSPTab4 H_tab4;




	/**
	 * Launch the application.
	 */

	public ApplicationGUI() throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		Event_Handler e = new  Event_Handler();
		Bridge b = new Bridge();

		start = new TestP1(e);

		//test_app = new Controller(500,500);
		//pat_SeAl = new PAT_SeAl();
		try {
			pat_ScAp = new PAT_ScAp(500,500);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//login panels
		loginS = new LoginScreen(e,b);	
		forgotPanel = new ForgotPW(e,b);


		RegistrationBase = new TestPatient_Registration1(e, b);
		reg_PI = new Reg_PI(b);
		reg_II = new Reg_II(b);
		reg_LI = new Reg_LI(b);
		reg_CI = new Reg_CI(b);
		reg_MH = new Reg_MH(b);
		
		//total base panel
		general2 = new TestStandardScreen(e);

		
		
		pat_VA = new PAT_VA(e,b);
		pat_HCU = new PAT_HCU(b);
		sendAlert = new SendAlert(b);
		lab_rec = new Lab_Records(b);
		nurse_panel = new NursePanel(b);
		//hsp generate statistics
		hspGenStats = new HSPGenStats(e,b);
		//pharmacist panel
		pharmacist_panel = new Pharmacist_Panel(b);
		hspPanel = new HSP2_Base(e);

		

		//HSP Panels
		H_tab1 = new HSPTab1(b);
		H_tab2 = new HSPTab2(b);
		H_tab3 = new HSPTab3(b);
		H_tab4 = new HSPTab4();
		h_Base = new HSPBase(H_tab1, H_tab2, H_tab3, H_tab4, -1);

		//final
		contentPane = new JPanel();
		//contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));	
		//contentPane.add(start);


		try{ 
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e1){
			e1.printStackTrace();
		}

		setContentPane(loginS);
	}
	public void display(){
		setSize(700,500);
		//pack();
		setVisible(true);
	}

	private TableController tc = new TableController();

	//TAKES CARE OF CHANGING FROM ONE JPANEL TO ANOTHER
	public class Event_Handler implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource() == loginS.btnForgotPassword){
				updateStart(forgotPanel);
			}
			if(event.getSource() == loginS.btnRegister){
				updateStart(RegistrationBase);
			}			
			
			if(event.getSource() == loginS.btnExitApplication){
				dispose();
			}
			// LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN
			if(event.getSource() == loginS.btnLogin){
				
				char pass[] = loginS.passField.getPassword();
				String passw = new String(pass);
				try {
					user = tc.callLogin(loginS.userField.getText(), passw);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				if (user.equals("Patient")){
					updateStart(general2);
					switch1(general2, general2.switchPanel, pat_HCU);
				}
				else if(user.equals("Doctor")){
					updateStart(general2);
					switch1(general2, general2.switchPanel, h_Base);
				}
				else if(user.equals("HSP")){
					updateStart(general2);
					switch1(general2, general2.switchPanel, hspPanel);
				}
				else if(user.equals("Nurse")){
					updateStart(general2);
				}
				else if(user.equals("Pharmacist")){
					updateStart(general2);
					switch1(general2, general2.switchPanel, pharmacist_panel);
				}
				
			}
			
			if(event.getSource() == general2.btnLogout){
				updateStart(loginS);
				
			}
			
			if(event.getSource() == hspPanel.btn1){
				switch1(general2,general2.switchPanel, hspGenStats);
			}
			if(event.getSource() == hspPanel.btn2){
				switch1(general2, general2.switchPanel, RegistrationBase);
			}
						
			//---
			if(event.getSource() == start.savebutton){
				updateStart(RegistrationBase);
				pat = new Patient(true);
			}
			if(event.getSource() == start.ScheduleAppBtn){
				updateStart(pat_ScAp);

			}
			if(event.getSource() == start.UpdateHealthCondBtn){
				updateStart(pat_HCU);
			}

			if(event.getSource() == start.nurseBtn){
				updateStart(nurse_panel);
			}

			if(event.getSource() == start.hspStatsButton){
				updateStart(hspGenStats);
			}

			if(event.getSource() == start.sendAlertBtn){
				updateStart(sendAlert);
			}

			if(event.getSource() == start.docPanBtn){
				updateStart(h_Base);
				setSize(700,1000);
			}

			if(event.getSource() == start.labStaffBtn){
				updateStart(lab_rec);

			}  
			if(event.getSource() == start.pharmacistBtn){
				updateStart(pharmacist_panel);

			} 

			//----
			if (event.getSource() == RegistrationBase.b1){
				update(RegistrationBase.panel, reg_PI);
			}
			if (event.getSource() == RegistrationBase.b2){
				update(RegistrationBase.panel, reg_CI);
			}
			if (event.getSource() == RegistrationBase.b3){
				update(RegistrationBase.panel, reg_II);
			}
			if (event.getSource() == RegistrationBase.b4){
				update(RegistrationBase.panel, reg_MH);
			}
			if (event.getSource() == RegistrationBase.b5){
				update(RegistrationBase.panel, reg_LI);
			}
			if (event.getSource() == RegistrationBase.b6){
				updateStart(loginS);
			}
			if (event.getSource() == RegistrationBase.btnBack){
				updateStart(loginS);
			}


		}

		void update(JPanel base, JPanel add){
			base.removeAll();
			base.add(add);
			base.revalidate();
			base.repaint();
			//base.pack();
		}
		void switch1(JPanel base, JPanel remove, JPanel add){
			base.remove(remove);
			add.setSize(remove.getSize());
			add.setBounds(remove.getBounds());
			base.add(add);
			base.revalidate();
			base.repaint();
			//base.pack();
		}		


	}
	void updateStart(JPanel base){
		setContentPane(base);
		revalidate();
		repaint();
	} 
	/*
	 * Reg_PI reg_PI;
	Reg_II reg_II;
	Reg_CI reg_CI;
	Reg_MH reg_MH;
	Reg_LI reg_LI;
	 * 
	 */
	//INSERT METHODS HERE

	public class Bridge implements ActionListener{
		public void actionPerformed (ActionEvent event){
			
			if (event.getSource() == loginS.btnLogin) {
				System.out.println("Login button clicked.");
			}
			
			if(event.getSource() == pat_VA.btnViewAppointments){
				System.out.println("Test");
				ArrayList<String> a = new ArrayList<String>();
				ArrayList<String> b = new ArrayList<String>();
				ArrayList<String> c = new ArrayList<String>();
				a.add("a"); a.add("b"); a.add("c");
				b.add("a"); b.add("b"); b.add("c");
				c.add("a"); c.add("b"); c.add("c");
				
				pat_VA.loadAppts(a,b,c);
			}
			
			
			if (event.getSource() == RegistrationBase.b6){
				//INSERT CODE HERE
				try {
					ArrayList<ArrayList<String>> result = tc.registerPatient(tc.activePatient);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateStart(loginS);
			}
			if (event.getSource() == reg_PI.save){
				System.out.println("PI Save clicked.");
				if (tc.activePatient == null)
					tc.activePatient = new Patient();
				tc.activePatient.ssn = reg_PI.ssnTextField.getText();
				tc.activePatient.birthdate = reg_PI.birthDateTextField.getText();
				tc.activePatient.lastName = reg_PI.lastNameTextField.getText();
				tc.activePatient.firstName = reg_PI.firstNameTextField.getText();
				tc.activePatient.ethnicity = reg_PI.raceTextField.getText();
				//sex
				if(reg_PI.maleCheck.isSelected()){
					tc.activePatient.sex="M";
				}
				else
					tc.activePatient.sex="F";
			}
			if (event.getSource() == reg_LI.save){
				System.out.println("LI Save clicked.");
				if (!reg_LI.passwordTF.getText().equals(reg_LI.repeatTF.getText())){
					JOptionPane.showMessageDialog(null,
							"Passwords do not match. Re-enter.",
							"Password Mismatch",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				tc.activePatient.userName = reg_LI.userNameTF.getText();
				tc.activePatient.password = reg_LI.passwordTF.getText();
				//sex

			}

			if (event.getSource() == sendAlert.updateButton) {
				tc.activePatient = new Patient();
				tc.activePatient.firstName = sendAlert.textFieldFName.getText();
				tc.activePatient.lastName = sendAlert.textFieldLName.getText();
				tc.activePatient.healthCondition = sendAlert.textConcern.getText();
				try {
					String response = tc.sendAlert(tc.activePatient);
					// System.out.println(tc.activePatient.severity);
					// tc.activePatient now contains the object populated with database response
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendAlert.concernLabel.setText("Concern: Recorded!");
				if (tc.activePatient.severity < 7) {
					JOptionPane.showMessageDialog(null, "Your concerns have been registered.\nYou will be contacted shortly.");
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Alert sent\nSeek immediate medical attention.",
							"High severity warning",
							JOptionPane.WARNING_MESSAGE);
				}
				/*
				PAT_Alert alertWindow = new PAT_Alert(new Bridge(), tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName), tc.activePatient.healthCondition);
				alertWindow.setSize(700,500);
				alertWindow.setVisible(true);
				 */


			}

			if(event.getSource() == pat_HCU.btnSearch) //this is just for health condition and Allergies update
			{
				//somePatient.healthCondition = pat_HCU.textAreaMedicalHistory.getText();

				tc.activePatient = new Patient();
				tc.activePatient.firstName = pat_HCU.textFieldFName.getText();
				tc.activePatient.lastName = pat_HCU.textFieldLName.getText();
				try {
					tc.searchUpdateHealthConditions(tc.activePatient);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String nameLabel = "Name: ";
				String addressLabel = "Address: ";

				pat_HCU.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				pat_HCU.lblName.setText(nameLabel.concat(tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName)));
				pat_HCU.lblAddress.setText(addressLabel.concat("NULL"));

			}

			if (event.getSource() == reg_II.btnSave){
				String[] info = new String[3];
				//Insurance Name
				info[0] = reg_II.t1.getText();
				//Member Name
				info[1] = reg_II.t2.getText();
				//Insurance ID
				info[2] = reg_II.t3.getText();
				pat.setII(info);
			}
			if (event.getSource() == reg_CI.save){
				//??????????????????????????????
			}
			if (event.getSource() == reg_MH.save){
				String[] info = new String[2];
				info[0] = reg_MH.allergies.getText();
				info[1] = reg_MH.medHis.getText();
				pat.setMH(info);
			}
			if (event.getSource() == H_tab2.search) {
				Patient p = new Patient();
				p.firstName = H_tab2.textFieldFName.getText();
				p.lastName = H_tab2.textFieldLName.getText();
				try {
					tc.searchUpdateHealthConditions(p);
					tc.getLabRecords();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String idLabel = "ID: ";
				String labInfoLabel = "Lab Info: ";
				
				H_tab2.labInfoTextArea.setText(tc.activePatient.labTestResults);
				
				H_tab2.idNumber.setText(idLabel.concat(tc.activePatient.patientId));
				H_tab2.labInfo.setText(labInfoLabel);
				
				
				/*
				pat_HCU.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				pat_HCU.lblName.setText(nameLabel.concat(tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName)));
				pat_HCU.lblAddress.setText(addressLabel.concat("NULL"));
				*/
			}
			if (event.getSource() == H_tab2.search || event.getSource() == H_tab1.search) {
				Patient p = new Patient();
				if (event.getSource() == H_tab2.search)
				{
					p.firstName = H_tab2.textFieldFName.getText();
					p.lastName = H_tab2.textFieldLName.getText();
				}
				else
				{
					p.firstName = H_tab1.textFieldFName.getText();
					p.lastName = H_tab1.textFieldLName.getText();
				}
				try {
					tc.searchUpdateHealthConditions(p);
					tc.getLabRecords();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String idLabel = "ID: ";
				String labInfoLabel = "Lab Info: ";
				
				if (event.getSource() == H_tab2.search )
				{
					H_tab2.labInfoTextArea.setText(tc.activePatient.labTestResults);
					
					H_tab2.idNumber.setText(idLabel.concat(tc.activePatient.patientId));
					H_tab2.labInfo.setText(labInfoLabel);
					H_tab2.textConcern.setText(tc.activePatient.healthCondition);
				}
				else
				{
					try {
						tc.getPrescriptionHistory();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					H_tab1.labInfoTextArea.setText(tc.activePatient.labTestResults);
					H_tab1.idNumber.setText(idLabel.concat(tc.activePatient.patientId));
					H_tab1.labInfo.setText(labInfoLabel);
					H_tab1.textConcern.setText(tc.activePatient.healthCondition);
					H_tab1.e_prescribe.setText(tc.activePatient.ePrescription);
					
				}
				
				/*
				pat_HCU.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				pat_HCU.lblName.setText(nameLabel.concat(tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName)));
				pat_HCU.lblAddress.setText(addressLabel.concat("NULL"));
				*/
			}
			if (event.getSource() == H_tab2.updateButton) {
				tc.activePatient.ePrescription = H_tab2.e_prescribe.getText();
				tc.activePatient.healthCondition = H_tab2.textConcern.getText();
				
				
				try {
					tc.sendAlert(tc.activePatient);
					tc.ePrescribe(tc.activePatient);
					JOptionPane.showMessageDialog(null, "Patient medical records have been updated successfully.");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(event.getSource() == H_tab2.print){
				if(H_tab2.e_prescribe.getText() != null){
					Prescription.printPrescription(H_tab2.e_prescribe.getText());
				}
				
			}
			if (event.getSource() == hspGenStats.genStats){      
				System.out.println("got here");
				hspGenStats.add(hsp)
				/*for(int i=0; i<hspGenStats.statistics.length;i++){
					hspGenStats.chart.add(new BarChartDemo("Patient Statistics", hspGenStats.statistics[i]+" Statistics", hspGenStats.statistics[i]));
					hspGenStats.chart.get(i).pack();    
					System.out.println(i);
					RefineryUtilities.centerFrameOnScreen(hspGenStats.chart.get(i) );        
					hspGenStats.chart.get(i).setVisible( true );
				*/
					/*Scanner nextStats = new Scanner(System.in);
			     if(nextStats.nextInt() != 1){
			      break;
			     }
					 */
				BarChartDemo a = new BarChartDemo("Patient Statistics", hspGenStats.statistics[0]+" Statistics", hspGenStats.statistics[0]);
				hspGenStats.chartPanel.add(a.chartPanel);
				hspGenStats.revalidate();
				hspGenStats.repaint();
			
				for(int i=0; i<hspGenStats.buttons.length; i++){
					hspGenStats.add(hspGenStats.buttons[i]);
					hspGenStats.buttons[i].setVisible(true);
				}
			}
			if (event.getSource() == lab_rec.view || event.getSource() == lab_rec.save) {
				
				Patient p = new Patient();
				String name[] = lab_rec.name.getText().split(" ");
				p.firstName = name[0];
				p.lastName = name[1];
				
				p.labTestID = lab_rec.testIdent.getText();
				
				
				try {
					tc.searchUpdateHealthConditions(p);
					tc.getLabRecords();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lab_rec.pID.setText(tc.activePatient.patientId);
				lab_rec.testIdent.setText(tc.activePatient.labTestID);
				if (event.getSource() == lab_rec.view)
				{
					if (tc.activePatient.labTestResults == null)
						lab_rec.LabInfo.setText("No lab records exist.");
					else
						lab_rec.LabInfo.setText(tc.activePatient.labTestResults);
				}
				
				/*
				pat_HCU.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				pat_HCU.lblName.setText(nameLabel.concat(tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName)));
				pat_HCU.lblAddress.setText(addressLabel.concat("NULL"));
				*/
			}
			if (event.getSource() == lab_rec.save) {
				tc.activePatient.labTestResults = lab_rec.LabInfo.getText();
				try {
					tc.addLabRecord(tc.activePatient);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*
				pat_HCU.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				pat_HCU.lblName.setText(nameLabel.concat(tc.activePatient.firstName.concat(" ").concat(tc.activePatient.lastName)));
				pat_HCU.lblAddress.setText(addressLabel.concat("NULL"));
				*/
				
			}
			if (event.getSource() == nurse_panel.btnSearch)
			{
				Patient p = new Patient();
				p.firstName = nurse_panel.textFieldFName.getText();
				p.lastName = nurse_panel.textFieldLName.getText();

				try {
					tc.searchUpdateHealthConditions(p);
					tc.getLabRecords();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String lblName = "Name: ";
				String lblAddress = "PatientID: ";
				
				nurse_panel.lblName.setText(lblName + tc.activePatient.firstName + " " + tc.activePatient.lastName);
				nurse_panel.lblAddress.setText(lblAddress + tc.activePatient.patientId);
				
				if (tc.activePatient.allergies != null && tc.activePatient.allergies.length() > 0)
					nurse_panel.textAreaAllergies.setText(tc.activePatient.allergies);
				else
					nurse_panel.textAreaAllergies.setText("No allergies");
				
				if (tc.activePatient.healthCondition != null && tc.activePatient.healthCondition.length() > 0)
					nurse_panel.medicalHistoryDisplay.setText(tc.activePatient.healthCondition);
				else
					nurse_panel.medicalHistoryDisplay.setText("No medical history to show.");
				
			}
			if (event.getSource() == nurse_panel.updateButton)
			{
				tc.activePatient.healthCondition = nurse_panel.textAreaMedicalHistory.getText();
				tc.activePatient.allergies = nurse_panel.textAreaAllergies2.getText();
				
				try {
					tc.updHealthCondition();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (event.getSource() == pharmacist_panel.search)
			{
				Patient p = new Patient();
				tc.activePatient = p;
				tc.activePatient.firstName = pharmacist_panel.textFieldFName.getText();
				tc.activePatient.lastName = pharmacist_panel.textFieldLName.getText();
							
				try {
					tc.searchUpdateHealthConditions(p);
					tc.getPrescriptionHistory();
					tc.getLabHistory();
					tc.getDoctor();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String st1 = "ID: ", st2 = "Lab Info: ", st3 = "Doctor Name: ";
				
				pharmacist_panel.idNumber.setText(st1 + tc.activePatient.patientId);
				pharmacist_panel.labInfo.setText(st2 + tc.activePatient.labName);
				pharmacist_panel.drInfo.setText(st3 + tc.activePatient.doctorName);
				pharmacist_panel.e_prescribe.setText(tc.activePatient.ePrescription);
			}
		}
		void switch1(JPanel base, JPanel remove, JPanel add){
			base.remove(remove);
			add.setSize(remove.getSize());
			add.setBounds(remove.getBounds());
			base.add(add);
			base.revalidate();
			base.repaint();
			//base.pack();
		}
	}

}

