package bg.sofia.uni.fmi.mjt.itinerary.graph;

import bg.sofia.uni.fmi.mjt.itinerary.City;

import java.math.BigDecimal;

public class Node {
    private final City city;
    private BigDecimal gCost;
    private int hCost;
    private Node parent;

    public Node(City city, City end) {
        this.city = city;
        this.gCost = BigDecimal.valueOf(Long.MAX_VALUE);
        this.hCost = calcHeur(end);
        this.parent = null;
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

    public void setgCost(BigDecimal newCost) {
        gCost = newCost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
