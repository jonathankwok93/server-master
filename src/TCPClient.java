import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonClasses.*;

public class TCPClient {
	
	
	public static void main(String[] args) throws Exception {
		Encryption decryption = new Encryption();

		String sendToServer = "Hvad vil du gerne sende til serveren?";
		
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
	}
	
	
}