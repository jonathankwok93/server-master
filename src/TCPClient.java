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
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();
		Encryption decryption = new Encryption();
		CreateCalendar CC = new CreateCalendar();
		CC.setCalendarName("Din mors kalendar2");
		CC.setPublicOrPrivate(1);
		CC.setUserName("John");
		String gsonString = gson.toJson(CC);
		String testString = "testFTW";
		System.out.println("Hvad er CC?          " + CC);
		System.out.println("Hvad er gsonString?  " + gsonString);

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//		byte[] input = gsonString.getBytes();
		byte[] input = testString.getBytes();
		System.out.println("Hvad er input?       " + input);
		byte key = (byte) 3.1470;
		System.out.println("Hvad er key?         " + key);
		byte[] encrypted = input;
		System.out.println("Hvad er encrypted?   " + encrypted);
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
//		byte[] input2 = testString.getBytes();
		outToServer.write(input);
//		outToServer.write(input);
//		System.out.println("Hvad er encrypted?3  " + encrypted);
		outToServer.flush();
		System.out.println("Server er blevet flushed");
		System.out.println("Prøver at åbne inFromServer");
		DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
//		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
//				clientSocket.getInputStream()));
		System.out.println("inFromServer er åbnet. Prøver at læse hvad der kommer fra serveren.");
		byte[] b = new byte [250000];
		inFromServer.read(b);
		String modifiedSentence3 = new String(b);
		System.out.println("modifiedSentence3 er lig: " + modifiedSentence3);

		String modifiedSentence2 = decryption.decrypt(b);
//		modifiedSentence = inFromServer.readLine();
		System.out.println("Modtaget modifiedSentece fra serveren");
		System.out.println(modifiedSentence2);
		System.out.println("FROM SERVER: " + modifiedSentence2);
		clientSocket.close();
	}
	
	
}