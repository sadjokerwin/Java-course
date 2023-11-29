package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.vehicle.VehicleType;

import java.math.BigDecimal;

public record Journey(VehicleType vehicleType, City from, City to, BigDecimal price) {
    public BigDecimal getActualPrice() {
        return (price.multiply(BigDecimal.valueOf(1).add(vehicleType.getGreenTax()))).
                add(BigDecimal.valueOf(Math.abs(to.location().x() - from.location().x()) + Math.abs(to.location().y() - from.location().y())));
    }

    @Override
    public String toString() {
        return "Journey{" + vehicleType + ", from=" + from.name() + ", to=" + to.name() + ", price=" + price + '}';
    }
}
