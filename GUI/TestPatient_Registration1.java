package GUI;
import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class TestPatient_Registration1 extends JPanel{

	/**
	 * Create the panel.
	 */
	public JButton b1, b2, b3, b4, b5, b6;
	public JPanel panel;
	public TestPatient_Registration1(ActionListener e, ActionListener b) {
		setLayout(null);
		
		b1= new JButton("Personal Info");
		b1.setBounds(36, 11, 122, 23);
		b1.addActionListener(e);
		add(b1);
		
		panel = new JPanel();
		panel.setBounds(198, 41, 372, 290);
		panel.setSize(343, 210);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfoAboutRegistration = new JLabel("INFO ABOUT REGISTRATION");
		panel.add(lblInfoAboutRegistration);
		
		b2 = new JButton("Contact Info");
		b2.setBounds(36, 63, 122, 23);
		b2.addActionListener(e);
		add(b2);
		
		b3= new JButton("Insurance Info");
		b3.setBounds(36, 119, 122, 23);
		b3.addActionListener(e);
		add(b3);
		
		b4 = new JButton("Medical History");
		b4.setBounds(36, 187, 122, 23);
		b4.addActionListener(e);
		add(b4);


		b5 = new JButton("Login Info Setup");
		b5.setBounds(36, 243, 122, 23);
		b5.addActionListener(e);
		add(b5);
		
		
		b6 = new JButton("Submit Information");
		b6.setBounds(305, 325, 164, 23);
		b6.addActionListener(b);
		add(b6);
		
		
	}

}
