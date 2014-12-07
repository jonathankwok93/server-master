package model.calendar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData {
	
	EncryptUserID e = new EncryptUserID();
	
	
	//henter data fra URL og l??er ind til en string
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    //Nu har vi alle data liggende i en string (JSON). 
    //Saa bruger vi Google's udviklede library Json string. den kan lave det om til java objekter
    //Events laver en arraylist af Event
    
    /**
     * Allows client to retrieve CBS's calendar and then access it.
     * @throws Exception
     */
    public void getDataFromCalendar(String username) throws Exception {

        /**
         * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
         * Encrypt hash from
         */
    	//String userID = "kakw13ab";
    	String userID = username;
        String json = readUrl("http://calendar.cbs.dk/events.php/"+ userID +"/"+e.getKey(userID)+".json");
//        String json = readUrl("http://calendar.cbs.dk/events.php/caha13ag/02a24d4e002e6e3571227c39e2f63784.json");
       // System.out.println(json);
        Gson gson = new Gson();
        Events events = gson.fromJson(json, Events.class); 

        //tester events activityID's
        	int year = Calendar.getInstance().get(Calendar.YEAR);
        	int month = Calendar.getInstance().get(Calendar.MONTH);
        
        	ArrayList<String> obj = new ArrayList<String>();  
        	
        //	Arrays.asList(events.getEvents().get(i).getStart());
        	
//        	System.out.println(obj);
//        	if(events.getEvents().get(i).getStart(0).equals(yearString){
        	if(String.valueOf(events.getEvents().get(0).getStart()).equals(String.valueOf(year)){ 
            	if(String.valueOf(events.getEvents().get(1).getStart()).equals(String.valueOf(month)){ 

        		System.out.println("yes");
        			}
        	}
        	for(int i = 0; i < events.getEvents().size(); i++){
        	//if(events.getEvents().get(0).getStart().equals(String.valueOf(year))){ 
        	//		&& events.getEvents().get(1).getStart().equals(monthString)){
	            System.out.print(events.getEvents().get(i).getDescription());
	            System.out.print(events.getEvents().get(i).getType());
	            System.out.print(events.getEvents().get(i).getLocation());
	            System.out.print(events.getEvents().get(i).getStart());
	            System.out.print(events.getEvents().get(i).getEnd());
	            System.out.println();
        	
        }

        
    }
}
