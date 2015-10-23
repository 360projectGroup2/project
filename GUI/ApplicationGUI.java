package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Patient;
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
	TestP1 start;
	//patient schedule appt
	PAT_ScAp pat_ScAp;
	//patient update health condition
	PAT_HCU pat_HCU;
	SendAlert sendAlert;
	Patient pat;

	TestPatient_Registration1 RegistrationBase;
	
	//Controller test_app;
	Reg_PI reg_PI;
	Reg_II reg_II;
	Reg_CI reg_CI;
	Reg_MH reg_MH;
	Reg_LI reg_LI;
	
	//add in the tabs
	HSPBase h_Base;
	
	HSPTab1 H_tab1;
	HSPTab2 H_tab2;
	HSPTab3 H_tab3;
	HSPTab4 H_tab4;
	


	/**
	 * Launch the application.
	 */

	public ApplicationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		Event_Handler e = new  Event_Handler();
		Bridge b = new Bridge();

		start = new TestP1(e);
		
		//test_app = new Controller(500,500);
		//pat_SeAl = new PAT_SeAl();
		pat_ScAp = new PAT_ScAp(500,500);
		pat_HCU = new PAT_HCU(b);
		sendAlert = new SendAlert(b);

		RegistrationBase = new TestPatient_Registration1(e, b);
		reg_PI = new Reg_PI(b);
		reg_II = new Reg_II(b);
		reg_LI = new Reg_LI(b);
		reg_CI = new Reg_CI(b);
		reg_MH = new Reg_MH(b);
		
	
		H_tab1 = new HSPTab1(b);
		H_tab2 = new HSPTab2(e);
		H_tab3 = new HSPTab3(b);
		H_tab4 = new HSPTab4();
		
		h_Base = new HSPBase(H_tab1, H_tab2, H_tab3, H_tab4, -1);
		

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

		setContentPane(start);
	}
	public void display(){
		setSize(700,500);
		//pack();
		setVisible(true);
	}

	//TAKES CARE OF CHANGING FROM ONE JPANEL TO ANOTHER
	public class Event_Handler implements ActionListener{
		public void actionPerformed (ActionEvent event){

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
			
			if(event.getSource() == start.sendAlertBtn){
				updateStart(sendAlert);
			}
			
			if(event.getSource() == start.docPanBtn){
				updateStart(h_Base);
				setSize(700,1000);
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

		}

		void update(JPanel base, JPanel add){
			base.removeAll();
			base.add(add);
			base.revalidate();
			base.repaint();
			//base.pack();
		}
		void updateStart(JPanel base){
			setContentPane(base);
			revalidate();
			repaint();
		}


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
	private TableController tc = new TableController();
	public class Bridge implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if (event.getSource() == RegistrationBase.b6){
				//INSERT CODE HERE
				try {
					ArrayList<ArrayList<String>> result = tc.registerPatient(tc.activePatient);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (event.getSource() == reg_PI.save){
				if (tc.activePatient == null)
					tc.activePatient = new Patient();
				tc.activePatient.ssn = reg_PI.ssnTextField.getText();
				tc.activePatient.birthdate = reg_PI.birthDateTextField.getText();
				tc.activePatient.lastName = reg_PI.lastNameTextField.getText();
				tc.activePatient.firstName = reg_PI.firstNameTextField.getText();
				//sex
				if(reg_PI.maleCheck.isSelected()){
					tc.activePatient.sex="M";
				}
				else
					tc.activePatient.sex="F";
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
			if (event.getSource() == reg_MH.save){
				String[] info = new String[2];
				info[0] = reg_MH.allergies.getText();
				info[1] = reg_MH.medHis.getText();
				pat.setMH(info);
			}
		}
	}

}
