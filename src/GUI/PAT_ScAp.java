package phase1;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PAT_ScAp extends JPanel {

	/**
	 * PATIENT SCHEDULE APPOINTMENT JPANEL
	 */
	public PAT_ScAp() {
		setLayout(null);
		setSize(343,210);
		
		JLabel lblScheduleAppt = new JLabel("Schedule Appt");
		lblScheduleAppt.setBounds(131, 11, 92, 14);
		add(lblScheduleAppt);
	}

}
