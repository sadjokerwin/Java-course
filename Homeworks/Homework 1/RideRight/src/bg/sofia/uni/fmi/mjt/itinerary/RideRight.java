package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.exception.CityNotKnownException;
import bg.sofia.uni.fmi.mjt.itinerary.exception.NoPathToDestinationException;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Graph;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Node;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SequencedCollection;
import java.util.Set;

public class RideRight implements ItineraryPlanner {
    List<Journey> schedule;
    Graph graph;

    public RideRight(List<Journey> schedule) {
        this.schedule = schedule;
        this.graph = new Graph(schedule);
    }

    public SequencedCollection<Journey> checkDirectTransfer(City start, City destination, Map<City, List<Journey>> graphRepr) throws NoPathToDestinationException {
        List<Journey> citiesFromStartCity = graphRepr.get(start);
        List<Journey> possibleJourneys = new ArrayList<>();

        if (citiesFromStartCity != null) {
            for (Journey iter : citiesFromStartCity) {
                if (iter.to().equals(destination)) {
                    possibleJourneys.add(iter);
                }
            }

            possibleJourneys.sort(new JourneyComparator());
            List<Journey> result = new ArrayList<>();
            result.add(possibleJourneys.get(0));

            return result;

        } else {
            throw new NoPathToDestinationException("There is no path satisfying the conditions");
        }
    }

    private AbstractMap.SimpleEntry<BigDecimal, List<Journey>> reconstructPath(Node destination, City start, City to) {
        List<Journey> result = new ArrayList<>();
        BigDecimal price = BigDecimal.ZERO;

        Journey toAdd;

        while (destination.getParent() != null) {
            toAdd = new Journey(destination.getTransportFromParent(), destination.getParent().getCity(), destination.getCity(), destination.getPriceFromParent());
            result.add(toAdd);
            System.out.println(toAdd.getActualPrice());
            price = price.add(toAdd.getActualPrice());
            destination = destination.getParent();
        }

        return new AbstractMap.SimpleEntry<>(price, result.reversed());
    }

    @Override
    public SequencedCollection<Journey> findCheapestPath(City start, City destination, boolean allowTransfer)
            throws CityNotKnownException, NoPathToDestinationException {
        Map<City, List<Journey>> graphRepr = graph.getGraph();
        Journey directJourney = null;

        if (!graphRepr.containsKey(start) || !graphRepr.containsKey(destination)) {
            throw new CityNotKnownException("The city of departure or the city of arrival is not supported");
        } else if (!allowTransfer) {
            directJourney = checkDirectTransfer(start, destination, graphRepr).getFirst();
        }

        Queue<Node> toSearch = new PriorityQueue<>(Comparator.comparingInt(Node::getfCost));
        Set<City> traversed = new HashSet<>();

        Node startNode = new Node(start, destination);

        toSearch.add(startNode);
        BigDecimal currentNeighbourPrice;

        while (!toSearch.isEmpty()) {
            Node currentNode = toSearch.poll();

            if (currentNode.getCity().equals(destination)) {
                if (directJourney == null || directJourney.getActualPrice().compareTo(reconstructPath(currentNode, start, destination).getKey()) >= 0) {
                    return reconstructPath(currentNode, start, destination).getValue();
                } else {
                    return checkDirectTransfer(start, destination, graphRepr);
                }
            }

            traversed.add(currentNode.getCity());

            for (Journey iter : graphRepr.get(currentNode.getCity())) {
                Node neighbourNode = new Node(iter.to(), destination);
                neighbourNode.setPriceFromParent(iter.price());
                neighbourNode.setTransportFromParent(iter.vehicleType());

                if (traversed.contains(neighbourNode.getCity())) {
                    continue;
                }

                if (currentNode.getCity().equals(start)) {
                    currentNeighbourPrice = iter.getActualPrice();
                } else {
                    currentNeighbourPrice = BigDecimal.valueOf(neighbourNode.getfCost()).add(iter.getActualPrice());
                }

                if (!toSearch.contains(neighbourNode) || currentNeighbourPrice.compareTo(neighbourNode.getgCost()) < 0) {
                    neighbourNode.setgCost(currentNeighbourPrice);
                    neighbourNode.setParent(currentNode);

                    if (!toSearch.contains(neighbourNode)) {
                        toSearch.add(neighbourNode);
                    }
                }
            }
        }
        throw new NoPathToDestinationException("There is no path satisfying the conditions");
    }
}
