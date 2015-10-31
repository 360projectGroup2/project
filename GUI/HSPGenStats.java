package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jfree.ui.RefineryUtilities;

public class HSPGenStats extends JPanel implements ActionListener{

	
	public JButton genStats;
	public JLabel generateStats;
		
	public HSPGenStats(ActionListener b){
		
		generateStats = new JLabel("Press 1 to generate next statistics");
		generateStats.setBounds(81, 84, 277, 14);
		this.add(generateStats);	
		
		genStats = new JButton("Generate Statistics");
		genStats.setBounds(121,124,300,24);
		genStats.addActionListener(b);
		this.add(genStats);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == "genStats"){
			String[] statistics = {"healthOutcomes","trackAdmissions","PatientType", "Age", "Gender", "Ethnicity"};
			  
			for(int i=0; i<statistics.length;i++){
				BarChartDemo chart = new BarChartDemo("Patient Statistics", statistics[i]+" Statistics", statistics[i]);
				chart.pack( );        
				RefineryUtilities.centerFrameOnScreen( chart );        
				chart.setVisible( true );
			  
				Scanner nextStats = new Scanner(System.in);
				if(nextStats.nextInt() != 1){
					break;
				}
			}
		}
	}
}
