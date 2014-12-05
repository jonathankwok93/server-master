import config.Configurations;
import databaseMethods.SwitchMethods;


public class test {

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
