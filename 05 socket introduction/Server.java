import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String [] args) throws IOException{
	
		final int PORT = 1234;
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("Starting server on " + PORT);
		System.out.print("Waiting for client...");
		Socket s = ss.accept();
		System.out.println("Connected!");
		OutputStream os = s.getOutputStream();
		int x = 100;
		os.write(x);
		System.out.println("Sent to client: " + x);
	}
	
}