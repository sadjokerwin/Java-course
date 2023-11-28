package bg.sofia.uni.fmi.mjt.itinerary;

import bg.sofia.uni.fmi.mjt.itinerary.exception.CityNotKnownException;
import bg.sofia.uni.fmi.mjt.itinerary.exception.NoPathToDestinationException;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Graph;
import bg.sofia.uni.fmi.mjt.itinerary.graph.Node;

import java.util.*;

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

            possibleJourneys.sort(new Comparator<Journey>() {
                @Override
                public int compare(Journey o1, Journey o2) {
                    return o1.price().compareTo(o2.price());
                }
            });
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
            Queue<Node> toSearch = new PriorityQueue<>();
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
                    if (traversed.contains(new Node(iter.from(), destination))) {
                        continue;
                    } else {

                    }
                }
            }

        }
    }
}
