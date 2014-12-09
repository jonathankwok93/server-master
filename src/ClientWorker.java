import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class ClientWorker {

	private Socket connectionSocketConnected;
	private GiantSwitch GS = new GiantSwitch();
	private Encryption encryption = new Encryption();
	
	ClientWorker(Socket connectionSocket){
		connectionSocketConnected = connectionSocket;
		
	}

	public void incomingMessage(){
		try{
			System.out.println("Detecting incoming client message...");
			byte[] b = new byte [250000];

			int count = connectionSocketConnected.getInputStream().read(b);
			DataInputStream bias = 
			new DataInputStream(connectionSocketConnected.getInputStream());
			
			DataOutputStream outToClient = 
			new DataOutputStream(connectionSocketConnected.getOutputStream());
			
			String inputFromClientDecrypted = encryption.decrypt(b);
			System.out.println(inputFromClientDecrypted);
			
			System.out.println("Print besked: " + inputFromClientDecrypted);
			System.out.println("input til servere er: " + inputFromClientDecrypted);

			String outputToClient = GS.GiantSwitchMethod(inputFromClientDecrypted);
			byte [] output = outputToClient.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = output;
			for (int i =0; i<encrypted.length; i++)
			{
				encrypted[i] = (byte) (encrypted[i] ^ key);
			}
			System.out.println("Svar til klient burde være: "+ encrypted);
			
			outToClient.write(encrypted);
			System.out.println("Sending reply to client...");
		}catch(Exception e){
			e.printStackTrace();
			}
		
		}
	
}