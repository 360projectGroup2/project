/////////////////////////////////////////////
//
//				IS NOT BEING USED 
//
/////////////////////////////////////////////



package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class HSPTab3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public JLabel lblUsername, lblStatus, lblEmail;
	public JButton chngPass, updateSec;
	
	
	public HSPTab3(ActionListener b) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(31, 67, 225, 31);
		panel_1.add(lblUsername);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(31, 135, 225, 31);
		panel_1.add(lblStatus);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 199, 225, 31);
		panel_1.add(lblEmail);
		
		chngPass = new JButton("Change Password");
		updateSec = new JButton("Update Security Question");
		
		JPanel inner = new JPanel();
		add(inner, BorderLayout.WEST);
		inner.setLayout(new GridLayout(4, 1, 0, 0));
		JPanel i1 = new JPanel();
		JPanel i2 = new JPanel();
		inner.add(i1);
		inner.add(chngPass);
		inner.add(updateSec);
		inner.add(i2);
		
	}
}
