package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PAT_Alert extends JPanel {
	public JLabel patientName, condition;
	public JButton closeButton;

	/**
	 * Create an alert notification window.
	 * Parameters:
	 * ActionListener b - Listener for the close button
	 * String pName - Full name of patient
	 * String pCond - The condition that triggered the alert
	 */
	public PAT_Alert(ActionListener b, String pName, String pCond) {
		
		setLayout(null);
		setSize(300,300);
		
		String nameString = "Patient: " + pName;
		this.patientName = new JLabel(nameString);
		this.patientName.setBounds(95, 11, 128, 14);
		add(this.patientName);
		
		String condString = "Condition: " + pCond;
		this.condition = new JLabel(condString);
		this.condition.setBounds(10, 39, 118, 14);
		add(this.condition);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(245, 259, 89, 23);
		add(closeButton );
		closeButton.addActionListener(b);
	}
}