import java.io.*;
import java.net.*;

import model.database.DatabaseInit;
import JsonClasses.CalendarInfo;

import com.google.gson.stream.JsonReader;

import config.Configurations;

class TCPServer {    
	public static void main(String[] args) throws Exception       {
		
		
	//public static void main(String argv[]) throws Exception       {

		CalendarInfo CI = new CalendarInfo();
		GiantSwitch GS = new GiantSwitch();
		Encryption cryp = new Encryption();
		Configurations cf = new Configurations();
		
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);
		//Creates 2 string to hold random stuff
		String incomingJson;
		//While something is true
		while(true){
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			System.out.println("Server online...");
			Socket connectionSocket = welcomeSocket.accept();
			ClientWorker client = new ClientWorker(connectionSocket);
			client.runForrestRun();
//			Thread thread = new Thread(client, "client");
//			thread.start();
			//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//			byte[] b = new byte[500000];
			//int count = connectionSocket.getInputStream().read(b);
			//System.out.println("count: " + count);
//			ByteArrayInputStream bais = new ByteArrayInputStream(b);
//			String testAfToString = bais.toString();
//			String testUdenKryptering = new String(b);
//			testUdenKryptering = b.toString();

//			String ny3  = cryp.decrypt(b);
			
			//			bais
//			String ny2  = cryp.decrypt(b);
			
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");

			
			DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());		
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			String incommingTransmission;
			incommingTransmission = inFromClient.toString();
			System.out.println("incomming transmission:" + incommingTransmission);
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
//			System.out.println("Outtoclient oprettet!");
			//Sets client sentence equals input from client
			//incomingJson = inFromClient.readLine();			
			
//			String ny  = cryp.decrypt(b);
			
			
//			String ny2 = cryp.decrypt(bais);
			//cryp.StringEncryption(inFromClient.readLine());
//			System.out.println("Besked modtaget!");
//			Sysout recieved message
//			System.out.println("Received: " + ny);
//			String returnSvar = GS.GiantSwitchMethod(ny);		
			//Sends the capitalized message back to client!!
//			outToClient.writeBytes(returnSvar + "\n");
//			System.out.println("svar sendt");
			//BufferedWriter writer = new BufferedWriter(arg0)
			}
	}
} 