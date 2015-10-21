package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class HSPTab2 extends JPanel {

	/**
	 * Create the panel.
	 */
	JMenu patMenu;
	JMenuItem[] patList;
	String[] patInfo;
	JTextArea appt;
	ActionListener pass;
	JButton edit;
	
	public HSPTab2(ActionListener e) {
		setLayout(null);
		pass = e;
		
		patMenu = new JMenu("New menu");
		patMenu.setBounds(10, 28, 107, 22);
		patMenu.addActionListener(e);
		add(patMenu);
		
		appt = new JTextArea();
		appt.setBounds(214, 40, 147, 159);
		add(appt);
		
		edit = new JButton("Edit");
		edit.setBounds(390, 122, 89, 23);
		add(edit);

	}
	
	public void setPatients(JMenuItem[] a, String[] b){
		patList = a;
		for(int i=0; i<patList.length; i++){
			patList[i].addActionListener(pass);
			patMenu.add(patList[i]);
		}
		patInfo=b;
	}

}
