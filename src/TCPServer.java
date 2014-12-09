import java.net.*;

class TCPServer 
{    
	public static void main(String[] args) throws Exception       
	{


		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(8888);

		while(true)
		{
			System.out.println("Server online...\nWaiting for input from clients...");
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
			ClientWorker client = new ClientWorker(connectionSocket);
			client.incomingMessage();
		}		
	}

	public void TCPRun () throws Exception       
	{

		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(8888);

		while(true)
		{
			System.out.println("Server online...\nWaiting for input from clients...");
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("IP: " + connectionSocket.getLocalAddress() + " has connected to the server");
			ClientWorker client = new ClientWorker(connectionSocket);
			client.incomingMessage();
		}		
	}
} 