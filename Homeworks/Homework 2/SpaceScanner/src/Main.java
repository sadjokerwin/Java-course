import bg.sofia.uni.fmi.mjt.space.mission.Detail;
import bg.sofia.uni.fmi.mjt.space.mission.Mission;
import bg.sofia.uni.fmi.mjt.space.mission.MissionStatus;
import bg.sofia.uni.fmi.mjt.space.mission.MonthConverter;
import bg.sofia.uni.fmi.mjt.space.rocket.Rocket;
import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        BufferedReader missionStatus = new BufferedReader(new FileReader("./data/all-missions-from-1957.csv"));

        Reader rocketStatus = new FileReader("./data/all-rockets-from-1957.csv");

//        missionStatus.lines().skip(1).map(Mission::of).toList();
        String data = "84,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Sun Nov 17, 2019\",\"Kuaizhou 1A | KL-Alpha A, KL-Alpha B\",StatusActive,,Success";

        String data1 = "10,Northrop,\"LP-0B, Wallops Flight Facility, Virginia, USA\",\"Wed Jul 15, 2020\",Minotaur IV | NROL-129,StatusActive,\"46.0 \",Success";
        String data2 = "11,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Fri Jul 10, 2020\",\"Kuaizhou 11 | Jilin-1 02E, CentiSpace-1 S2\",StatusActive,\"28.3 \",Failure";
        System.out.println(Mission.of(data));
//        String pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
//        String[] tokens = data1.split(pattern);

//        System.out.println(Double.valueOf("46.0 "));
    }
}