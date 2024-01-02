package bg.sofia.uni.fmi.mjt.order.server.destination;

public enum Destination {
    EUROPE("EUROPE"),
    NORTH_AMERICA("NORTH_AMERICA"),
    AUSTRALIA("AUSTRALIA"),
    UNKNOWN("UNKNOWN");

    private final String name;

    Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Destination getDestination(String name) {
        for (Destination destination : Destination.values()) {
            if (destination.getName().equals(name)) {
                return destination;
            }
        }
        return UNKNOWN;
    }

    public static boolean contains(String name) {
        for (Destination destination : Destination.values()) {
            if (destination.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}