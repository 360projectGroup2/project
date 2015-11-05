package build1;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class TestStandardScreen extends JPanel {

	public JButton btnLogout;
	public JPanel panel, switchPanel, panel_2;
	public JLabel lblCompanyName, lblEmployeeId;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */


	/*	 * Create the frame.
	 */
	public TestStandardScreen(ActionListener e){
		setBounds(0, 0, 618, 563);
		setLayout(null);
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setBounds(0,0,618,50);
		panel.setLayout(null);
		
		lblCompanyName = new JLabel("Company Name / HSP Name");
		lblCompanyName.setBounds(244, 7, 175, 14);
		panel.add(lblCompanyName);
		
		lblEmployeeId = new JLabel("Employee ID and name || User name");
		lblEmployeeId.setBounds(7, 25, 245, 14);
		panel.add(lblEmployeeId);
		

		switchPanel = new JPanel();
		switchPanel.setBounds(0, 49, 618, 473);
		add(switchPanel);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);
		panel_2.setBounds(0,523,618,40);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(519, 11, 89, 23);
		btnLogout.addActionListener(e);
		panel_2.add(btnLogout);
		
		
	}
}
