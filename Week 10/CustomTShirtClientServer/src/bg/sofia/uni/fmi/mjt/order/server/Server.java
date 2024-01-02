package bg.sofia.uni.fmi.mjt.order.server;

import bg.sofia.uni.fmi.mjt.order.server.repository.MJTOrderRepository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int SERVER_PORT = 1948;
    private static final int MAX_CLIENTS = 10;
    private static MJTOrderRepository orderRepository;

    public static void main(String[] args) {
        orderRepository = new MJTOrderRepository();
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CLIENTS);
        Thread.currentThread().setName("Server Main Thread");

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started and listening for client requests");

            Socket clientSocket;

            while (true) {
                clientSocket = serverSocket.accept();

                System.out.println("Client " + clientSocket.getInetAddress() + " connected to server");

                ClientRequestHandler clientRequestHandler = new ClientRequestHandler(clientSocket, orderRepository);

                executorService.execute(clientRequestHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException("There is a problem with the server socket", e);
        }
    }
}
