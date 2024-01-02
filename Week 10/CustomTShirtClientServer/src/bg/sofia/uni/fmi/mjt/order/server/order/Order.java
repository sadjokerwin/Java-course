package bg.sofia.uni.fmi.mjt.order.server.order;

public record Order(int id, TShirt tShirt, Destination destination) {
    public Order {
        if (id < 0) {
            throw new IllegalArgumentException("Order id cannot be negative");
        }
        if (tShirt == null) {
            throw new IllegalArgumentException("TShirt cannot be null");
        }
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
    }
}
