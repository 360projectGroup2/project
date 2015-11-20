package GUI;

import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import controller.TableController;

public class ApplicationRunner {
	
	static int patientId;
	static int docId;
	static int staffId;
	static int nurseId;
	static int labStaffId;
	static int pharmacistId;
	static String loggedInActor;
		  
	public static void main(String[] args) throws SQLException {
		//TestPatient_Registration1 a = new TestPatient_Registration1();
		//a.display();
		
		ApplicationGUI goobypls = new ApplicationGUI();
		goobypls.display();
		
		/*
		BarChartDemo chart = new BarChartDemo("Vertical Bar Chart Demo");
		  chart.pack();
		  RefineryUtilities.centerFrameOnScreen(chart);
		  chart.setVisible(true);
		*/
	}
}
