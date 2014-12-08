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
			
			String hvadFanden = encryption.decrypt(b);
			System.out.println("hvadFanden: " + hvadFanden);
			String hvadSkalDerSke2 = GS.GiantSwitchMethod(hvadFanden);
			System.out.println("Prøver at printe hvadSkalDerSke2: " + hvadSkalDerSke2);
//			String hvadSkalDerSke = GS.GiantSwitchMethod(encryption.decrypt(b));
//			System.out.println("Prøver at printe hvadSkalDerSke: " + hvadSkalDerSke);
			outToClient.writeBytes(hvadSkalDerSke2);
//			outToClient.writeBytes(GS.GiantSwitchMethod(encryption.decrypt(b)));
			System.out.println("Sending reply to client");
		}catch(Exception e){
			e.printStackTrace();
			}
		
		}

	
}