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
		System.out.println(CC);
		System.out.println(gsonString);

		Socket clientSocket = new Socket("localhost", 3306);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		byte[] input = gsonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);

		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
}