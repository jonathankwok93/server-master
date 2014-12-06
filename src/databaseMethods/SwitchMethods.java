package databaseMethods;
import java.sql.SQLException;
import java.util.ArrayList;

import JsonClasses.*;
import model.Model;
import model.QOTD.QOTDModel;
import model.QueryBuild.QueryBuilder;
import model.note.Note;

public class SwitchMethods extends Model
{
	QueryBuilder qb = new QueryBuilder();
	QOTDModel qm = new QOTDModel();



	/**
	 * Allows the client to create a new calendar
	 * @param userName
	 * @param calendarName
	 * @param privatePublic
	 * @return
	 * @throws SQLException
	 */

	public String getCalendar(String Calendar) throws SQLException{

		String defaultreply = "Calendar was not found!";
		String reply = null;
		resultSet = qb.selectFrom("calendar").where("Name", "=", Calendar).ExecuteQuery();
		try{
			while(resultSet.next()){
				reply =  resultSet.getString("CalendarID") + resultSet.getString("Name") + resultSet.getString("Active") +
						resultSet.getString("Createdby") + resultSet.getString("PrivatePublic");
			}
			return reply;
		}catch(SQLException e){
			return defaultreply;
		}
	}

	public ArrayList getAllUsers() throws SQLException
	{
		ArrayList<UserID> users = new ArrayList<UserID>();;
		resultSet = qb.selectFrom("users").all().ExecuteQuery();
		while (resultSet.next())
		{
			users.add(new UserID(resultSet.getString("email")));
		}

		return users;
	}


	public int deleteNote(int noteID) throws SQLException{
		try{
			Note note = new Note();
			//return note.DeleteNote(noteID);	
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 2;
		}
	}

