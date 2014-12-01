package model.user;

public class AuthenticateUserTest {

	public static void main(String[]args) throws Exception{
		AuthenticateUser auth = new AuthenticateUser();
		
		auth.authenticate("abc@email.com", "abc", false);
	}
}
