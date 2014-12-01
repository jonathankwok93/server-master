import java.net.Socket;


public class ClientWorker {

	private Socket connectionSocketConnected;
	private CalendarInfo calendarinto = new CalendarInfo();
	private GiantSwitch sw3itch = new GiantSwitch();
	private encryption encryption = new encryption();
	private String incomingJson;
	
	ClientWorker(Socket connectionSocket){
		connectionSocketConnected = connectionSocket;
		
	}
	
	public void runForrestRun(){
		
		System.out.println("Connected...");
		
		
	}
	
	
	
}
