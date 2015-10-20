package model;
import java.text.*;

public class Doctor {
	public String firstName;
	public String lastName;
	public String userName;
    private int docId;
	public BusinessHours availble;
	String specialty;
	
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
	
	public void setHours(int weekday, int startHour, int endHour){
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
   
   public String getUserName()
   {
    return userName;
   }

    
}
