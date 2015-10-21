package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reg_II extends JPanel {
	public JTextField t1;
	public JTextField t2;
	public JTextField t3;
	public JButton btnSave;

	/**
	 * Create the panel.
	 */
	public Reg_II(ActionListener b) {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblNewLabel = new JLabel("Insurance Information");
		lblNewLabel.setBounds(107, 11, 169, 14);
		add(lblNewLabel);
		
		JLabel lblInsuranceName = new JLabel("Insurance Name");
		lblInsuranceName.setBounds(10, 45, 124, 14);
		add(lblInsuranceName);
		
		JLabel lblMemberName = new JLabel("Member Name");
		lblMemberName.setBounds(10, 87, 124, 14);
		add(lblMemberName);
		
		JLabel lblInsuranceId = new JLabel("Insurance ID");
		lblInsuranceId.setBounds(10, 132, 124, 14);
		add(lblInsuranceId);
		
		t1 = new JTextField();
		t1.setBounds(180, 45, 112, 20);
		add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(180, 84, 112, 20);
		add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(180, 129, 112, 20);
		add(t3);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(123, 184, 89, 23);
		btnSave.addActionListener(b);
		add(btnSave);

	}

}
