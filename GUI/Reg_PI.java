package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Reg_PI extends JPanel {
	public JTextField ssnTextField;
	public JTextField birthDateTextField;
	public JTextField lastNameTextField;
	public JTextField firstNameTextField;
	public JRadioButton maleCheck, femaleCheck;
	public JButton save;
	public ButtonGroup sex;
	
	/**
	 * Create the panel.
	 */
	public Reg_PI(ActionListener b) {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setBounds(108, 11, 137, 14);
		add(lblNewLabel);
		
		JLabel lblFirstn = new JLabel("First Name");
		lblFirstn.setBounds(10, 36, 70, 14);
		add(lblFirstn);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(137, 33, 126, 20);
		add(firstNameTextField);
						
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 61, 70, 14);
		add(lblLastName);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(137, 58, 126, 20);
		add(lastNameTextField);

		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 86, 70, 14);
		add(lblBirthDate);
		
		birthDateTextField = new JTextField();
		birthDateTextField.setColumns(10);
		birthDateTextField.setBounds(137, 83, 126, 20);
		add(birthDateTextField);
		
		
				
		JLabel lblSocialSecurity = new JLabel("Soc Sec");
		lblSocialSecurity.setBounds(10, 111, 70, 14);
		add(lblSocialSecurity);
		
		ssnTextField = new JTextField();
		ssnTextField.setBounds(137, 108, 126, 20);
		add(ssnTextField);
		ssnTextField.setColumns(10);
		
		
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(10, 139, 70, 14);
		add(lblSex);
		
		save = new JButton("Save");
		save.setBounds(125, 176, 89, 23);
		save.addActionListener(b);
		add(save);
		sex = new ButtonGroup();
		maleCheck = new JRadioButton("Male");
		maleCheck.setBounds(100, 135, 70, 23);
		add(maleCheck);
		
		
		femaleCheck = new JRadioButton("Female");
		femaleCheck.setBounds(188, 135, 70, 23);
		add(femaleCheck);
		sex.add(maleCheck);
		sex.add(femaleCheck);
		
	}
}
