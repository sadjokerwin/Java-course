package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.graph.Graph;
import bg.sofia.uni.fmi.mjt.itinerary.vehicle.VehicleType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test your classes here

        //test Graph

        Journey journey1 = new Journey(VehicleType.BUS, new City("Sofia", new Location(1, 1)),
                new City("Plovdiv", new Location(2, 2)), new BigDecimal(10));

        Journey journey2 = new Journey(VehicleType.BUS, new City("Plovdiv", new Location(2, 2)),
                new City("Burgas", new Location(4, 4)), new BigDecimal(10));

        Journey journey3 = new Journey(VehicleType.BUS, new City("Burgas", new Location(4, 4)),
                new City("Varna", new Location(6, 6)), new BigDecimal(10));

        Journey journey4 = new Journey(VehicleType.BUS, new City("Sofia", new Location(1, 1)),
                new City("Montana", new Location(4, 1)), new BigDecimal(10));

        List<Journey> schedule = new ArrayList<>();
        schedule.add(journey1);
        schedule.add(journey2);
        schedule.add(journey3);
        schedule.add(journey4);

        Graph graph = new Graph(schedule);
        System.out.println(graph.printGraph());

    }
}
