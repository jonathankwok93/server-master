import GUI.GUILogic;
import config.Configurations;
import NyAdminGUI.Login;
import NyAdminGUI.runAdmin;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) {
		Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		System.out.println(cf.getPassword());
		runAdmin admin = new runAdmin();
		admin.run();
		//new GUILogic().run();
	}

}
