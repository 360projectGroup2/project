package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PAT_VA extends JPanel {
	public JButton btnViewAppointments, btnEdit, btnSave;
	public ArrayList<JRadioButton> buttons;
	public ButtonGroup b2;
	public inHouse action;
	public ArrayList<String> docN, dates;
	public JLabel label1, label2, label3;
	public JTextField txtBox1, txtBox2, txtBox3; 
	/**
	 * Create the panel.
	 */
	public PAT_VA(ActionListener e, ActionListener b) {
		setLayout(null);
		b2 = new ButtonGroup();
		buttons = new ArrayList<JRadioButton>();
		action = new inHouse();

		JLabel lblAppt = new JLabel("Your Appointments");
		lblAppt.setBounds(178, 11, 125, 14);
		add(lblAppt);

		btnViewAppointments = new JButton("Load Appointments");
		btnViewAppointments.setBounds(161, 36, 125, 23);
		add(btnViewAppointments);
		btnViewAppointments.addActionListener(e);

		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(109, 266, 79, 23);
		btnEdit.addActionListener(action);
		//add(btnEdit);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(262, 266, 79, 23);
		btnSave.addActionListener(b);
		btnSave.addActionListener(action);
		//add(btnSave);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 80, 109, 23);
		//add(rdbtnNewRadioButton);

		label1 = new JLabel("New label");
		label1.setBounds(189, 112, 232, 14);
		//add(label1);

		label2 = new JLabel("New label");
		label2.setBounds(189, 137, 232, 14);
		//add(label2);

		label3 = new JLabel("New label");
		label3.setBounds(189, 163, 232, 14);
		//add(label3);
		
		txtBox1 = new JTextField();
		txtBox1.setBounds(189, 112, 232, 14);
		
		txtBox2 = new JTextField();
		txtBox2.setBounds(189, 137, 232, 14);

		txtBox3 = new JTextField();
		txtBox3.setBounds(189, 163, 232, 14);
	}

	public void loadAppts(ArrayList<String> a, ArrayList<String> b, ArrayList<String> c){
		System.out.println("Test2");
		docN = b;
		dates = c;

		for(int i=0; i<a.size(); i++){
			buttons.add(new JRadioButton(a.get(i)));
			buttons.get(i).setBounds(6,83+i*26, 109, 23);
			buttons.get(i).addActionListener(action);
			b2.add(buttons.get(i));
			add(buttons.get(i));
			
		}
		System.out.println("Test2");
		add(label1);
		add(label2);
		add(label3);
		add(btnEdit);
		add(btnSave);
		System.out.println(label1.isDisplayable());
		//now show them
		revalidate();
		repaint();
		
	}
	public class inHouse implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource()==btnEdit){
				add(txtBox1);
				txtBox1.setText(label1.getText());
				add(txtBox2);
				txtBox2.setText(label2.getText());
				add(txtBox3);
				txtBox3.setText(label3.getText());
				remove(label1);
				remove(label2);
				remove(label3);
				revalidate();
				repaint();
			}
			
			if(event.getSource()==btnSave&&txtBox1.isShowing()){
				remove(txtBox1);
				remove(txtBox2);
				remove(txtBox3);
				add(label1);
				label1.setText(txtBox1.getText());
				add(label2);
				label2.setText(txtBox2.getText());
				add(label3);
				label3.setText(txtBox3.getText());
				for(int i=0; i<buttons.size(); i++)
					if(buttons.get(i).isSelected()){
						buttons.get(i).setText(label1.getText());
						docN.set(i, label2.getText());
						dates.set(i, label3.getText());
					}
						
				revalidate();
				repaint();
			}
			for(int i=0; i<buttons.size(); i++){
				if(event.getSource() == buttons.get(i)){
					if(txtBox1.isShowing()){
						remove(txtBox1);
						remove(txtBox2);
						remove(txtBox3);
						add(label1);
						add(label2);
						add(label3);
						revalidate();
						repaint();
					}
					label1.setText(buttons.get(i).getText());
					label2.setText(docN.get(i));
					label3.setText(dates.get(i));
				}
			}
			
		}
	}
}
