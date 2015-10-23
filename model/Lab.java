package model;

public class Lab {
	private String alergy;
	private String bloodtype;
	private String cancer;
	private String drug;
	private String HIV;
	
	Lab(){
		alergy = "";
		bloodtype = "";
		cancer = "";
		drug = "";
		HIV = "";
	}
	
	void setAlergy(String alergiesTest){
		alergy = alergiesTest;
	}
	
	void setBloodtype(String bloodTest){
		bloodtype = bloodTest;
	}
	
	void setCanser(String cancerTest){
		cancer = cancerTest;
	}
	
	void setDrug(String drugTest){
		drug = drugTest;
	}
	
	void setHIV(String HIVTest){
		HIV = HIVTest;
	}
	
	String getAlergy(){
		return alergy;
	}
	
	String getBloodtype(){
		return bloodtype;
	}
	
	String getCancer(){
		return cancer;
	}
	
	String getDrug(){
		return drug;
	}
	
	String getHIV(){
		return HIV;
	}

	void print(){
		System.out.println(getAlergy());
		System.out.println(getBloodtype());
		System.out.println(getCancer());
		System.out.println(getDrug());
		System.out.println(getHIV());
	}
	
	
}
