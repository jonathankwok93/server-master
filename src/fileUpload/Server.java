package fileUpload;

import java.io.*;
import java.net.*;

 
class Server
{
    public void serverUpload () throws IOException
    {
    	InputStream inStream = null;
    	OutputStream outStream = null;
    
		ServerSocket server = new ServerSocket(5555);
		
        Socket sk = server.accept();
       
        InputStream input = sk.getInputStream();
        BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedWriter outReader = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
 
        String filename = inReader.readLine();
 
        if ( !filename.equals(""))
        {
            outReader.write("READY\n");
            outReader.flush();
        }
 
        String current = System.getProperty("user.dir");
        
	 	File xy = new File(current + "/" + filename);
	 	
	    long size = xy.length(); 
	    if (size > 20480000) {
	        System.out.println("File is too large. 20mb is max. styr dig selv");
	    }
	    
		FileOutputStream wr = new FileOutputStream(xy);
        byte[] buffer = new byte[sk.getReceiveBufferSize()];
        int bytesReceived = 0;
 
        while((bytesReceived = input.read(buffer))>0)
        {
        
        wr.write(buffer,0,bytesReceived);
          
        }
       
        try{
        	    
    	    File File1 =new File(current + "/" + filename);
    	    File File2 =new File("res\\Uploads\\"+filename);
  	       
    	    inStream = new FileInputStream(File1);
    	    outStream = new FileOutputStream(File2);
    	    
    	    byte[] buff = new byte[1024];
 
    	    int length;
    	  
    	    while ((length = inStream.read(buff)) > 0){
    	    	outStream.write(buffer, 0, length);
    	    }
    	    inStream.close();
    	    outStream.close();
    	    wr.flush();  	    
    	    wr.close();    	    
    	    input.close();    	    
    	    sk.close();   	    
    	    server.close();
    	    File1.delete();
    	    
    	}catch(IOException e){
    	    e.printStackTrace();
    	}
    }
  }