	public int deleteEvent (String eventid) throws SQLException{
		try{

			if(qb.deleteFrom("events").where("eventid", "=", eventid).Execute()){
				return 1;
			}else{
				return 2;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return 3;
		}
	}

	public boolean deleteUser(String username) throws SQLException{
		if(qb.deleteFrom("users").where("email", "=", username).Execute())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean createuser(String userName, String password)throws SQLException{
		String[] keys = {"email", "active", "password"}; //Der i DB at der skal oprettes
		String[] values = {userName, "1", password}; //De v��rdier der skal oprettes med
		if(qb.insertInto("users", keys).values(values).Execute()){
			System.out.println("true ftw");
			return true;
		}else{
			System.out.println("False ftl");
			return false;
		}
	}

	public String getEvent(String CalendarID) throws SQLException{

		String defaultreply = "This calendar does not exist";
		String reply = defaultreply;
		qb = new QueryBuilder();
		resultSet = qb.selectFrom("eventes").where("CalendarID", "=", CalendarID).ExecuteQuery();
		if (resultSet.next()){
			reply = resultSet.getString("eventID");

			reply = resultSet.getString("eventID"); //eventid =  row indeks?
			reply += resultSet.getString("type");
			reply += resultSet.getString("createdby");
			reply += resultSet.getString("startTime");
			reply += resultSet.getString("endTime");
			reply += resultSet.getString("name");
			reply += resultSet.getString("text");
			reply += resultSet.getString("customevent");

			return reply;
		} else {
			return reply;
		}

	}

	public String createEvent(String type, String location, String createdby, String startTime,
			String endTime, String name, String text, String customEvent, String CalendarID) throws SQLException
			{
		String[] keys = {"type", "location", "createdby", "startTime", "endTime", "name", 
				"text", "customEvent", "CalendarID"};
		String[] values = {type, location, createdby, startTime, endTime, name, text, customEvent, CalendarID};
		if(qb.insertInto("events", keys).values(values).Execute()){
			return "Success";
		}else{
			return "Error";
		}
			}

	public void createNote(int noteID, String text, String dateTime, String createdBy, int isActive, int eventID){
		String returns = "";
		Note note = new Note();
		//return note.CreateNote(noteID, text, dateTime, createdBy, eventID, 1);
		//		
	}


	public String createNewCalendar (String userName, String calendarName, int privatePublic) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		if(authenticateNewCalendar(calendarName) == false)
		{
			addNewCalendar(calendarName, userName, privatePublic);
			stringToBeReturned = "The new calendar has been created!";
		}
		else
		{
			stringToBeReturned = "The new calendar has not been created!";
		}


		return stringToBeReturned;
	}

	public boolean authenticateNewCalendar(String newCalendarName) throws SQLException
	{
		getConn();
		boolean authenticate = false;

		resultSet= qb.selectFrom("calendar").where("name", "=", newCalendarName).ExecuteQuery();

		//("select * from test.calendar where Name = '"+newCalendarName+"';");
		while(resultSet.next())
		{
			authenticate = true;
		}
		return authenticate;
	}

	public void addNewCalendar (String newCalendarName, String userName, int publicOrPrivate) throws SQLException
	{
		String [] keys = {"Name","active","CreatedBy","PrivatePublic"};
		String [] values = {newCalendarName,"1",userName, Integer.toString(publicOrPrivate)};
		qb.update("calendar", keys, values).all().Execute();

		//		doUpdate("insert into test.calendar (Name, Active, CreatedBy, PrivatePublic) VALUES ('"+newCalendarName+"', '1', '"+userName+"', '"+publicOrPrivate+"');");
	}
	/**
	 * Allows the client to delete a calendar
	 * @param userName
	 * @param calendarName
	 * @return
	 */
	public String deleteCalendar (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturned ="";
		testConnection();
		stringToBeReturned = removeCalendar(userName, calendarName);

		return stringToBeReturned;
	}

	public String removeCalendar (String userName, String calendarName) throws SQLException
	{
		String stringToBeReturend = "";
		String usernameOfCreator ="";
		String calendarExists = "";
		resultSet = qb.selectFrom("Calendar").where("Name", "=", calendarName).ExecuteQuery();

		//				("select * from calendar where Name = '"+calendarName+"';");
		while(resultSet.next())
		{
			calendarExists = resultSet.toString();
		}
		if(!calendarExists.equals(""))
		{
			String [] value = {"CreatedBy"};
			resultSet = qb.selectFrom(value, "Calendar").where("Name", "=", calendarName).ExecuteQuery();
			while(resultSet.next())
			{
				usernameOfCreator = resultSet.toString();
				System.out.println(usernameOfCreator);
			}
			if(!usernameOfCreator.equals(userName))
			{
				stringToBeReturend = "Only the creator of the calendar is able to delete it.";
			}
			else
			{
				String [] keys = {"Active"};
				String [] values = {"2"};
				qb.update("Calendar", keys, values).where("Name", "=", calendarName).Execute();
				stringToBeReturend = "Calendar has been set inactive";
			}
			stringToBeReturend = resultSet.toString();
		}
		else
		{
			stringToBeReturend = "The calendar you are trying to delete, does not exists.";
		}



		return stringToBeReturend;
	}


	// Metoden faar email og password fra switchen (udtrukket fra en json) samt en boolean der skal saettes til true hvis det er serveren der logger paa, og false hvis det er en klient
	/**
	 * Allows the client to log in
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @return
	 * @throws Exception
	 */
	public String authenticate(String email, String password, boolean isAdmin) throws Exception {

		String[] keys = {"userid", "email", "active", "password"};

		qb = new QueryBuilder();

		// Henter info om bruger fra database via querybuilder
		resultSet = qb.selectFrom(keys, "users").where("email", "=", email).ExecuteQuery();

		// Hvis en bruger med forespurgt email findes
		if (resultSet.next()){

			// Hvis brugeren er aktiv
			if(resultSet.getInt("active")==1)
			{					
				// Hvis passwords matcher
				if(resultSet.getString("password").equals(password))
				{
					int userID = resultSet.getInt("userid");

					String[] key = {"type"};

					resultSet = qb.selectFrom(key, "roles").where("userid", "=", new Integer(userID).toString()).ExecuteQuery();

					// Hvis brugeren baade logger ind og er registreret som admin, eller hvis brugeren baade logger ind og er registreret som bruger
					if((resultSet.getString("type").equals("admin") && isAdmin) || (resultSet.getString("type").equals("user") && !isAdmin))
					{
						return "0"; // returnerer "0" hvis bruger/admin er godkendt
					} else {
						return "4"; // returnerer fejlkoden "4" hvis brugertype ikke stemmer overens med loginplatform
					}
				} else {
					return "3"; // returnerer fejlkoden "3" hvis password ikke matcher
				}
			} else {
				return "2"; // returnerer fejlkoden "2" hvis bruger er sat som inaktiv
			}
		} else {
			return "1"; // returnerer fejlkoden "1" hvis email ikke findes
		}
	}
}
