package NyAdminGUI;

import java.util.Calendar;
import java.sql.*;

import model.QueryBuild.QueryBuilder;
//import jdk.nashorn.internal.runtime.ECMAException;
import databaseMethods.SwitchMethods;

public class Logic {
	
	QueryBuilder qb = new QueryBuilder();
	private static String pswd = "admin123";
	static boolean adminSignedIn = false;

	public static boolean authenticateAdmin(String password){

		if (true){//password.equals(pswd)){ 
			return true;
		}else{
			return false;
		}

	}

	public static boolean createUser(String username, String password, String passwordRepeat) throws SQLException 
	{
		System.out.println("inden i logic.createUser");
		SwitchMethods SW = new SwitchMethods();
		System.out.println("Efter switch method");
		System.out.println("Efter SW.createuser");
		if(password.equals(passwordRepeat))
		{
			SW.createuser(username, password);
			errorMessage userCreated = new errorMessage("The user " + username + " 11has been created succesfully");
			userCreated.setVisible(true);
			return true;
		}

		else
		{
			errorMessage passwordDoesNotMatch = new errorMessage("The passwords does not match");
			passwordDoesNotMatch.setVisible(true);
			return false;
		}

	}

	public static boolean deleteUser (String username)throws SQLException{
		System.out.println("EVERYDAY IM DELETING");
		SwitchMethods SW = new SwitchMethods();
		if(SW.deleteUser(username)){
			return true;
		}else{
			return false;	
		}
	}
	

	public static void removeEvent(String removeEventID){

		//Event should be removed here

	}


	public static boolean changeAdminPassword(String currentPassword, String newPassword,
			String passwordRepeat) {

		if(newPassword.equals(passwordRepeat)){

			if(currentPassword.equals(pswd)){
				pswd = newPassword;
				errorMessage passwordchanged = new errorMessage("The administrator password is changed successfully!");
				passwordchanged.setVisible(true);
				return true;
			}else{
				errorMessage wrongpassword = new errorMessage("The existing password does not match");	
				wrongpassword.setVisible(true);
				return false;	
			}
		}else{
			errorMessage passwordnotmatch = new errorMessage("Make sure that the passwords match!");
			passwordnotmatch.setVisible(true);
			return false;
		}

	}

	public static void removeUser(String username){
		//Method for removing user goes here <==
	}



}