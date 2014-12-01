package model.calendar;

public class GetCalendarDataTest {

	public static void main(String[]args){
	
		GetCalendarData cal = new GetCalendarData();
		try{
		cal.getDataFromCalendar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
