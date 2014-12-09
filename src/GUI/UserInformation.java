package GUI;


public class UserInformation
{
  
   private String userName;
   private String password;
  

   public UserInformation()
   {
   } 
   public UserInformation(  String user, String pass )
   {
	   
//      setUserid(id);
     
      setUserName ( user );
      setPassword ( pass );
      

   } 




public String getUserName() {
	return userName;
}

public void setUserName(String user) {
	userName = user;
}

public String getPassword() {
	return password;
}

public void setPassword(String pass) {
	password = pass;
}

}



 