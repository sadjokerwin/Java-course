package bg.sofia.uni.fmi.mjt.itinerary;

import java.util.List;

public class RideRight implements ItineraryPlanner {
    List<Journey> schedule;

    public RideRight(List<Journey> schedule) {
        this.schedule = schedule;
    }
}
