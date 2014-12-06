import GUI.GUILogic;
import GUI.UserList;
import NyAdminGUI.runAdmin;
import config.Configurations;
import databaseMethods.SwitchMethods;

public class Main {
	
	public static void main(String[] args) {
		Configurations cf = new Configurations();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.err.print(e);
		}
		cf.ReadFile();
		
		System.out.println(cf.getPassword());
		//new GUILogic().run();
		new runAdmin().run();
		}
		
	}
	
