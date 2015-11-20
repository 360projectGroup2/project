package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class HSP2_Base extends JPanel {

	/**
	 * Create the panel.
	 */
	public JButton btn1, btn2; 
	
	public HSP2_Base(ActionListener e) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What would you like to do today?");
		lblNewLabel.setBounds(216, 11, 304, 14);
		add(lblNewLabel);
		
		btn1 = new JButton("Generate Stats");
		btn1.setBounds(216, 71, 166, 23);
		btn1.addActionListener(e);
		add(btn1);
		
		btn2 = new JButton("New Parient Registration");
		btn2.setBounds(216, 119, 166, 23);
		btn2.addActionListener(e);
		add(btn2);
	}
}
