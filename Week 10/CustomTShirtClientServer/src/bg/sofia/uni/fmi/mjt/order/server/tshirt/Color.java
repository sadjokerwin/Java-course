package bg.sofia.uni.fmi.mjt.order.server.tshirt;

public enum Color {
    BLACK("BLACK"),
    WHITE("WHITE"),
    RED("RED"),
    UNKNOWN("UNKNOWN");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Color getSize(String name) {
        for (Color color : Color.values()) {
            if (color.getName().equals(name)) {
                return color;
            }
        }
        return UNKNOWN;
    }

    public static boolean contains(String name) {
        for (Color color : Color.values()) {
            if (color.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}