package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TestP1 extends JPanel {

	/**
	 * This panel is for testing the first set of instructions required
	 */
	public JButton savebutton,ScheduleAppBtn,UpdateHealthCondBtn, sendAlertBtn, docPanBtn, labStaffBtn;
	
	public TestP1(ActionListener e) {
		setLayout(null);
		setSize(500,300);
		
		JLabel lblClickOnOne = new JLabel("Click on one of the below buttons to test said feature");
		lblClickOnOne.setBounds(84, 11, 306, 14);
		add(lblClickOnOne);
		
		savebutton = new JButton("Registration");
		savebutton.setBounds(39, 36, 158, 23);
		savebutton.addActionListener(e);
		add(savebutton);
		
		ScheduleAppBtn = new JButton("Schedule Appointments");
		ScheduleAppBtn.setBounds(39, 96, 174, 23);
		ScheduleAppBtn.addActionListener(e);
		add(ScheduleAppBtn);
		
		UpdateHealthCondBtn = new JButton("Update Health Conditions");
		UpdateHealthCondBtn.setBounds(39, 156, 174, 23);
		UpdateHealthCondBtn.addActionListener(e);
		add(UpdateHealthCondBtn);
		
		sendAlertBtn = new JButton("Send Alert");
		sendAlertBtn.setBounds(39, 216, 174, 23);
		sendAlertBtn.addActionListener(e);
		add(sendAlertBtn);
		
		docPanBtn = new JButton("Doctor Panel");
		docPanBtn.setBounds(39, 276, 174, 23);
		docPanBtn.addActionListener(e);
		add(docPanBtn);
		
		labStaffBtn = new JButton("Lab Information");
		labStaffBtn.setBounds(39, 326, 174, 23);
		labStaffBtn.addActionListener(e);
		add(labStaffBtn);

	}

}
