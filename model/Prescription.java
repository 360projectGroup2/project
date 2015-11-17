package model;



import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.*;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import controller.TableController;

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

  public static void printPrescription(String prescription){
	  InputStream stream = new ByteArrayInputStream(prescription.getBytes(StandardCharsets.UTF_8));
	  
	  DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
	  Doc mydoc = new SimpleDoc(stream, flavor, null);

	 //    PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, aset);
	     PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

	     PrintRequestAttributeSet  aset = new HashPrintRequestAttributeSet();
	     aset.add(new Copies(1));
	     
	//     if(services.length == 0) {
	         if(defaultService == null) {
	               //no printer found

	         } else {
	              //print using default
	              DocPrintJob job = defaultService.createPrintJob();
	              try{
	            	  job.print(mydoc, aset);
	              }catch(PrintException pe){
	            	  System.out.println("Print Exception");
	              }

	         }
/*
	      } else {

	         //built in UI for printing you may not use this
	         PrintService service = ServiceUI.printDialog(null, 200, 200, services, defaultService, flavor, aset);


	          if (service != null)
	          {
	             DocPrintJob job = service.createPrintJob();
	             job.print(mydoc, aset);
	          }

	      }*/
  }
  
}