package GUI;

import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pharmacist_Panel extends JPanel {
	/**
	 * Create the panel.
	 */
	
	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public JTextField SearchInfo;
	public TextArea textConcern;
	public JLabel concernLabel;
	public JLabel idNumber;
	public JLabel labInfo;
	public JLabel drInfo;
	public TextArea labInfoTextArea;
	public JLabel eprescribeLable;
	public TextArea e_prescribe;
	public JButton search;
	public JButton updateButton;
	public JButton cancel;
	public JButton print;
	
	
	
	@SuppressWarnings("unchecked")
	public Pharmacist_Panel(ActionListener b) {

		setLayout(null);
		setSize(680,653);
		
		
		setLayout(null);
		setSize(500,300);
		
		
	JLabel lblFirstName = new JLabel("First name:");
	lblFirstName.setBounds(30, 59, 65, 14);
	add(lblFirstName);
	
	textFieldFName = new JTextField();
	textFieldFName.setBounds(98, 56, 86, 20);
	add(textFieldFName);
	textFieldFName.setColumns(10);
	
	JLabel lblLastName = new JLabel("Last name:");
	lblLastName.setBounds(30, 90, 65, 14);
	add(lblLastName);
	
	textFieldLName = new JTextField();
	textFieldLName.setColumns(10);
	textFieldLName.setBounds(98, 87, 86, 20);
	add(textFieldLName);
	
	
	idNumber= new JLabel("ID: ");
	idNumber.setBounds(200, 59, 140, 14);
	add(idNumber);
	
	labInfo= new JLabel("Lab Info: ");
	labInfo.setBounds(200, 80, 200, 20);
	add(labInfo);
	
	
	drInfo= new JLabel("Doctor Name: ");
	drInfo.setBounds(200, 100, 245, 20);
	add(drInfo);
	
	search = new JButton("Search"); 
	search.setBounds(98, 120, 86, 20);
	add(search );
	search.addActionListener(b);

	eprescribeLable = new JLabel("Prescription Details:");
	eprescribeLable.setBounds(30, 160, 180, 20);
	add(eprescribeLable);
	
	e_prescribe = new TextArea();
	e_prescribe.setBounds(30, 190, 300, 100);
	add(e_prescribe);

	updateButton = new JButton("Cancel"); 
	updateButton.setBounds(300, 460, 90, 23);
	add(updateButton );
	updateButton.addActionListener(b);
	}
}