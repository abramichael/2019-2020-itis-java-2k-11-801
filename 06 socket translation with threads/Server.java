import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int PORT = 1234;
        ServerSocket ss = new ServerSocket(PORT);
        while (true) {
            Socket s = ss.accept();
            System.out.println("New client connected.");
            (new Thread(new Connection(s))).start();
        }

    }
}
