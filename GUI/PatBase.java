package Pat;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PatBase extends JPanel {
	public JButton btnVA, btnSAl, btnSApp, btnHCU, btnLogout;
	public JPanel panel;
	/**
	 * Create the panel.
	 */
	public PatBase(ActionListener e) {
		setLayout(null);
		setSize(700,400);
		setBounds(0,0,700,400);
		
		btnVA = new JButton("<html>Manage<br/>Appointments</html");
		btnVA.setBounds(10, 73, 141, 30);
		btnVA.addActionListener(e);
		add(btnVA);
		
		btnSApp = new JButton("<html>Schedule<br/>Appointment</html");
		btnSApp.setBounds(10, 114, 141, 37);
		btnSApp.addActionListener(e);
		add(btnSApp);
				
		btnSAl = new JButton("Send Alert");
		btnSAl.setBounds(10, 162, 141, 23);
		btnSAl.addActionListener(e);
		add(btnSAl);
				
		btnHCU = new JButton("<html>Health Condition<br/>Update</html>");
		btnHCU.setBounds(10, 196, 141, 48);
		btnHCU.addActionListener(e);
		add(btnHCU);
		
				
		panel = new JPanel();
		panel.setBounds(178, 10, 412, 378);
		panel.setLayout(null);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfoAboutRegistration = new JLabel("INFO ABOUT PATIENT");
		panel.add(lblInfoAboutRegistration, BorderLayout.CENTER);
		
		btnLogout = new JButton("LogOut");
		btnLogout.setBounds(10, 365, 89, 23);
		btnLogout.addActionListener(e);
		add(btnLogout);
								
	}
}
