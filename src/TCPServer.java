import java.net.*;

class TCPServer 
{    
	public static void main(String[] args) throws Exception       
	{
				
		//Remove the warning that the socket is never closed, since we are running a server.
		@SuppressWarnings("resource")
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);

		while(true)
		{
			//Server online
			System.out.println("Server online...\nWaiting for input from clients...");
			//Creates a socket
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
			//Runs runForrestRun-method in the ClientWorker class
			ClientWorker client = new ClientWorker(connectionSocket);
			client.incomingMessage();
		}		
	}
	
	public void TCPRun () throws Exception       
	{
				
		//Remove the warning that the socket is never closed, since we are running a server.
		@SuppressWarnings("resource")
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);

		while(true)
		{
			//Server online
			System.out.println("Server online...\nWaiting for input from clients...");
			//Creates a socket
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
			//Runs runForrestRun-method in the ClientWorker class
			ClientWorker client = new ClientWorker(connectionSocket);
			client.incomingMessage();
		}		
	}
} 