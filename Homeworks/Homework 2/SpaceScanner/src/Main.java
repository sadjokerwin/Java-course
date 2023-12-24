import bg.sofia.uni.fmi.mjt.space.mission.Mission;
import bg.sofia.uni.fmi.mjt.space.rocket.Rocket;

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
        String[] tokens = data.split(",");
//        for (var iter : tokens) {
//            System.out.println(iter);
//        }

        //test mission date parser
//        "Fri Aug 07, 2020"
        String dateAndMonth = "\"Fri Aug 07";
        String year = " 2020\"";
//        System.out.println(Mission.formatDate(tokens[5], tokens[6]));

        String[] dateAndMonthTokens = dateAndMonth.split(" ");
//        String month = dateAndMonthTokens[1];
        String month = "08";

        String day = dateAndMonthTokens[2];
        //month string to int needs to be done
        String yearNice = year.substring(1, 5);
//        String yearNice = "2020";

        System.out.println(LocalDate.parse(yearNice + "-" + month + "-" + day));





    }
}