package bg.sofia.uni.fmi.mjt.order.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int SERVER_PORT = 1948;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            Thread.currentThread().setName("Echo client thread " + socket.getLocalPort());

            System.out.println("Connected to server");

            while (true) {
                System.out.println("Enter a command");
                String command = scanner.nextLine();

                if (command.equals("disconnect")) {
                    break;
                }

                writer.println(command);

                String response = reader.readLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the server socket", e);
        }
    }
}
