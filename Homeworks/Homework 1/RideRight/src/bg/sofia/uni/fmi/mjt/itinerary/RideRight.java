package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.exception.CityNotKnownException;
import bg.sofia.uni.fmi.mjt.itinerary.exception.NoPathToDestinationException;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Graph;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Node;

import java.math.BigDecimal;
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

    /**
     * Returns a sequenced collection of Journeys representing the cheapest path from the start to the destination City.
     *
     * @param start         - City, from which the itinerary begins
     * @param destination   - the City that needs to be reached
     * @param allowTransfer - a flag parameter whether multiple Journeys with transfer can be returned as a result, or
     *                      only a direct route is expected
     * @throws CityNotKnownException        if the start or destination City is not present
     *                                      in the list of provided Journeys
     * @throws NoPathToDestinationException if there is no path satisfying the conditions
     */
    @Override
    public SequencedCollection<Journey> findCheapestPath(City start, City destination, boolean allowTransfer)
            throws CityNotKnownException, NoPathToDestinationException {
        Map<City, List<Journey>> graphRepr = graph.getGraph();
        if (!graphRepr.containsKey(start) || !graphRepr.containsKey(destination)) {
            throw new CityNotKnownException("The city of departure or the city of arrival is not supported");
        } else if (!allowTransfer) {
            return checkDirectTransfer(start, destination, graphRepr);
        } else {
            Queue<Node> toSearch = new PriorityQueue<>(Comparator.comparingInt(Node::getfCost));
            Set<Node> traversed = new HashSet<>();
            Node startNode = new Node(start, destination);
            toSearch.add(startNode);

            while (!toSearch.isEmpty()) {
                Node currentNode = toSearch.poll();

                if (currentNode.getCity().equals(destination)) {
                    return null;
                }
                traversed.add(new Node(currentNode.getCity(), destination));

                for (Journey iter : graphRepr.get(currentNode.getCity())) {
                    Node neighbourNode = new Node(iter.from(), destination);

                    if (traversed.contains(neighbourNode)) {
                        continue;
                    }

                    BigDecimal currentNeighbourPrice = currentNode.getgCost().add(BigDecimal.valueOf(neighbourNode.getfCost()).add(iter.getActualPrice()));

//                    if (!toSearch.contains(neighbourNode) || currentNeighbourPrice.compareTo(neighbourNode.getgCost()) < 0) {
//                        neighbourNode.setgCost(currentNeighbourPrice);
//                        neighbourNode.setParent(currentNode);
//                    }

                    if (!toSearch.contains(neighbourNode)) {
                        neighbourNode.setgCost(currentNeighbourPrice);
                        neighbourNode.setParent(currentNode);
                        toSearch.add(neighbourNode);
                    } else {

                    }

                }
            }
            throw new NoPathToDestinationException("There is no path satisfying the conditions");
        }
    }
}
