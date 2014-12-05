import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class ClientWorker {

	private Socket connectionSocketConnected;
	private CalendarInfo calendarinto = new CalendarInfo();
	private GiantSwitch swi = new GiantSwitch();
	private encryption encryption = new encryption();
	private String incomingJson;
	
	ClientWorker(Socket connectionSocket){
		connectionSocketConnected = connectionSocket;
		
	}
	
	public void runForrestRun(){
		try{
			System.out.println("Detecting incoming client message...");
			byte[] b = new byte [50000];
			int count = connectionSocketConnected.getInputStream().read(b);
			DataInputStream bias = 
			new DataInputStream(connectionSocketConnected.getInputStream());
			
			DataOutputStream outToClient = 
			new DataOutputStream(connectionSocketConnected.getOutputStream());
			
			outToClient.writeBytes(swi.GiantSwitchMethod(encryption.decrypt(b)));
			System.out.println("Sending reply to client");
		}catch(Exception e){
			e.printStackTrace();
			}
		
		}

	
}