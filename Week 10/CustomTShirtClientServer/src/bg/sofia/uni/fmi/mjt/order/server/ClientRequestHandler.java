package bg.sofia.uni.fmi.mjt.order.server;

import bg.sofia.uni.fmi.mjt.order.server.repository.MJTOrderRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRequestHandler implements Runnable {
    private Socket socket;
    private static final int SIZE_INDEX = 1;
    private static final int COLOR_INDEX = 2;
    private static final int DESTINATION_INDEX = 3;
    private static final int ID_INDEX = 16;

    private MJTOrderRepository repository;

    public ClientRequestHandler(Socket socket, MJTOrderRepository repository) {
        this.socket = socket;
        this.repository = repository;
    }

    private Response requestTShirt(PrintWriter out, String request) {
        String[] tokens = request.split(" ");
        String size = tokens[SIZE_INDEX].split("=")[1];
        String color = tokens[COLOR_INDEX].split("=")[1];
        String destination = tokens[DESTINATION_INDEX].split("=")[1];

        return repository.request(size, color, destination);
    }

    public void whileParser(BufferedReader in, PrintWriter out) throws IOException {
        String inputLine;
        while ((inputLine = in.readLine()) != null) { // read the message from the client
            System.out.println("Message received from client: " + inputLine);

            if (inputLine.equals("get all")) {
                System.out.println("Message received from client: " + inputLine + "1st if");
                Response responseAll = repository.getAllOrders();
                out.println(responseAll.toString() + ", \"orders\":" + responseAll.orders().toString() + "}");
            } else if (inputLine.equals("get all-successful")) {
                System.out.println("Message received from client: " + inputLine + "2nd if");
                Response responseAllSuccessful = repository.getAllSuccessfulOrders();
                out.println(responseAllSuccessful.toString());
            } else if (inputLine.startsWith("get my-order id=")) {
                System.out.println("Message received from client: " + inputLine + "3rd if");
                Response responseOrderById =
                    repository.getOrderById(Integer.parseInt(inputLine.substring(ID_INDEX, inputLine.length())));
                out.println(
                    responseOrderById.toString());
            } else if (inputLine.startsWith("request size=")) {
                System.out.println("Message received from client: " + inputLine + "4th if");

                Response responseRequestTShirt = requestTShirt(out, inputLine);
                out.println(responseRequestTShirt.toString());
            } else {
                System.out.println("Message received from client: " + inputLine + "else");
                out.println("Unknown command");
            }
        }
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Request Handler for " + socket.getRemoteSocketAddress());

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            whileParser(in, out);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
