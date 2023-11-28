package bg.sofia.uni.fmi.mjt.itinerary.graph;

import bg.sofia.uni.fmi.mjt.itinerary.City;
import bg.sofia.uni.fmi.mjt.itinerary.Journey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;

public class Graph {
    private Map<City, List<Journey>> graph;

    public Graph(List<Journey> journeys) {
        this.graph = new HashMap<>();

        for (Journey iter : journeys) {
            graph.put(iter.from(), new ArrayList<>());
        }

        for (Journey iter : journeys) {
            graph.get(iter.from()).add(iter);
        }
    }

    public String printGraph() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<City, List<Journey>> entry : graph.entrySet()) {
            result.append(entry.getKey()).append(" -> ");
            for (Journey edge : entry.getValue()) {
                result.append("(").append(edge.to()).append(", ").append(edge.price()).append(") ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public Map<City, List<Journey>> getGraph() {
        return graph;
    }
}
