package GUI;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * Second tab for the doctor panel
 * */

public class HSPTab2 extends JPanel {

	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public JTextField SearchInfo;
	public TextArea textConcern;
	public JLabel concernLabel;
	public JLabel idNumber;
	public JLabel labInfo;
	public TextArea labInfoTextArea;
	public JLabel eprescribeLable;
	public TextArea e_prescribe;
	public JButton search;
	public JButton updateButton;
	public JButton cancel;
	public JButton print;
	//public JComboBox healthRankDrop;

	/**
	 * Create the panel.
	 */
	
	//layout is not completed
	public HSPTab2(ActionListener e) {
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
	
	
	idNumber= new JLabel("ID: ???");
	idNumber.setBounds(200, 59, 65, 14);
	add(idNumber);
	
	labInfo= new JLabel("Lab Info: ???");
	labInfo.setBounds(200, 80, 100, 20);
	add(labInfo);
	
	labInfoTextArea = new TextArea();
	labInfoTextArea.setBounds(200, 100, 290, 40);
	add(labInfoTextArea);
	
	search = new JButton("Search"); 
	search.setBounds(98, 120, 86, 20);
	search.addActionListener(e);
	add(search);
	
	
	print = new JButton("Print"); 
	print.setBounds(360, 270, 86, 20);
	print.addActionListener(e);
	add(print);
	
	
	eprescribeLable = new JLabel("E Prescribe:");
	eprescribeLable.setBounds(30, 160, 100, 20);
	add(eprescribeLable);
	
	e_prescribe = new TextArea();
	e_prescribe.setBounds(30, 190, 300, 100);
	add(e_prescribe);
	
	concernLabel = new JLabel("Update health condition or concern:");
	concernLabel.setBounds(30, 300, 250, 20);
	add(concernLabel);
	
	textConcern = new TextArea();
	textConcern.setBounds(30, 340, 300, 100);
	add(textConcern);
	
	updateButton = new JButton("Cancel"); 
	updateButton.setBounds(400, 460, 90, 23);
	updateButton.addActionListener(e);
	add(updateButton );
	
	
	updateButton = new JButton("Update"); 
	updateButton.setBounds(300, 460, 90, 23);
	add(updateButton );
	updateButton.addActionListener(e);

}

}
