package GUI;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

import controller.TableController;

public class BarChartDemo extends ApplicationFrame {
	
	static String statType;
	
	public BarChartDemo( String applicationTitle , String chartTitle, String statType ){
      super( applicationTitle );  
      BarChartDemo.statType = statType;
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         statType,            
         "Count",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
	
   private CategoryDataset createDataset( ){

	   DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	   
	   TableController stats = new TableController();
	   
	   if(BarChartDemo.statType.equals("Gender")){      
		      try{
		    	  String[] attrs = {"Sex"};
		    	  ArrayList maleCount = stats.get("Patient",attrs,"Sex='M'");
		    	  ArrayList femaleCount = stats.get("Patient",attrs,"Sex='F'");

			      dataset.addValue( maleCount.size() , "Male" , "" );        
			      dataset.addValue( femaleCount.size() , "Female" , "" );
		      }catch(Exception exception){
		    	  exception.printStackTrace();
		      }
	   }
	   
	   if(BarChartDemo.statType.equals("Age")){
		  String[] ageLabels = {"<10yrs","10-20yrs", "20-30yrs", "30-40yrs", "40-50yrs", "50-60yrs", 
		  "60-70yrs", "70-80yrs", "80-90yrs", "90-100yrs", ">100yrs"};
		  
		  ArrayList ageCount = new ArrayList();
		  
		  Date currentDate = Calendar.getInstance().getTime();
		
		  Calendar cal = Calendar.getInstance();
		  SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
		  int currentYear = Integer.parseInt(dateformat.format(cal.getTime()));
		  String[] attrs = {"DateOfBirth"};
		  		  
		  for(int i=0;i<11;i++){
			  try{
				  cal.set(Calendar.YEAR, currentYear-10);
				  Date date = cal.getTime();
				  dateformat = new SimpleDateFormat("yyyy-MM-dd");
				  String sqlDate = dateformat.format(date);
				  ArrayList ages = stats.get("Patient",attrs,"DateOfBirth >='"+sqlDate+"'");
				  ageCount.add(ages.size());
				  currentYear = currentYear-10;				  
			  }catch(SQLException se){
				  se.printStackTrace();
			  }
		  }
		  
		  dataset.addValue( (int)ageCount.get(0), ageLabels[0] , "" );
		  for(int i = 1; i <= 10; i++){
			  dataset.addValue( (int)ageCount.get(i) - (int)ageCount.get(i-1) , ageLabels[i] , "" );
		  }	  
	   }
	   
	   if(BarChartDemo.statType.equals("Ethnicity")){
		   try{
			   String[] distinct_attrs = {"distinct Ethnicity"};
			   ArrayList races = stats.get("Patient",distinct_attrs,null);
			   
			   for(int i=0; i < races.size(); i++){
				   String[] attrs = {"Ethnicity"};
				   ArrayList count = stats.get("Patient",attrs,"Ethnicity='"+races.get(i)+"'");
				   dataset.addValue( count.size() , races.get(i).toString(), "" );
			   }
		   }catch(Exception exception){
		    	  exception.printStackTrace();
		   }
	   }
	   if(BarChartDemo.statType.equals("PatientType")){
		   try{
			   String[] distinct_attrs = {"distinct PatientGkey,DoctorGkey"};
			   
			   ArrayList rows = stats.get("Appointments",distinct_attrs,null);
			   Hashtable pTypeCount = new Hashtable();
			   for(int i=1; i<rows.size();i=i+2){
				   if(pTypeCount.containsKey(rows.get(i))){
					   int count = (int)pTypeCount.get(rows.get(i));
					   pTypeCount.put(rows.get(i), ++count);
				   }else{
					   pTypeCount.put(rows.get(i), 1);
				   }
			   }
			   for (Object key : pTypeCount.keySet()) {
				   String[] cols = {"specialty"};
				   ArrayList speciality = stats.get("SpecializesIn",cols,"Gkey='"+key.toString()+"'");				   
				   dataset.addValue( (int)pTypeCount.get(key.toString()), speciality.get(0).toString(), "" );
			   }
		   }catch(Exception exception){
			   exception.printStackTrace();
		   }
	   }
	   
	   if(BarChartDemo.statType.equals("trackAdmissions")){
		   int year = Calendar.getInstance().get(Calendar.YEAR);;
		   String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		   String[] mNames = {"January", "Febraury","March","April","May","June","July","August","September","October","November","December"};
		   ArrayList count = new ArrayList();
		   
		   for(int i=0; i<months.length;i++){
			   String startDate = year+"-"+months[i]+"-01";
			   String endDate = year+"-"+months[i]+"-31";
			   String[] row_create = {"row_create"};
			   try{
				   ArrayList rows = stats.get("Patient",row_create,"row_create >= '"+startDate+"' and row_create <= '"+endDate+"'");
				   count.add(rows.size());
			   }catch(SQLException se){
				   se.printStackTrace();
			   }

			   dataset.addValue( (int)count.get(i), mNames[i], "" );
		   }
	   }
	   
	   if(BarChartDemo.statType.equals("healthOutcomes")){
		   try{
			
			   ArrayList count = new ArrayList();
			   String[] attrs = {"count(*)"};
			   
			   count = stats.get("HasCondition", attrs, null);
			   int totalRows = Integer.parseInt(count.get(0).toString());
			   
			   String[] healthOutcomeAttrs = {"Cured"};
			   count = stats.get("HasCondition",healthOutcomeAttrs, "Cured=1");
			   int curedRows = count.size();
			   int notCuredRows = totalRows - curedRows;
			   
			   dataset.addValue( curedRows, "Cured Patients", "" );
			   dataset.addValue( notCuredRows, "Not Cured Patients", "" );
			 
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }

      return dataset; 
   }
   /*public static void main( String[ ] args ){
	   
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
   }*/
}