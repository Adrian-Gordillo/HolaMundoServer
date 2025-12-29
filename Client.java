import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            System.out.println("Conecting to server...");
            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Successfully Connected!");

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please enter your name:");
            String userInput = stdReader.readLine();
            writer.println(userInput);
            System.out.println("Server:" + reader.readLine());

            socket.close();
            reader.close();
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
