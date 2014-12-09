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
		
		try{
			TCPServer TCPS = new TCPServer();
			TCPS.TCPRun();
		}catch(Exception e){
			
		}
		System.out.println(cf.getPassword());
		new runAdmin().run();
		
	}		
}
	
