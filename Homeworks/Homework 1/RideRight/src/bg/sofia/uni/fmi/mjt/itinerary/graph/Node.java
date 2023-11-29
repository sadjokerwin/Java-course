package bg.sofia.uni.fmi.mjt.itinerary.graph;

import bg.sofia.uni.fmi.mjt.itinerary.City;
import bg.sofia.uni.fmi.mjt.itinerary.vehicle.VehicleType;

import java.math.BigDecimal;

public class Node {
    private final City city;
    private BigDecimal gCost;
    private int hCost;
    private Node parent;
    private VehicleType transportFromParent;
    private BigDecimal priceFromParent;

    public Node(City city, City end) {
        this.city = city;
        this.gCost = BigDecimal.valueOf(0);
        this.hCost = calcHeur(end);
        this.parent = null;
        this.transportFromParent = VehicleType.BUS;
        this.priceFromParent = BigDecimal.ZERO;
    }

    private int calcHeur(City end) {
        return Math.abs(end.location().x() - city.location().x()) + Math.abs(end.location().y() - city.location().y());
    }

    public City getCity() {
        return city;
    }

    public BigDecimal getgCost() {
        return gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public int getfCost() {
        return hCost + gCost.intValue();
    }

    public Node getParent() {
        return parent;
    }

    public VehicleType getTransportFromParent() {
        return transportFromParent;
    }

    public BigDecimal getPriceFromParent() {
        return priceFromParent;
    }

    public void setgCost(BigDecimal newCost) {
        gCost = newCost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setTransportFromParent(VehicleType vehicleType) {
        this.transportFromParent = vehicleType;
    }

    public void setPriceFromParent(BigDecimal priceFromParent) {
        this.priceFromParent = priceFromParent;
    }
}
