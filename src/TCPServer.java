import java.io.*;
import java.net.*;
import JsonClasses.CalendarInfo;

import com.google.gson.stream.JsonReader;

class TCPServer {    
	public static void main(String[] args) throws Exception       {
	//public static void main(String argv[]) throws Exception       {

		CalendarInfo CI = new CalendarInfo();
		GiantSwitch GS = new GiantSwitch();
		encryption cryp = new encryption();
		

		
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);
		//Creates 2 string to hold random stuff
		String incomingJson;
		//While something is true
		while(true){
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("forbindelse Oprettet!");
			//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			byte[] b = new byte[500000];
			System.out.println("Byte er blevet sat");
			//int count = connectionSocket.getInputStream().read(b);
			//System.out.println("count: " + count);
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			System.out.println("Hvad er bais?" + bais);
			System.out.println("Hvad er b?" + b);
			String ny2  = cryp.decrypt(b);
			System.out.println("Hvad er ny2? " + ny2);
			
			DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());		
			
			Object incommingTransmission;
			incommingTransmission = inFromClient.toString();
			System.out.println("incomming transmission:" + incommingTransmission);
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			System.out.println("Outtoclient oprettet!");
			//Sets client sentence equals input from client
			//incomingJson = inFromClient.readLine();			
			
			String ny  = cryp.decrypt(b);

//			String ny2 = cryp.decrypt(bais);
			System.out.println("hej" + ny);
			//cryp.StringEncryption(inFromClient.readLine());
			System.out.println("Besked modtaget!");
			//Sysout recieved message
			System.out.println("Received: " + ny);
			String returnSvar = GS.GiantSwitchMethod(ny);		
			//Sends the capitalized message back to client!!
			outToClient.writeBytes(returnSvar + "\n");
			System.out.println("svar sendt");
			//BufferedWriter writer = new BufferedWriter(arg0)
			}
		}
	
} 