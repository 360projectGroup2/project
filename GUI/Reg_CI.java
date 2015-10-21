package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;

public class Reg_CI extends JPanel {
	public JTextField textField_0;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JButton btnSave;

	/**
	 * Create the panel.
	 */
	public Reg_CI(ActionListener b) {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblNewLabel = new JLabel("Contact Information");
		lblNewLabel.setBounds(110, 11, 120, 14);
		add(lblNewLabel);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 36, 120, 14);
		add(lblPhoneNumber);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 85, 120, 14);
		add(lblState);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(129, 60, 74, 14);
		add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 109, 120, 14);
		add(lblCity);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setBounds(10, 134, 74, 14);
		add(lblStreet);
		
		JLabel lblZipCode = new JLabel("ZIP Code:");
		lblZipCode.setBounds(10, 159, 74, 14);
		add(lblZipCode);
		
		textField_0 = new JTextField();
		textField_0.setBounds(212, 36, 74, 20);
		add(textField_0);
		textField_0.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(247, 82, 39, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 106, 199, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 131, 199, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 156, 74, 20);
		add(textField_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(114, 187, 89, 23);
		btnSave.addActionListener(b);
		add(btnSave);
		

	}
}
