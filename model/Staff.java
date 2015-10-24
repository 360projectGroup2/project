package model;

import java.text.*;
//NOT USING THIS FILE. RIP
public class Staff
{
    private String firstName;
    private String lastName;
    private int ID;
    private String identity; // lab staff, HSP staff, nurses or pharmacists
    private String userName;

    public Staff()
    {
        firstName = new String("");
        lastName = new String("");
        ID = 0;
        userName = new String("");
        identity = new String("");
    }
    
    public void setStaff(String first, String last, int id, String user, String iden)
    {
        firstName = first;
        lastName = last;
        ID = id;
        userName = user;
        identity = iden;
    }
    
    public Patient searchPatient(Patient[] p, String name)
    {
		for(int i = 0; i < p.length; i++){
			String fullName = p[i].firstName + p[i].lastName;
			if(name.equals(fullName)){
				return p[i];
			}
		}
		return null;
	}
    
    public int getPatientInfo(Patient p)
    {
        int i = 0;
        if(identity != "HSP")
        {
            i = 0; // 0 = false, 1= true
        }
        
        return i; //if return val is 0, they cant access it
    }

}