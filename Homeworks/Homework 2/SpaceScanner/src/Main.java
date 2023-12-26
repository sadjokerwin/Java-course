import bg.sofia.uni.fmi.mjt.space.mission.Detail;
import bg.sofia.uni.fmi.mjt.space.mission.Mission;
import bg.sofia.uni.fmi.mjt.space.mission.MonthConverter;
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

        String data1 = "10,Northrop,\"LP-0B, Wallops Flight Facility, Virginia, USA\",\"Wed Jul 15, 2020\",Minotaur IV | NROL-129,StatusActive,\"46.0 \",Success";
        String data2 = "11,ExPace,\"Site 95, Jiuquan Satellite Launch Center, China\",\"Fri Jul 10, 2020\",\"Kuaizhou 11 | Jilin-1 02E, CentiSpace-1 S2\",StatusActive,\"28.3 \",Failure";
        String pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        String[] tokens1 = data2.split(pattern);
//        System.out.println(tokens1[8]);

//        System.out.println(tokens1.length);
//        String[] tokens2 = data2.split(",");
//        System.out.println(tokens2[8]);
//        System.out.println(tokens2.length);
        for (var iter : tokens1) {
            System.out.println(iter);
        }
        System.out.println( Detail.of(tokens1[4]));

        //test mission date parser
//        "Fri Aug 07, 2020"
//        String dateAndMonth = "\"Fri Aug 07";
//        String year = " 2020\"";
//        System.out.println(Mission.formatDate(tokens[5], tokens[6]));

//        String[] dateAndMonthTokens = dateAndMonth.split(" ");
//        MonthConverter m1 = new MonthConverter();
//        String month = m1.convert(dateAndMonthTokens[1]);
////        String month = "08";
//
//        String day = dateAndMonthTokens[2];
//        //month string to int needs to be done
//        String yearNice = year.substring(1, 5);
////        String yearNice = "2020";

//        System.out.println(LocalDate.parse(yearNice + "-" + month + "-" + day));





    }
}