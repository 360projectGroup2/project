package model;

public class BusinessHours {
	private int weekday;
	private int startHour;
	private int endHour;
	
	public BusinessHours(int day, int start, int end){
		weekday = day;
		startHour = start;
		endHour = end;
	}
	
	public int getWeekday(){
		return weekday;
	}
	
	public int getStartHour(){
		return startHour;
	}
	
	public int getEndHour(){
		return endHour;
	}
}
