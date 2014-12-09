package model.QOTD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import java.util.Date;

import model.Forecast.Forecast;
import model.QueryBuild.QueryBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QOTDModel {

	private ArrayList<QOTD> qotdlist = new ArrayList<>();
	
    QOTD qotdlist2 = new QOTD(null, null, null);
    QueryBuilder qb = new QueryBuilder();
    
    private ResultSet resultSet;
    
    /**
     *
     */ 
    
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
    
     	public void saveQuote() {

            /**
             * getting text from website and putiing into string
             * Making a new object of JSON, and prints out quote
             */
            String json;
			try {
				json = readUrl("http://dist-sso.it-kartellet.dk/quote/");
			
            
    			JSONParser jsonParser = new JSONParser();
    			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
    			
    			String quote = (String) jsonObject.get("quote");
    			String author = (String) jsonObject.get("author");
    			String topic = (String) jsonObject.get("topic");

    			
    			String[] keys = {"qotd"};
    			String[] keys2 = {quote};
    			
    			
    			qb.update("dailyupdate", keys, keys2).where("msg_type", "=", "1").Execute();
    			
    	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
    			
    }
     
    /**
     * Retrieve Quote from a website and put it into a String, 
     * Afterwards we will make it into a json object so it can be printed out to the client.
     * @throws Exception 
     */
     	
  	public String getQuote() throws Exception{
  		String quoteOfTheDay = readUrl("http://dist-sso.it-kartellet.dk/quote/");
		System.out.println(quoteOfTheDay);
  		return quoteOfTheDay;
  	}
  	
  	
  	 public void updateQuote(){
	     	Date date = new Date(); 
	     	long maxTimeNoUpdate = 86400; 
	     	
	     	long date1 = date.getTime();
	     	long date2 = date.getTime() - maxTimeNoUpdate; 
	     	
	     	long timeSinceUpdate = date1 - date2; 
	
	     	
	     	if(timeSinceUpdate > 864000){
	     		saveQuote();	
	     	} 
	     }
  	
}
