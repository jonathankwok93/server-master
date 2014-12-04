package NyAdminGUI;

import java.awt.EventQueue;

public class runAdmin {

	public void run(){
		try{
		Login frame = new Login();
		frame.setVisible(true);
		}catch(Exception e){
			run();
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}
}