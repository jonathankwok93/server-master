package model.Forecast;

import java.sql.SQLException;
import java.util.ArrayList;

public class ForecastTest {

	// Main metode til at koere en test af vejrudsigt funktionen
    public static String getForecast() throws SQLException {

        ForecastModel fm = new ForecastModel();
        
        ArrayList<Forecast> forecastList = fm.requestForecast();
        
        for (int i = 0; i < forecastList.size(); i++) {
        	System.out.println(forecastList.get(i).toString());
        	
        }
		return null;
       
    }
    
    public static String getTodayForecast() throws SQLException{

        ForecastModel fm = new ForecastModel();
        
        ArrayList<Forecast> forecastList = fm.requestForecast();
        
        return (forecastList.get(1).toString());
        	       
    }

}