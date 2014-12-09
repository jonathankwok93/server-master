package model.calendar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by jesperbruun on 13/10/14.
 */
public class GetCalendarData {

	EncryptUserID e = new EncryptUserID();


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

	/**
	 * Allows client to retrieve CBS's calendar and then access it.
	 * @return 
	 * @throws Exception
	 */
	public String getDataFromCalendar(String username) throws Exception {

		/**
		 * Get URL From calendar.cbs.dk -> Subscribe -> change URL to end with .json
		 * Encrypt hash from
		 */
		
		String userID = username;
		String json = readUrl("http://calendar.cbs.dk/events.php/"+ userID +"/"+e.getKey(userID)+".json");
		Gson gson = new Gson();
		Events events = gson.fromJson(json, Events.class); 

		return json;

	}
}
