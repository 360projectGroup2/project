package model;

public class HSP {
	public String firstName;
	public String lastName;
	public String userName;
    public int hspID;
	public BusinessHours availble;
	boolean found = false;
	
   public HSP()// initialize first
   {
    firstName = new String("");
    lastName = new String("");
    hspID = 0;
    userName = new String("");
   }

   public void setHSP(String first, String last, int id)
   {
        firstName = first;
		lastName = last;
        hspID = id;
   
   }
	
	public void setHours(String weekday, String startHour, String endHour){
		availble = new BusinessHours(weekday,startHour,endHour);
	}
	
	public Patient searchPatient(Patient[] p, String name){
        found = false;
		for(int i = 0; i < p.length; i++){
			String fullName = p[i].firstName + p[i].lastName;
			if(name.equals(fullName)){
				found = true;
				return p[i];
				
			}
		}
		return null;
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
    return hspID;
   }
   
   public String getUserName()
   {
    return userName;
   }

}
