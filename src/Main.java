import GUI.GUILogic;
import GUI.UserList;
import NyAdminGUI.runAdmin;
import config.Configurations;
import databaseMethods.SwitchMethods;

public class Main {
	//Starts public main method.
	
//	public static void main(String[] args) {
//		Configurations cf = new Configurations();
//		try{
//		Class.forName("com.mysql.jdbc.Driver");
//		}catch(Exception e){
//			System.err.print(e);
//		}
//		cf.ReadFile();
//		
//		System.out.println(cf.getPassword());
//		//new GUILogic().run();
//		new runAdmin().run();
//		try {
//			TCPServer.main();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}														
//
//}
//
	public static void main(String[] args) throws Exception {
		Configurations cf = new Configurations();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.err.print(e);
		}
		cf.ReadFile();
		
		System.out.println(cf.getPassword());
		//new GUILogic().run();
		
		SwitchMethods SM = new SwitchMethods();
		String test = SM.authenticate("test@test.com", "123", false);
		System.out.println(test);
	}														

}

