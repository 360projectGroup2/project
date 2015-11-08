package Pat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class PAT_VA extends JPanel {
	public JButton btnViewAppointments;
	public ArrayList<JRadioButton> buttons;
	public ButtonGroup b2;
	public inHouse action;
	public ArrayList<String> docN, dates;
	public JLabel label1, label2, label3;
	/**
	 * Create the panel.
	 */
	public PAT_VA(ActionListener e, ActionListener b) {
		setLayout(null);
		b2 = new ButtonGroup();
		buttons = new ArrayList<JRadioButton>();
		action = new inHouse();

		JLabel lblAppt = new JLabel("Your Appointments");
		lblAppt.setBounds(178, 11, 101, 14);
		add(lblAppt);

		btnViewAppointments = new JButton("Load Appointments");
		btnViewAppointments.setBounds(161, 36, 125, 23);
		add(btnViewAppointments);
		btnViewAppointments.addActionListener(b);

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
		System.out.println(label1.isDisplayable());
		//now show them
		revalidate();
		repaint();
		
	}
	public class inHouse implements ActionListener{
		public void actionPerformed (ActionEvent event){
			for(int i=0; i<buttons.size(); i++){
				if(event.getSource() == buttons.get(i)){
					label1.setText(buttons.get(i).getText());
					label2.setText(docN.get(i));
					label3.setText(dates.get(i));
				}
			}
		}
	}
}
