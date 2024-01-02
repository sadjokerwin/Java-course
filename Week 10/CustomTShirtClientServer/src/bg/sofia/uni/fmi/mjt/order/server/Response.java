package bg.sofia.uni.fmi.mjt.order.server;

import bg.sofia.uni.fmi.mjt.order.server.order.Order;

import java.util.Collection;

public record Response(Status status, String additionalInfo, Collection<Order> orders) {
    private enum Status {
        OK, CREATED, DECLINED, NOT_FOUND
    }

    /**
     * Creates a response
     *
     * @param id order id
     * @return response with status Status.CREATED and with proper message for additional info
     */
    public static Response create(int id) {
        return new Response(Status.CREATED, "ORDER_ID=" + id, null);
    }

    /**
     * Creates a response
     *
     * @param orders the orders which will be returned to the client
     * @return response with status Status.OK and Collection of orders
     */
    public static Response ok(Collection<Order> orders) {
        /*
        => get all
=> {"status":"OK", "orders":[{"id":1, "tShirt":{"size":"L", "color":"BLACK"}, "destination":"EUROPE"},
{"id":-1, "tShirt":{"size":"UNKNOWN", "color":"BLACK"}, "destination":"EUROPE"},
{"id":-1, "tShirt":{"size":"L", "color":"UNKNOWN"}, "destination":"EUROPE"},
{"id":-1, "tShirt":{"size":"L", "color":"BLACK"}, "destination":"UNKNOWN"},
{"id":-1, "tShirt":{"size":"UNKNOWN", "color":"UNKNOWN"}, "destination":"UNKNOWN"}]}
         */
        return new Response(Status.OK, null, orders);
    }

    /**
     * Creates a response
     *
     * @param errorMessage the message which will be sent as additionalInfo
     * @return response with status Status.DECLINED and errorMessage as additionalInfo
     */
    public static Response decline(String errorMessage) {
        return new Response(Status.DECLINED, errorMessage, null);
    }

    /**
     * Creates a response
     *
     * @param id order id
     * @return response with status Status.NOT_FOUND and with proper message for additional info
     */
    public static Response notFound(int id) {
        //{"status":"NOT_FOUND", "additionalInfo":"Order with id = 2 does not exist."}
//        return null;
        return new Response(Status.NOT_FOUND, "Order with id = " + id + " does not exist.", null);
    }

    @Override
    public String toString() {
        //{"status":"CREATED", "additionalInfo":"ORDER_ID=1"}
        if (additionalInfo == null) {
            return "{\"status\":\"" + status + "\"";
        } else {
            return "{\"status\":\"" + status + "\", \"additionalInfo\":\"" + additionalInfo + "\"}";
        }
    }
}
