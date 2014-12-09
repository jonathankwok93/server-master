import NyAdminGUI.runAdmin;
import config.Configurations;

public class MainMetode {
	
	public static void main(String[] args) {
		Configurations cf = new Configurations();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.err.print(e);
		}
		cf.ReadFile();
		new runAdmin().run();

		try{
			TCPServer TCPS = new TCPServer();
			TCPS.TCPRun();
		}catch(Exception e){
			
		}
		System.out.println(cf.getPassword());
		
	}		
}
	
