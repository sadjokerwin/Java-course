package bg.sofia.uni.fmi.mjt.simcity.plot;

import bg.sofia.uni.fmi.mjt.simcity.exception.BuildableAlreadyExistsException;
import bg.sofia.uni.fmi.mjt.simcity.exception.BuildableNotFoundException;
import bg.sofia.uni.fmi.mjt.simcity.exception.InsufficientPlotAreaException;
import bg.sofia.uni.fmi.mjt.simcity.property.buildable.Buildable;

import java.util.Map;

public class Plot<E extends Buildable> implements PlotAPI<E> {
    int buildableArea;
    Map<String, E> buildings;

    public Plot(int buildableArea) {
        this.buildableArea = buildableArea;
        buildings = Map.of();
    }

    /**
     * Constructs a buildable on the plot.
     *
     * @param address   the address where the buildable should be constructed.
     * @param buildable the buildable that should be constructed on the given address.
     * @throws IllegalArgumentException        if the address is null or blank.
     * @throws IllegalArgumentException        if the buildable is null.
     * @throws BuildableAlreadyExistsException if the address is already occupied on the plot.
     * @throws InsufficientPlotAreaException   if the required area exceeds the remaining plot area.
     */
    @Override
    public void construct(String address, E buildable) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }

        if (buildable == null) {
            throw new IllegalArgumentException("Buildable cannot be null");
        }

        if (buildableArea < buildable.getArea()) {
            throw new InsufficientPlotAreaException("Insufficient plot area");
        }

        if (buildings.containsKey(address)) {
            throw new BuildableAlreadyExistsException("Buildable already exists");
        } else {
            buildings.put(address, buildable);
        }

        buildableArea -= buildable.getArea();

    }

    /**
     * Constructs multiple buildables on the plot.
     * This method ensures that either all operations are successfully completed
     * or no changes are made to the plot's state.
     *
     * @param buildables a Map containing the addresses and corresponding buildable entities.
     * @throws IllegalArgumentException        if the map of buildables is null, empty.
     * @throws BuildableAlreadyExistsException if any of the addresses is already occupied on the plot.
     * @throws InsufficientPlotAreaException   if the combined area of the provided buildables exceeds
     *                                         the remaining plot area.
     */
    @Override
    public void constructAll(Map<String, E> buildables) {
        if (buildables == null || buildables.isEmpty()) {
            throw new IllegalArgumentException("Buildables cannot be null or empty");
        }

        for (Map.Entry<String, E> entry : buildables.entrySet()) {
            construct(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Demolishes a buildable from the plot.
     *
     * @param address the address of the buildable which should be demolished.
     * @throws IllegalArgumentException   if the provided address is null or blank.
     * @throws BuildableNotFoundException if buildable with such address does not exist on the plot.
     */
    @Override
    public void demolish(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }

        if (!buildings.containsKey(address)) {
            throw new BuildableNotFoundException("Buildable not found");
        } else {
            buildableArea += buildings.get(address).getArea();
            buildings.remove(address);
        }
    }

    /**
     * Demolishes all buildables from the plot.
     */
    @Override
    public void demolishAll() {
        buildings.clear();
        buildableArea = 0;
    }

    /**
     * Retrieves all buildables present on the plot.
     *
     * @return An unmodifiable copy of the buildables present on the plot.
     */
    @Override
    public Map<String, E> getAllBuildables() {
        return Map.copyOf(buildings);
    }

    /**
     * Retrieves the remaining buildable area on the plot.
     *
     * @return The remaining buildable area on the plot.
     */
    @Override
    public int getRemainingBuildableArea() {
        return buildableArea;
    }
}
