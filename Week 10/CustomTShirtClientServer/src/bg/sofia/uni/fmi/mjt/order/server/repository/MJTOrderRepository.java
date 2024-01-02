package bg.sofia.uni.fmi.mjt.order.server.repository;

import bg.sofia.uni.fmi.mjt.order.server.Response;
import bg.sofia.uni.fmi.mjt.order.server.destination.Destination;
import bg.sofia.uni.fmi.mjt.order.server.order.Order;
import bg.sofia.uni.fmi.mjt.order.server.tshirt.Color;
import bg.sofia.uni.fmi.mjt.order.server.tshirt.Size;
import bg.sofia.uni.fmi.mjt.order.server.tshirt.TShirt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MJTOrderRepository implements OrderRepository {
    List<Order> orders;

    AtomicInteger currentId = new AtomicInteger(1);

    public MJTOrderRepository() {
        orders = new ArrayList<>();
    }

    public Response requestElseLogic(boolean isSizeValid, String size, boolean isColorValid, String color,
                                     boolean isDestinationValid, String destination) {
        String message = "invalid: ";
        if (!isSizeValid) {
            message += "size";
            size = "UNKNOWN";
        }
        if (!isColorValid) {
            message += ",color";
            color = "UNKNOWN";
        }
        if (!isDestinationValid) {
            message += ",destination";
            destination = "UNKNOWN";
        }
        orders.add(new Order(-1, new TShirt(Size.getSize(size), Color.valueOf(color)),
            Destination.getDestination(destination)));
        return Response.decline(message);
    }

    /**
     * Creates a new T-Shirt order
     *
     * @param size        - size of the requested T-Shirt
     * @param color       - color of the requested T-Shirt
     * @param destination - destination of the requested T-Shirt
     * @return response which contains status and additional info (orderId or invalid parameters if there are such)
     * @throws IllegalArgumentException if either size, color or destination is null
     */
    @Override
    public Response request(String size, String color, String destination) {
        if (size == null || color == null || destination == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        boolean isSizeValid = Size.contains(size);
        boolean isColorValid = Color.contains(color);
        boolean isDestinationValid = Destination.contains(destination);

        if (isSizeValid && isColorValid && isDestinationValid) {
            Order order = new Order(currentId.get(), new TShirt(Size.getSize(size), Color.valueOf(color)),
                Destination.getDestination(destination));
            orders.add(order);

            currentId.incrementAndGet();

            return Response.create(order.id());
        } else {
            return requestElseLogic(isSizeValid, size, isColorValid, color, isDestinationValid, destination);
        }
    }

    /**
     * Retrieves a T-Shirt order with the given id
     *
     * @param id order id
     * @return response which contains status and an order with the given id
     * @throws IllegalArgumentException if id is a non-positive number
     */
    @Override
    public Response getOrderById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Order id cannot be negative");
        }

        for (Order order : orders) {
            if (order.id() == id) {
                return Response.ok(List.of(order));
            }
        }

        return Response.notFound(id);

    }

    /**
     * Retrieves all T-Shirt orders
     *
     * @return response which contains status and  all T-Shirt orders from the repository, in undefined order.
     * If there are no orders in the repository, returns an empty collection.
     */
    @Override
    public Response getAllOrders() {
        return Response.ok(orders);
    }

    /**
     * Retrieves all successful orders for T-Shirts
     *
     * @return response which contains status and all successful orders for T-Shirts from the repository
     * , in undefined order.
     * If there are no such orders in the repository, returns an empty collection.
     */
    @Override
    public Response getAllSuccessfulOrders() {
        List<Order> successfulOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.id() > 0) {
                successfulOrders.add(order);
            }
        }
        return Response.ok(successfulOrders);
    }
}
