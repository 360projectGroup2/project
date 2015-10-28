package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class T3_USQ extends JPanel {
	public JTextField currentPass;
	public JTextField question;
	public JTextField secQAns;
	public JButton btnSubmit;
	/**
	 * Create the panel.
	 */
	public T3_USQ(ActionListener b) {
		setLayout(null);
		setSize(275,200);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(10, 11, 103, 14);
		add(lblCurrentPassword);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(10, 46, 103, 14);
		add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(10, 78, 103, 14);
		add(lblAnswer);
		
		currentPass = new JTextField();
		currentPass.setBounds(114, 8, 111, 20);
		add(currentPass);
		currentPass.setColumns(10);
		
		question = new JTextField();
		question.setColumns(10);
		question.setBounds(114, 43, 111, 20);
		add(question);
		
		secQAns = new JTextField();
		secQAns.setColumns(10);
		secQAns.setBounds(114, 75, 111, 20);
		add(secQAns);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(67, 116, 89, 23);
		btnSubmit.addActionListener(b);
		add(btnSubmit);

	}

}
