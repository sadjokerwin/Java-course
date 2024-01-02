package bg.sofia.uni.fmi.mjt.order.server.tshirt;

public enum Size {
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    UNKNOWN("UNKNOWN");

    private final String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Size getSize(String name) {
        for (Size size : Size.values()) {
            if (size.getName().equals(name)) {
                return size;
            }
        }
        return UNKNOWN;
    }

    public static boolean contains(String name) {
        for (Size size : Size.values()) {
            if (size.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}