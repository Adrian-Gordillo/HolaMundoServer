import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Connecting to Client...");
            Socket socket = serverSocket.accept();
            System.out.println("Successfully Connected!");

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String input = reader.readLine();
            System.out.println("Client:" + input);
            writer.println("Hello," + input);

            writer.close();
            reader.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
