package JsonClasses;

public class UserID 
{
	private String userList;
	
	
	public UserID(String string) {
		this.userList = string;
	}

	public String getUserList() {
		return userList;
	}
	
	public void setUserList(String userListID) {
		this.userList = userListID;
	}
	
	public String toString()
	{
		return this.userList;
	}
	
}
