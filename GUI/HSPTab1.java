package GUI;

import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HSPTab1 extends JPanel {


	
	public JTextField textFieldFName;
	public JTextField textFieldLName;
	public JTextField SearchInfo;
	public TextArea textConcern;
	public JLabel concernLabel;
	public JTextField idNumber;
	public JLabel eprescribeLable;
	public TextArea e_prescribe;
	public JButton search;
	public JButton updateButton;
	public JButton cancel;
	
	//public JComboBox healthRankDrop;

	/**
	 * Create the panel.
	 */
	
	//layout is not completed
	public HSPTab1(ActionListener b) {
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
	
	search = new JButton("Search"); 
	search.setBounds(98, 120, 86, 20);
	add(search );
	search.addActionListener(b);
	
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
	
	updateButton = new JButton("Update"); 
	updateButton.setBounds(400, 460, 90, 23);
	add(updateButton );
	updateButton.addActionListener(b);
	
	updateButton = new JButton("Cancel"); 
	updateButton.setBounds(300, 460, 90, 23);
	add(updateButton );
	updateButton.addActionListener(b);

}
}
