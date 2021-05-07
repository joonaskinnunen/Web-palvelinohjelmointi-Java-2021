
import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        // luodaan palvelin porttiin 8080
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // odotetaan pyyntöä
            Socket socket = server.accept();

            // luetaan pyyntö
            Scanner lukija = new Scanner(socket.getInputStream());
            // ...

            // kirjoitetaan vastaus
            PrintWriter kirjoittaja = new PrintWriter(socket.getOutputStream());
            String content = new String ( Files.readAllBytes( Paths.get("index.html") ) );
            kirjoittaja.write(content);

            // vapautetaan resurssit
            lukija.close();
            kirjoittaja.close();
            socket.close();
        }

    }
}
