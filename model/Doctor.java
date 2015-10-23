package model;

import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;

import controller.TableController;

public class Doctor {
	public String firstName;
	public String lastName;
	public String userName;
    private int docId;
	public BusinessHours availble;
	public String specialty;
	
   public Doctor()// initialize first
   {
    firstName = new String("");
    lastName = new String("");
    docId = 0;
    userName = new String("");
   }

   public void setDoctor(String first, String last, String specialize, int id)
   {
        firstName = first;
		lastName = last;
		specialty = specialize;
        docId = id;
   
   }
	/*public Doctor(String first, String last, String specialize, int id){
		firstName = first;
		lastName = last;
		specialty = specialize;
        docId = id;
	}*/
	
	public void setHours(String weekday, String startHour, String endHour){
		availble = new BusinessHours(weekday,startHour,endHour);
	}
	
	public Patient searchPatient(Patient[] p, String name){
		for(int i = 0; i < p.length; i++){
			String fullName = p[i].firstName + p[i].lastName;
			if(name.equals(fullName)){
				return p[i];
			}
		}
		return null;
	}
	
	public void updateHealth(Patient p){
		p.healthCondition = "";  //get from input
		p.allergies = "";   //get from input
		
		
	}
	
	//public Lab getLabRecord()
	
	/*public void e-Prescribe(Patient p, int doctorId, String prescribe)// File prescription as 3rd param??
    {
        //get Patient id
        //set Patient.prescription = prescribe;
        //
        return;
    }*/
    //public Lab assignLabTest()
    
    //public Lab printLabTest()
    
   public String getFirstName()
   {
    return firstName;
   }

  public String getLastName()
   {
    return lastName;
   }

  public int getID()
   {
    return docId;
   }
  
  public void setID(int doctorId){
	  this.docId = doctorId;
  }
   
   public String getUserName()
   {
    return userName;
   }
   
   /*This method takes doctor ID as input and gets all 
    * 
    */
    public ArrayList<Doctor> getDoctor(int patientId) throws SQLException{
    	TableController dbController = new TableController();
    	ArrayList<Doctor> doctors = dbController.getDoctor(patientId, null);
    	return doctors;
    }
}
