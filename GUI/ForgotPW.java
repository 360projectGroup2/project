package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ForgotPW extends JPanel {
	public JTextField secQ;
	public JTextField ans;
	public JTextField pass1;
	public JTextField pass2;
	public JButton btnSubmit;

	/**
	 * Create the panel.
	 */
	public ForgotPW(ActionListener e, ActionListener b) {
		setLayout(null);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setBounds(179, 11, 120, 14);
		add(lblForgotPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setBounds(35, 73, 131, 14);
		add(lblSecurityQuestion);
		
		secQ = new JTextField();
		secQ.setBounds(213, 70, 210, 20);
		add(secQ);
		secQ.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(45, 98, 93, 14);
		add(lblAnswer);
		
		ans = new JTextField();
		ans.setColumns(10);
		ans.setBounds(213, 95, 210, 20);
		add(ans);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(45, 173, 93, 14);
		add(lblNewPassword);
		
		JLabel lblReenterNewPassword = new JLabel("Reenter New Password:");
		lblReenterNewPassword.setBounds(35, 198, 131, 14);
		add(lblReenterNewPassword);
		
		pass1 = new JTextField();
		pass1.setColumns(10);
		pass1.setBounds(213, 167, 210, 20);
		add(pass1);
		
		pass2 = new JTextField();
		pass2.setColumns(10);
		pass2.setBounds(213, 195, 210, 20);
		add(pass2);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(169, 266, 89, 23);
		add(btnSubmit);
		btnSubmit.addActionListener(e);
		btnSubmit.addActionListener(b);

	}
}
