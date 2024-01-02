package bg.sofia.uni.fmi.mjt.order.server.order;

import bg.sofia.uni.fmi.mjt.order.server.destination.Destination;
import bg.sofia.uni.fmi.mjt.order.server.tshirt.TShirt;

public record Order(int id, TShirt tShirt, Destination destination) {
    public Order {
        if (tShirt == null) {
            throw new IllegalArgumentException("TShirt cannot be null");
        }
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
    }

    @Override
    public String toString() {
        /*{"id":-1, "tShirt":{"size":"UNKNOWN", "color":"BLACK"}, "destination":"EUROPE"},
{"id":-1, "tShirt":{"size":"L", "color":"UNKNOWN"}, "destination":"EUROPE"},*/
        return "{\"id\":" + id + ", \"tShirt\":" + tShirt + ", \"destination\":\"" + destination + "\"}";
    }
}
