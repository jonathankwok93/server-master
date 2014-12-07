package JsonClasses;

public class UserActive 
{
	
	private String userActiveList;
	
	public UserActive(String string) {
		this.userActiveList = string;
	}

	public String getUserActiveList() {
		return userActiveList;
	}
	
	public void setUserActiveList(String userListID) {
		this.userActiveList = userListID;
	}
	
	public String toString()
	{
		return this.userActiveList;
	}
}

