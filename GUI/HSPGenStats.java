package GUI;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartPanel;
import org.jfree.ui.RefineryUtilities;

import java.awt.BorderLayout;

public class HSPGenStats extends JPanel implements ActionListener{


	public JButton genStats;
	public JLabel generateStats;
	public ArrayList<BarChartDemo> chart;
	public String[] statistics = {"healthOutcomes","trackAdmissions","PatientType", "Age", "Gender", "Ethnicity"};
	public JRadioButton[] buttons;
	public ButtonGroup asdf;
	public JPanel chartPanel;
	public ChartPanel currentChart;
	public JButton btnBack;

	public HSPGenStats(ActionListener e, ActionListener b){
		setLayout(null);
		generateStats = new JLabel("Press 1 to generate next statistics");
		generateStats.setBounds(78, 9, 165, 14);
		this.add(generateStats);	

		genStats = new JButton("Generate Statistics");
		genStats.setBounds(248,5,123,23);
		genStats.addActionListener(this);
		genStats.addActionListener(b);
		this.add(genStats);

		chartPanel = new JPanel();
		chartPanel.setBounds(124, 53, 468, 410);
		this.add(chartPanel);
		chartPanel.setLayout(new BorderLayout(0, 0));
		//chartPanel.add(lol,BorderLayout.CENTER);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 440, 89, 23);
		btnBack.addActionListener(e);
		add(btnBack);


		buttons = new JRadioButton[6];
		asdf = new ButtonGroup();
		for(int i=0; i<buttons.length; i++){
			buttons[i]= new JRadioButton(statistics[i]);
			buttons[i].addActionListener(this);
			asdf.add(buttons[i]);
		}

		chart = new ArrayList<BarChartDemo>();
		for(int i=0; i<buttons.length; i++){
			buttons[i].setBounds(0, 50+30*i, 200, 20);
		}
		for(int i=0;i<statistics.length; i++){
			chart.add(new BarChartDemo("Patient Statistics", statistics[i]+" Statistics", statistics[i]));
		}



	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		if(e.getSource() == genStats){
			for(int i=0; i<buttons.length; i++){
				add(buttons[i]);
				buttons[i].setVisible(true);
				//System.out.println("hello");
			}
			buttons[0].setEnabled(true);
			currentChart=chart.get(0).chartPanel;
			chartPanel.add(currentChart, BorderLayout.CENTER);
			revalidate();
			repaint();

		}
		else{
			for(int i=0;i<buttons.length; i++)
				if(buttons[i].isSelected()){
					System.out.println(buttons[i].getText());
					System.out.println("asdf");
					chartPanel.remove(currentChart);
					currentChart=chart.get(i).chartPanel;
					chartPanel.add(currentChart, BorderLayout.CENTER);
					chartPanel.revalidate();
					chartPanel.repaint();
				}
		}
	}

}
