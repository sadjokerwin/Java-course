package bg.sofia.uni.fmi.mjt.space;

import bg.sofia.uni.fmi.mjt.space.exception.CipherException;
import bg.sofia.uni.fmi.mjt.space.exception.TimeFrameMismatchException;
import bg.sofia.uni.fmi.mjt.space.mission.Detail;
import bg.sofia.uni.fmi.mjt.space.mission.Mission;
import bg.sofia.uni.fmi.mjt.space.mission.MissionStatus;
import bg.sofia.uni.fmi.mjt.space.rocket.Rocket;
import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class MJTSpaceScanner implements SpaceScannerAPI {

    private final List<Mission> missions;
    private final List<Rocket> rockets;

    public MJTSpaceScanner(Reader missionsReader, Reader rocketsReader, SecretKey secretKey) {
        try (var readerBuffer = new BufferedReader(missionsReader)) {
            missions = readerBuffer.lines().skip(1).map(Mission::of).toList();
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from the file", e);
        }

        try (var readerBuffer = new BufferedReader(rocketsReader)) {
            rockets = readerBuffer.lines().skip(1).map(Rocket::of).toList();
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from the file", e);
        }
    }

    /**
     * Returns all missions in the dataset.
     * If there are no missions, return an empty collection.
     */
    @Override
    public Collection<Mission> getAllMissions() {
        return missions;
    }

    /**
     * Returns all missions in the dataset with a given status.
     * If there are no missions, return an empty collection.
     *
     * @param missionStatus the status of the missions
     * @throws IllegalArgumentException if missionStatus is null
     */
    @Override
    public Collection<Mission> getAllMissions(MissionStatus missionStatus) {
        if (missionStatus == null) {
            throw new IllegalArgumentException("Mission status is null");
        }
        return missions.stream()
            .filter(mission -> mission.missionStatus().equals(missionStatus))
            .toList();
    }

    /**
     * Returns the company with the most successful missions in a given time period.
     * If there are no missions, return an empty string.
     *
     * @param from the inclusive beginning of the time frame
     * @param to   the inclusive end of the time frame
     * @throws IllegalArgumentException   if from or to is null
     * @throws TimeFrameMismatchException if to is before from
     */
    @Override
    public String getCompanyWithMostSuccessfulMissions(LocalDate from, LocalDate to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("From or to is null");
        } else if (to.isBefore(from)) {
            throw new TimeFrameMismatchException("To date is before from data");
        }

        Map<String, Long> result = missions.stream()
            .filter(mission -> mission.date().isAfter(from) && mission.date().isBefore(to)
                || mission.date().equals(from) || mission.date().equals(to))
            .filter(mission -> mission.missionStatus().equals(MissionStatus.SUCCESS))
            .collect(Collectors.groupingBy(Mission::company, Collectors.counting()));


        if (result.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .isPresent()) {
            return result.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
        } else {
            return "";
        }
    }

    /**
     * Groups missions by country.
     * If there are no missions, return an empty map.
     */
    @Override
    public Map<String, Collection<Mission>> getMissionsPerCountry() {
        return missions.stream()
            .collect(Collectors.groupingBy(mission -> Mission.getCountry(mission.location()), Collectors.toCollection(
                ArrayList::new)));
    }

    /**
     * Returns the top N least expensive missions, ordered from cheapest to more expensive.
     * If there are no missions, return an empty list.
     *
     * @param n             the number of missions to be returned
     * @param missionStatus the status of the missions
     * @param rocketStatus  the status of the rockets
     * @throws IllegalArgumentException if n is less than ot equal to 0, missionStatus or rocketStatus is null
     */
    @Override
    public List<Mission> getTopNLeastExpensiveMissions(int n, MissionStatus missionStatus, RocketStatus rocketStatus) {
        if (n <= 0) {
            throw new IllegalArgumentException("N is less than 0");
        } else if (missionStatus == null) {
            throw new IllegalArgumentException("Mission status is null");
        } else if (rocketStatus == null) {
            throw new IllegalArgumentException("Rocket status is null");
        }

        List<Mission> result = missions.stream().
            filter(
                mission -> mission.missionStatus().equals(missionStatus) && mission.rocketStatus().equals(rocketStatus))
            .filter(mission -> !mission.cost().equals(Optional.empty()))
            .toList();

        return result.stream().sorted(Comparator.comparing(mission -> mission.cost().orElse(0.0))).limit(n).toList();

    }

    public static String findMostOccurencesList(List<String> locations) {
        return locations.stream()
            .collect(Collectors.groupingBy(location -> location, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    /**
     * Returns the most desired location for missions per company.
     * If there are no missions, return an empty map.
     */
    @Override
    public Map<String, String> getMostDesiredLocationForMissionsPerCompany() {
//        return missions.stream().collect(Collectors.groupingBy(mission -> Mission.getCountry(mission.location()), Collectors.toCollection(
//            ArrayList::new)));

        Map<String, List<String>> helper = missions.stream().collect(
            Collectors.groupingBy(Mission::company, Collectors.mapping(Mission::location, Collectors.toList())));

        return helper.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> findMostOccurencesList(entry.getValue())
            ));
    }

    /**
     * Returns the company mapped to its location with most successful missions.
     * If there are no missions, return an empty map.
     *
     * @param from the inclusive beginning of the time frame
     * @param to   the inclusive end of the time frame
     * @throws IllegalArgumentException   if from or to is null
     * @throws TimeFrameMismatchException if to is before from
     */
    @Override
    public Map<String, String> getLocationWithMostSuccessfulMissionsPerCompany(LocalDate from, LocalDate to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("From or to is null");
        } else if (to.isBefore(from)) {
            throw new TimeFrameMismatchException("To date is before from data");
        }

        Map<String, List<String>> helper =
            missions.stream().filter(mission -> mission.missionStatus().equals(MissionStatus.SUCCESS))
                .collect(
                    Collectors.groupingBy(Mission::company,
                        Collectors.mapping(Mission::location, Collectors.toList())));

        return helper.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> findMostOccurencesList(entry.getValue())
            ));

    }

    /**
     * Returns all rockets in the dataset.
     * If there are no rockets, return an empty collection.
     */
    @Override
    public Collection<Rocket> getAllRockets() {
        return rockets;
    }

    /**
     * Returns the top N tallest rockets, in decreasing order.
     * If there are no rockets, return an empty list.
     *
     * @param n the number of rockets to be returned
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    @Override
    public List<Rocket> getTopNTallestRockets(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is less than or equal to 0");
        }

        return rockets.stream()
            .filter(rocket -> !rocket.height().equals(Optional.empty()))
            .sorted(Comparator.comparing(rocket -> rocket.height().orElse(0.0))).toList()
            .reversed().stream().limit(n).toList();
    }

    /**
     * Returns a mapping of rockets (by name) to their respective wiki page (if present).
     * If there are no rockets, return an empty map.
     */
    @Override
    public Map<String, Optional<String>> getWikiPageForRocket() {
        return rockets.stream().collect(Collectors.toMap(Rocket::name, Rocket::wiki));
    }

    /**
     * Returns the wiki pages for the rockets used in the N most expensive missions.
     * If there are no missions, return an empty list.
     *
     * @param n             the number of missions to be returned
     * @param missionStatus the status of the missions
     * @param rocketStatus  the status of the rockets
     * @throws IllegalArgumentException if n is less than ot equal to 0, or missionStatus or rocketStatus is null
     */
    @Override
    public List<String> getWikiPagesForRocketsUsedInMostExpensiveMissions(int n, MissionStatus missionStatus,
                                                                          RocketStatus rocketStatus) {
        if (n <= 0) {
            throw new IllegalArgumentException("N is less than 0");
        } else if (missionStatus == null) {
            throw new IllegalArgumentException("Mission status is null");
        } else if (rocketStatus == null) {
            throw new IllegalArgumentException("Rocket status is null");
        }

        List<Mission> helperMissions = missions.stream()
            .filter(mission -> !mission.cost().equals(Optional.empty()))
            .filter(mission -> mission.missionStatus().equals(missionStatus) && mission.rocketStatus().equals(
                rocketStatus))
            .sorted(Comparator.comparing(mission -> mission.cost().orElse(0.0)))
            .toList().reversed().stream().limit(n).toList();

        List<String> helperRockets = helperMissions.stream()
            .map(Mission::detail)
            .map(Detail::rocketName)
            .toList();

        return rockets.stream()
            .filter(rocket -> helperRockets.contains(rocket.name()))
            .map(Rocket::wiki)
            .filter(wiki -> !wiki.equals(Optional.empty()))
            .map(Optional::get)
            .toList();
    }

    /**
     * Saves the name of the most reliable rocket in a given time period in an encrypted format.
     *
     * @param outputStream the output stream where the encrypted result is written into
     * @param from         the inclusive beginning of the time frame
     * @param to           the inclusive end of the time frame
     * @throws IllegalArgumentException   if outputStream, from or to is null
     * @throws CipherException            if the encrypt/decrypt operation cannot be completed successfully
     * @throws TimeFrameMismatchException if to is before from
     */
    @Override
    public void saveMostReliableRocket(OutputStream outputStream, LocalDate from, LocalDate to) throws CipherException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream is null");
        } else if (from == null || to == null) {
            throw new IllegalArgumentException("From or to is null");
        } else if (to.isBefore(from)) {
            throw new TimeFrameMismatchException("To date is before from data");
        }
    }
}
