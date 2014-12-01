package JsonClasses;

public class DeleteCalendar implements java.io.Serializable{

	private final long serialversionUID = 1L;
	private String overallID = "deleteCalendar";
	private String calenderName;
	private String userName;
	
	//Generated getters and setters
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalenderName() {
		return calenderName;
	}
	public void setCalenderName(String calenderName) {
		this.calenderName = calenderName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getSerialversionUID() {
		return serialversionUID;
	}
	
	
	
}
