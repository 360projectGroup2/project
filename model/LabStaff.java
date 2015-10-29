package model;

public class LabStaff {
	public String firstName;
	public String lastName;
	public String userName;
    private int staffID;
	public BusinessHours availble;
	boolean found = false;
	
   public LabStaff()// initialize first
   {
    firstName = new String("");
    lastName = new String("");
    staffID = 0;
    userName = new String("");
   }

   public void setLabStaff(String first, String last, int id)
   {
        firstName = first;
		lastName = last;
        staffID = id;
   
   }
	
	public void setHours(String weekday, String startHour, String endHour){
		availble = new BusinessHours(weekday,startHour,endHour);
	}
	
	public Patient searchPatient(Patient[] p, String name){
		for(int i = 0; i < p.length; i++){
			String fullName = p[i].firstName + p[i].lastName;
			if(name.equals(fullName)){
				found = true;
				return p[i];
				
			}
		}
		return null;
	}
	
    //CAN WE JUST USE 1 FUNCTION TO SET NEW RECORD AND UPDATE RECORD?
    //setting a brand new lab record
	public void newLabReport(Patient p, Lab newRecord)
    {
        //Lab newLab = new Lab();//create lab object
    
		if (found == true)
		{
		    p.setLabRecord(newRecord);//set Lab object to patient		
		}
	}
    
    //update a current record
    /*public void updateLabRecord(Patient p, Lab current)
    {
        if(found == true)
        {
            
        }
    }*/
   
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
    return staffID;
   }
   
   public String getUserName()
   {
    return userName;
   }

}
