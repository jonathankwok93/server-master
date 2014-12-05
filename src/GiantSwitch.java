import java.sql.SQLException;



import model.Forecast.ForecastModel;
import model.Forecast.ForecastTest;
import model.QOTD.QOTDModel;
import model.calendar.Event;
import model.calendar.GetCalendarData;
import model.calendar.cbsevent;
import model.note.Note;
import JsonClasses.AuthUser;
import JsonClasses.CalendarInfo;
import JsonClasses.CreateCalendar;
import JsonClasses.DeleteCalendar;
import JsonClasses.createEvent;
import JsonClasses.getEvents;

import com.google.gson.*;

import databaseMethods.SwitchMethods;

public class GiantSwitch {
	
	
	
	public String GiantSwitchMethod(String jsonString) throws SQLException {

		//Events eventsKlasse = new Events(0, 0, 0, jsonString, jsonString, jsonString, jsonString, jsonString);

		Note noteKlasse = new Note();
		//ForecastModel forecastKlasse = new ForecastModel();
		QOTDModel QOTDKlasse = new QOTDModel();
		SwitchMethods SW = new SwitchMethods();
		
		Gson gson = new GsonBuilder().create();
		String answer = "";	
		//Creates a switch which determines which method should be used. Methods will be applied later on
		switch (Determine(jsonString)) {
		//If the Json String contains one of the keywords below, run the relevant method.

		/************
		 ** COURSES **
		 ************/

		case "importCalendar":
			System.out.println("Recieved importCourse");
			break;

		/**********
		 ** LOGIN **
		 **********/
		case "logIn":
			AuthUser authuser = (AuthUser)gson.fromJson(jsonString, AuthUser.class);
			
			try{
				answer = SW.authenticate(authuser.getAuthUserEmail(), authuser.getAuthUserPassword(), authuser.getAuthUserIsAdmin());
			}catch (Exception e){
				e.printStackTrace(); 
			}
			
			break;

		case "logOut":
			//System.out.println("Recieved logOut");
			
			//Ikke nødvendig, da det kun er for admin
			break;

		/*************
		 ** CALENDAR **
		 *************/
		case "createCalendar":
		//	CreateCalender CC = (CreateCalender)gson.fromJson(jsonString, CreateCalender.class);
		//	System.out.println(CC.getCalendarName()+ "Den har lagt det nye ind i klassen");
		//	answer = SW.createNewCalendar(CC.getUserName(), CC.getCalendarName(), CC.getPublicOrPrivate());
			break;
		
		case "deleteCalendar":
			DeleteCalendar DC = (DeleteCalendar)gson.fromJson(jsonString, DeleteCalendar.class);
			System.out.println(DC.getCalendarName()+ "Den har lagt det nye ind i klassen");
			answer = SW.deleteCalendar(DC.getUserName(), DC.getCalendarName());
			break;
		
		case "saveImportedCalendar":
			
			
			break;
			
		case "getCalendar":
			System.out.println("Recieved getCalendar");
			CalendarInfo ci = (CalendarInfo)gson.fromJson(jsonString, CalendarInfo.class);
			answer = SW.getCalendar(ci.getCalendarName());
			break;

		case "getEvents":
			System.out.println("Recieved getEvents");
			cbsevent ev = (cbsevent)gson.fromJson(jsonString, cbsevent.class);
			GetCalendarData getcalendardata = new GetCalendarData();
			//answer = getcalendardata.getUserEvents(ev.getUsername());
			break;

		case "createEvent":
			System.out.println("Recieved createEvent");
			createEvent ce1 = (createEvent)gson.fromJson(jsonString, createEvent.class);
			//answer = SW.createEvent( ce1.gettype(), ce1.getLocation(), ce1.getCreatedby(), ce1.getStartTime(), ce1.getEndTime(), ce1.getName(), ce1.getText(), ce1.getCustomevent(), ce1.getCalendarID());
			answer = "";
			break;

		case "getEventInfo":
			System.out.println("Recieved getEventInfo");
			getEvents get = (getEvents)gson.fromJson(jsonString, getEvents.class);
		    answer = SW.getEvent(get.getCalendarID());
			break;
			
		case "deleteEvent":
			System.out.println("Recieved deleteEvent");
			getEvents det = (getEvents)gson.fromJson(jsonString, getEvents.class);
			answer = Integer.toString((int) SW.deleteEvent(det.geteventID())).toString();
		
		case "saveNote":
			System.out.println("Recieved saveNote");
			break;

		case "getNote":
			System.out.println("Recieved getNote");
			break;
			
		case "deleteNote":
			System.out.println("Recieved deleteNote");
			break;

		/**********
		 ** QUOTE **
		 **********/
		case "getQuote":

			try {
				answer = QOTDKlasse.getQuote();
			} catch (Exception e) {

				e.printStackTrace();
			}
			System.out.println(answer);
			
			break;

		/************
		 ** WEATHER **
		 ************/

		case "getClientForecast":
			System.out.println("Recieved getClientForecast");
			ForecastTest forecast = new ForecastTest();
		//	answer = forecast.getForecast();
			break;
		
		default:
			System.out.println("Error");
			break;
		}
		return answer;
		
	}

	//Creates a loooong else if statement, which checks the JSon string which keyword it contains, and returns the following 
	//keyword if
	public String Determine(String ID) {

		if (ID.contains("getEvents")) {
			return "getEvents";
		} else if (ID.contains("getEventInfo")) {
			return "getEventInfo";
		} else if (ID.contains("saveNote")) {
			return "saveNote";
		} else if (ID.contains("getNote")) {
			return "getNote";
		} else if (ID.contains("deleteNote")){
			return "deleteNote";
		}else if  (ID.contains("deleteCalendar")){
			return "deleteCalendar";
		} else if (ID.contains("getClientForecast")) {
			return "getClientForecast";
		} else if (ID.contains("saveImportedCalendar")) {
			return "saveImportedCalendar";
		}else if (ID.contains("importCourse")) {
			return "importCourse";
		} else if (ID.contains("exportCourse")) {
			return "exportCourse";
		} else if (ID.contains("getQuote")) {
			return "getQuote";
		} else if (ID.contains("logIn")) {
			return "logIn";
		} else if (ID.contains("logOut")) {
			return "logOut";
		} else if (ID.contains("getCalendar")) {
			return "getCalendar";
		} else if (ID.contains("createEvent")) {
			return "createEvent";
		} else if (ID.contains("deleteEvent")) {
			return "deleteEvent"; 
		} else if (ID.contains("createCalendar")) {
			return "createCalendar";
		}

		else
			return "error";
	}
	

}
