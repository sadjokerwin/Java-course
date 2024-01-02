package bg.sofia.uni.fmi.mjt.order.server.tshirt;

public record TShirt(Size size, Color color) {
    public TShirt {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
    }

    @Override
    public String toString() {
        return "{\"size\":\"" + size + "\", \"color\":\"" + color + "\"}";
    }
}
