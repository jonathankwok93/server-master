import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {
	
	public static String toServer(String sendToServer) throws Exception {
		Encryption decryption = new Encryption();

		//sendToServer = "getCBSCalendar";
		
		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		
		byte[] input = sendToServer.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		
		for (int i = 0; i < encrypted.length; i++)
		{
			encrypted[i] = (byte) (encrypted[i] ^ key);
		}
		
		outToServer.write(input);
		outToServer.flush();
		
		byte[] b = new byte [50000];
		inFromServer.read(b);

		String answerFromServerDecrypted = decryption.decrypt(b);
		System.out.println("FROM SERVER: " + answerFromServerDecrypted);
		clientSocket.close();
		return answerFromServerDecrypted;
		
	}
		
}