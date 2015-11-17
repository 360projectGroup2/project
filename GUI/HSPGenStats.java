package GUI;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;


import org.jfree.ui.RefineryUtilities;

public class HSPGenStats extends JPanel implements ActionListener{


	public JButton genStats;
	public JLabel generateStats;
	public ArrayList<BarChartDemo> chart;
	public String[] statistics = {"healthOutcomes","trackAdmissions","PatientType", "Age", "Gender", "Ethnicity"};
	public JRadioButton[] buttons;
	public ButtonGroup asdf;
	public JPanel chartPanel;


	public HSPGenStats(ActionListener b){
		setLayout(null);
		generateStats = new JLabel("Press 1 to generate next statistics");
		generateStats.setBounds(78, 9, 165, 14);
		this.add(generateStats); 

		genStats = new JButton("Generate Statistics");
		genStats.setBounds(248,5,123,23);
		genStats.addActionListener(b);
		genStats.addActionListener(this);
		this.add(genStats);
		
		chartPanel = new JPanel();
		chartPanel.setBounds(124, 53, 468, 410);
		add(chartPanel);

		buttons = new JRadioButton[6];
		asdf = new ButtonGroup();
		for(int i=0; i<buttons.length; i++){
			buttons[i]= new JRadioButton(statistics[i]);
			asdf.add(buttons[i]);
		}

		chart = new ArrayList<BarChartDemo>();
		for(int i=0; i<buttons.length; i++){
			buttons[i].setBounds(0, 50+30*i, 200, 20);
		}



	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == genStats){
			for(int i=0; i<buttons.length; i++){
				add(buttons[i]);
				buttons[i].setVisible(true);
			}
		}


	}
}
