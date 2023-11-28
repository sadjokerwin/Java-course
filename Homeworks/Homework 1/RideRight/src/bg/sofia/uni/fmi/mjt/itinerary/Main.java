package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.exception.CityNotKnownException;
import bg.sofia.uni.fmi.mjt.itinerary.exception.NoPathToDestinationException;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Graph;

import java.math.BigDecimal;
import java.util.List;

import static bg.sofia.uni.fmi.mjt.itinerary.vehicle.VehicleType.BUS;
import static bg.sofia.uni.fmi.mjt.itinerary.vehicle.VehicleType.PLANE;

public class Main {
    public static void main(String[] args) throws CityNotKnownException, NoPathToDestinationException {
        // test your classes here

        //test Graph
//
//        Journey journey1 = new Journey(VehicleType.BUS, new City("Sofia", new Location(1, 1)),
//                new City("Plovdiv", new Location(2, 2)), new BigDecimal(10));
//
//        Journey journey2 = new Journey(VehicleType.BUS, new City("Plovdiv", new Location(2, 2)),
//                new City("Burgas", new Location(4, 4)), new BigDecimal(10));
//
//        Journey journey3 = new Journey(VehicleType.BUS, new City("Burgas", new Location(4, 4)),
//                new City("Varna", new Location(6, 6)), new BigDecimal(10));
//
//        Journey journey4 = new Journey(VehicleType.BUS, new City("Sofia", new Location(1, 1)),
//                new City("Montana", new Location(4, 1)), new BigDecimal(10));
//
//        List<Journey> schedule = new ArrayList<>();
//        schedule.add(journey1);
//        schedule.add(journey2);
//        schedule.add(journey3);
//        schedule.add(journey4);
//
//        Graph graph = new Graph(schedule);
//        System.out.println(graph.printGraph());

        //pull info for the graph from here: https://github.com/fmi/java-course/blob/master/homeworks/01-rideright/diagrams/example-diagram.png

        //test ItineraryPlanner
        City sofia = new City("Sofia", new Location(0, 2000));
        City plovdiv = new City("Plovdiv", new Location(4000, 1000));
        City varna = new City("Varna", new Location(9000, 3000));
        City burgas = new City("Burgas", new Location(9000, 1000));
        City ruse = new City("Ruse", new Location(7000, 4000));
        City blagoevgrad = new City("Blagoevgrad", new Location(0, 1000));
        City kardzhali = new City("Kardzhali", new Location(3000, 0));
        City tarnovo = new City("Tarnovo", new Location(5000, 3000));

        List<Journey> schedule = List.of(
                new Journey(BUS, sofia, blagoevgrad, new BigDecimal("20")),
                new Journey(BUS, blagoevgrad, sofia, new BigDecimal("20")),
                new Journey(PLANE, varna, sofia, new BigDecimal("290")),
                new Journey(BUS, sofia, plovdiv, new BigDecimal("90")),
                new Journey(BUS, plovdiv, sofia, new BigDecimal("90")),
                new Journey(BUS, plovdiv, kardzhali, new BigDecimal("50")),
                new Journey(BUS, kardzhali, plovdiv, new BigDecimal("50")),
                new Journey(BUS, plovdiv, burgas, new BigDecimal("90")),
                new Journey(BUS, burgas, plovdiv, new BigDecimal("90")),
                new Journey(BUS, burgas, varna, new BigDecimal("60")),
                new Journey(BUS, varna, burgas, new BigDecimal("60")),
                new Journey(BUS, sofia, tarnovo, new BigDecimal("150")),
                new Journey(BUS, tarnovo, sofia, new BigDecimal("150")),
                new Journey(BUS, plovdiv, tarnovo, new BigDecimal("40")),
                new Journey(BUS, tarnovo, plovdiv, new BigDecimal("40")),
                new Journey(BUS, tarnovo, ruse, new BigDecimal("70")),
                new Journey(BUS, ruse, tarnovo, new BigDecimal("70")),
                new Journey(BUS, varna, ruse, new BigDecimal("70")),
                new Journey(BUS, ruse, varna, new BigDecimal("70")),
                new Journey(PLANE, burgas, varna, new BigDecimal("200")),
                new Journey(PLANE, burgas, sofia, new BigDecimal("150")),
                new Journey(PLANE, sofia, burgas, new BigDecimal("250")),
                new Journey(PLANE, varna, burgas, new BigDecimal("200")),
                new Journey(PLANE, sofia, varna, new BigDecimal("300"))
        );

        Graph g1 = new Graph(schedule);
        System.out.println(g1.printGraph());
//        RideRight rideRight = new RideRight(schedule);
//        System.out.println(rideRight.findCheapestPath(varna, burgas, false));
    }
}
