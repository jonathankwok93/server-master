package NyAdminGUI;

import java.awt.EventQueue;

public class runAdmin {

	
	public static void main(String[] args) { //Main metode skal fjernes sener
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