import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Connection implements Runnable {
    private Socket socket;
    public Connection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
            Random r = new Random();
            while(true) {
                os.write((byte) r.nextInt(100));
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
