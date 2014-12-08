import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class ClientWorker {

	private Socket connectionSocketConnected;
	private CalendarInfo calendarinto = new CalendarInfo();
	private GiantSwitch GS = new GiantSwitch();
	private Encryption encryption = new Encryption();
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
			
			String inputFromClientDecrypted = encryption.decrypt(b);
			String outputToClient = GS.GiantSwitchMethod(inputFromClientDecrypted);
			byte [] output = outputToClient.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = output;
			for (int i =0; i<encrypted.length; i++)
			{
				encrypted[i] = (byte) (encrypted[i] ^ key);
			}
			outToClient.write(encrypted);
			System.out.println("Sending reply to client...");
		}catch(Exception e){
			e.printStackTrace();
			}
		
		}

	
}