import java.io.BufferedReader;
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
		System.out.println("Hvad er input?   " + input);
		System.out.println("Hvad er input?       " + input);
		byte key = (byte) 3.1470;
		System.out.println("Hvad er key?         " + key);
		byte[] encrypted = input;
		System.out.println("Hvad er encrypted?   " + encrypted);
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		byte[] input2 = testString.getBytes();
		System.out.println("Hvad er encrypted?2   " + encrypted);
		outToServer.write(input);
//		outToServer.write(input);
//		System.out.println("Hvad er encrypted?3  " + encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
	
	
}