package model;

public class BusinessHours {
	private String weekday;
	private String startHour;
	private String endHour;
	
	public BusinessHours(String day, String start, String end){
		weekday = day;
		startHour = start;
		endHour = end;
	}
	
	public String getWeekday(){
		return weekday;
	}
	
	public String getStartHour(){
		return startHour;
	}
	
	public String getEndHour(){
		return endHour;
	}
}
