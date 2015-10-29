package model;


import java.util.ArrayList;

import GUI.Controller;
/********************************************************************************
CSE 360 IPIMS Project
File Name: Patient.java
Group: 2
Description: This class contains the functions assigned to the Patient object.
*********************************************************************************/
public class Patient
{
  public String patientId;
  public String firstName;
  public String lastName;
  public String age;
  public String ssn;
  public String contactNumber;
  public String address;
  public String history;
  public String allergies;
  public String birthdate;
  public String sex;
  public String ethnicity;
  public String healthCondition;
  public String InsuranceComp;
  public String InsuranceID;
  public int severity;
  public Lab labRecord = new Lab();						//lab record added
  
  public Patient() {}
  
  public Patient(Controller window)
  {
	  this.firstName = window.storeName;
	  this.address = window.storeAddress;
	  this.ssn = window.storeSsn;
	  /* ADD GUI FIELD FOR PHONE # */
	  this.healthCondition = window.storeConcerns;
  }
  
  //don't worry about this
  public Patient(boolean a){
	  
  }
  
  // Should this method return the details as an ArrayList?
  public ArrayList<String> getPatientDetails()  {
	  ArrayList<String> summary = new ArrayList<String>();
	  summary.add(patientId);    
	  summary.add(firstName);
	  summary.add(lastName);
	  summary.add(age);
	  summary.add(ssn);
	  summary.add(contactNumber);
	  summary.add(address);
	  summary.add(healthCondition);
	  summary.add(healthCondition);
	  summary.add(allergies);
	  return summary;
  }
  
    //set patient info screen
  public void setPI(String[] a){
	  this.firstName = a[0];
	  this.age  = a[1];
	  this.ssn = a[2];
	  this.sex = "" + a[3].charAt(0);
  }
  
  
  //set patients lab record
  public void setLabRecord(Lab n)
  {
    labRecord = n;
  }
  
  
  //set patient insurance information screen
  public void setII(String[] a){
	  this.InsuranceComp = a[0];
	  this.InsuranceID = a[2];
  }
  
  //set patient medical history screen
  public void setMH(String[] a){
	  this.allergies = a[0];
	  this.healthCondition = a[1];
  }
 
  /*
  public void setPatientDetails(int patientId, String name, int age, int ssn, int contactNumber, 
    String address, ArrayList<String> healthCondition, ArrayList<String> healthRecord) {
	return;
=======
  public void setPatientDetails(String patientId, String name, String age, String ssn, String contactNumber, 
    String address, String healthCondition, String healthRecord) {
>>>>>>> origin/rlnsanz_branch
    this.patientId = patientId;  
    this.name = name;
    this.age = age;
    this.ssn = ssn;
    this.contactNumber = contactNumber;
    this.address = address;
    this.healthCondition = healthCondition;
    this.healthRecord = healthRecord;
  }

  
  /*getAppointment (patientId, date, doctorId)  {
  return patientId
  return import date from Date external tool
  return doctorId
  }
  
  getAppointment(patientId, OldDate, newDate, oldDoctorId, newDoctorId) {
  Get patientId
  Get oldDate
  Get oldDoctorId
  Get newDoctorId
  Other getAppointment method called
  getAppointment (patientId, newDate,  newDoctorId ) replaces old Appointment
  }
  
  cancelAppointment(patientId, date, doctorId)   {
  Get patientId
  Get date
  Get doctor id
  
  while (true) {
        Search for patientId
        Find patientId
        Find appointment date from patient info
        Delete date
        Search for doctorId
      Delete doctorId
    }
  } */
  
}
