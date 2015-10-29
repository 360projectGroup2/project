package model;

public class Nurse {
	public String firstName;
	public String lastName;
	public String userName;
    private int nurseID;
	public BusinessHours availble;
	String specialty;
	boolean found = false;
	
   public Nurse()// initialize first
   {
    firstName = new String("");
    lastName = new String("");
    nurseID = 0;
    userName = new String("");
   }

   public void setNurse(String first, String last, int id)
   {
        firstName = first;
		lastName = last;
        nurseID = id;
   
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
	
	public void updateHealth(Patient p){
		if (found == true)
		{
		p.healthCondition = "";  //get from input
		p.allergies = "";   //get from input
		
		}
		
	}
   
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
    return nurseID;
   }
   
   public String getUserName()
   {
    return userName;
   }

}
