package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reg_LI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Registration Login Information panel.
	 */
	public Reg_LI() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 36, 144, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 80, 144, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 134, 144, 20);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(112, 176, 89, 23);
		add(btnNewButton);
	}

}
