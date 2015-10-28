package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

public class LoginS extends JPanel {

	public JPasswordField passField;
	public JTextField userField;
	public JButton btnLogin, btnExitApplication, btnRegister, btnForgotPassword;
	
	public LoginS(ActionListener e, ActionListener b){
			setBounds(100, 100, 450, 300);
			setLayout(null);


			passField = new JPasswordField();
			passField.setBounds(217, 139, 107, 20);
			add(passField);
			passField.getPassword();
			
			
			userField = new JTextField();
			userField.setBounds(217, 71, 107, 20);
			add(userField);
			userField.setColumns(10);

			btnLogin = new JButton("Login");
			btnLogin.setBounds(47, 181, 89, 23);
			add(btnLogin);
			btnLogin.addActionListener(e);
			btnLogin.addActionListener(b);

			btnExitApplication = new JButton("Exit Application");
			btnExitApplication.setBounds(257, 181, 119, 23);
			add(btnExitApplication);
			btnExitApplication.addActionListener(e);

			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(78, 142, 89, 14);
			add(lblPassword);
		
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setBounds(78, 74, 89, 14);
			add(lblUsername);

			btnRegister = new JButton("Register");
			btnRegister.setBounds(47, 227, 89, 23);
			add(btnRegister);
			btnRegister.addActionListener(e);

			btnForgotPassword = new JButton("Forgot Password?");
			btnForgotPassword.setBounds(257, 227, 119, 23);
			add(btnForgotPassword);
			btnForgotPassword.addActionListener(e);

		}
	}
