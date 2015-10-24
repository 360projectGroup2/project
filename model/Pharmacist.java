package model;

public class Pharmacist{
	public String firstName;
	public String lastName;
	public String userName;
    private int ID;
	public BusinessHours availble;
	boolean found = false;
	
   public Pharmacist()// initialize first
   {
    firstName = new String("");
    lastName = new String("");
    ID = 0;
    userName = new String("");
   }

   public void setPharmacist(String first, String last, int id)
   {
        firstName = first;
		lastName = last;
        ID = id;
   
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
	
    //get prescription info of patient
    public void getPrescription(Patient p)
    {
    
        //TODO
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
    return ID;
   }
   
   public String getUserName()
   {
    return userName;
   }

}
