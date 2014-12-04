import GUI.GUILogic;
import config.Configurations;
import NyAdminGUI.Login;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) {
		Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		System.out.println(cf.getPassword());
		Login admin = new Login();
		admin.setVisible(true);
		//new GUILogic().run();
	}

}
