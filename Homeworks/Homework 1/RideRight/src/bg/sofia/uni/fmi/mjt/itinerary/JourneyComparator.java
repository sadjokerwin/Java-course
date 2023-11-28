package bg.sofia.uni.fmi.mjt.itinerary;

import java.util.Comparator;

public class JourneyComparator implements Comparator<Journey> {
    @Override
    public int compare(Journey j1, Journey j2) {
        return j1.getActualPrice().compareTo(j2.getActualPrice());
    }
}
