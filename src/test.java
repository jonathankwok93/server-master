import config.Configurations;
import model.calendar.GetCalendarData;
import databaseMethods.SwitchMethods;


public class test {

	
	public static void main (String [] args) throws Exception{
		
//		GetCalendarData GCD = new GetCalendarData();
//		GCD.getDataFromCalendar("kakw13ab");
		
		GiantSwitch GS = new GiantSwitch();
		String quote = GS.GiantSwitchMethod("getQuote");
		System.out.println(quote);
	
		GetCalendarData GCD = new GetCalendarData();
		GCD.getDataFromCalendar("kakw13ab");

	}

}


