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
	 * Create the panel.
	 */
	public PAT_Alert(ActionListener b, String pName, String pCond) {
		
		setLayout(null);
		setSize(300,300);
		
		this.patientName = new JLabel(pName);
		this.patientName.setBounds(95, 11, 128, 14);
		add(this.patientName);
		
		this.condition = new JLabel(pCond);
		this.condition.setBounds(10, 39, 118, 14);
		add(this.condition);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(245, 259, 89, 23);
		add(closeButton );
		closeButton.addActionListener(b);
	}
}