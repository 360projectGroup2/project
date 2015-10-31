package model;



import java.text.*;

public class Prescription {
    private int doctorId;
    private String doctorName;//last name
    private String patientName;
    private String patientId;
    private String prescriptionInfo;
    //private Doctor doc;
    //private Patient p;
    
    
    public Prescription()
    {
        doctorId = 0;
        doctorName = new String("");
        patientName = new String("");
        patientId = new String("");
        prescriptionInfo = new String("");
    }
    

    
    public String getInfo()
    {
        return prescriptionInfo;
    }
    
     // The toString method returns a string describing
  // the value of each instance variable.
  public String toString()
   {
    String pInfo;

    pInfo = "\nPatient Name:\t\t" + patientName + "\n"
                   + "Patient ID:\t\t" + patientId + "\n"
                   + "Doctor:\t\t" + doctorName + "\n"
                   + "Doctor ID:\t\t" + doctorId + "\n"
                   + "Prescription Info:\t\t" + prescriptionInfo 
                   + "\n\n";

    return pInfo;
   }

}