package DoctorStuff;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class T3_CP extends JPanel {
	public JTextField currentPass;
	public JTextField newPass1;
	public JTextField newPass2;
	public JButton btnSubmit;
	/**
	 * Create the panel.
	 */
	public T3_CP(ActionListener b) {
		setLayout(null);
		setSize(275,200);
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(10, 41, 104, 14);
		add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(10, 66, 104, 14);
		add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(10, 91, 104, 14);
		add(lblConfirmPassword);
		
		currentPass = new JTextField();
		currentPass.setBounds(124, 38, 132, 20);
		add(currentPass);
		currentPass.setColumns(10);
		
		newPass1 = new JTextField();
		newPass1.setColumns(10);
		newPass1.setBounds(124, 63, 132, 20);
		add(newPass1);
		
		newPass2 = new JTextField();
		newPass2.setColumns(10);
		newPass2.setBounds(124, 88, 132, 20);
		add(newPass2);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(77, 147, 89, 23);
		add(btnSubmit);
		btnSubmit.addActionListener(b);

	}
}
