
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("================\n" + "THE INTERNETS!\n" + "================");
        System.out.print("Where to? ");
        String osoite = input.nextLine();
        int portti = 80;

// muodosta yhteys
        Socket socket = new Socket(osoite, portti);

// lähetä viesti palvelimelle
        PrintWriter kirjoittaja = new PrintWriter(socket.getOutputStream());
        kirjoittaja.println("GET / HTTP/1.1");
        kirjoittaja.println("Host: " + osoite);
        kirjoittaja.println();
        kirjoittaja.flush();

// lue vastaus palvelimelta
        Scanner lukija = new Scanner(socket.getInputStream());
        System.out.println("==========\n" + "RESPONSE\n" + "==========");
        while (lukija.hasNextLine()) {
            System.out.println(lukija.nextLine());
        }

    }
}
