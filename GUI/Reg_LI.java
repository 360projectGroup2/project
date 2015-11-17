package GUI;


import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reg_LI extends JPanel {
	public JTextField userNameTF;
	public JTextField passwordTF;
	public JTextField repeatTF;
	
	public JButton save;

	/**
	 * Create the panel.
	 */
	public Reg_LI(ActionListener b) {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblNewLabel = new JLabel("Login Information");
		lblNewLabel.setBounds(112, 11, 137, 14);
		add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 39, 85, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 83, 85, 14);
		add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Reenter Password");
		lblReenterPassword.setBounds(10, 137, 111, 14);
		add(lblReenterPassword);
		
		userNameTF = new JTextField();
		userNameTF.setColumns(10);
		userNameTF.setBounds(136, 36, 144, 20);
		add(userNameTF);
		
		passwordTF = new JTextField();
		passwordTF.setColumns(10);
		passwordTF.setBounds(136, 80, 144, 20);
		add(passwordTF);
		
		repeatTF = new JTextField();
		repeatTF.setColumns(10);
		repeatTF.setBounds(136, 134, 144, 20);
		add(repeatTF);
		
		save = new JButton("Save");
		save.setBounds(112, 176, 89, 23);
		save.addActionListener(b);
		add(save);
	}

}
