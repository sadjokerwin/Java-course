import bg.sofia.uni.fmi.mjt.space.mission.Detail;
import bg.sofia.uni.fmi.mjt.space.mission.Mission;
import bg.sofia.uni.fmi.mjt.space.rocket.Rocket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
//        BufferedReader missionReader = new BufferedReader(new FileReader("./data/all-missions-from-1957.csv"));
        BufferedReader missionReader = new BufferedReader(new FileReader("./data/test.csv"));

        List<Mission> missions = new ArrayList<>();
        try (var readerBuffer = new BufferedReader(missionReader)) {
            missions = readerBuffer.lines().skip(1).map(Mission::of).toList();
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from the file", e);
        }


        List<Rocket> rockets = new ArrayList<>();
        Reader rocketReader = new FileReader("./data/all-rockets-from-1957.csv");
        try (var readerBuffer = new BufferedReader(rocketReader)) {
            rockets = readerBuffer.lines().skip(1).map(Rocket::of).toList();
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from the file", e);
        }

        String missionStatus = "Success";
        String rocketStatus = "StatusActive";
        int n = 2;

        List<Mission> helperMissions = missions.stream()
            .filter(mission -> !mission.cost().equals(Optional.empty()))
               .filter(mission -> mission.missionStatus().toString().equals(missionStatus))
                .filter(mission -> mission.rocketStatus().toString().equals(rocketStatus))
            .sorted(Comparator.comparing(mission -> mission.cost().orElse(0.0)))
            .toList().reversed().stream().limit(n).toList();

        System.out.println(helperMissions);

        List<String> helperRockets = helperMissions.stream()
            .map(Mission::detail)
            .map(Detail::rocketName)
            .toList();

        List<String> ls1 = rockets.stream()
            .filter(rocket -> helperRockets.contains(rocket.name()))
            .map(Rocket::wiki)
            .filter(wiki -> !wiki.equals(Optional.empty()))
            .map(Optional::get)
            .toList();

        System.out.println(ls1);
//        for (Rocket rocket : rockets) {
//            System.out.println(rocket);
//        }*/
    }
}