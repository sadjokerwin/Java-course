package bg.sofia.uni.fmi.mjt.space.mission;

import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;

import java.time.LocalDate;
import java.util.Optional;

public record Mission(String id, String company, String location, LocalDate date, Detail detail,
                      RocketStatus rocketStatus, Optional<Double> cost, MissionStatus missionStatus) {

    private final static int ID = 0;
    private final static int COMPANY = 1;
    private final static int LOCATION_SITE = 2;
    private final static int DATE = 3;
    private final static int ROCKET_NAME_PAYLOAD = 4;
    private final static int ROCKET_STATUS = 5;
    private final static int MISSION_COST = 6;
    private final static int MISSION_STATUS = 7;
    private final static MonthConverter monthConverter = new MonthConverter();


    public static LocalDate formatDate(String date) {
//        Fri Aug 07, 2020
        String[] dateTokens = date.split(",");
        String[] dateAndMonthTokens = dateTokens[0].split(" ");
        String month = monthConverter.convert(dateAndMonthTokens[1]);

        String day = dateAndMonthTokens[2];
        dateTokens[1] = dateTokens[1].substring(1, 5);
        return LocalDate.parse(dateTokens[1] + "-" + month + "-" + day);
    }

//
    public static Mission of(String data) {
        //10,Northrop,"LP-0B, Wallops Flight Facility, Virginia, USA","Wed Jul 15, 2020",Minotaur IV | NROL-129,StatusActive,"46.0 ",Success
        //11,ExPace,"Site 95, Jiuquan Satellite Launch Center, China","Fri Jul 10, 2020","Kuaizhou 11 | Jilin-1 02E, CentiSpace-1 S2",StatusActive,"28.3 ",Failure
        final String[] tokens = data.split(",");
//        String id = tokens[ID];
//        return new Mission(tokens[ID], tokens[COMPANY],
//            tokens[LOCATION_SITE].substring(1) + ", "
//                + tokens[LOCATION_NAME] + ", "
//                + tokens[LOCATION_COUNTRY].substring(0, tokens[LOCATION_COUNTRY].length() - 1),
//            formatDate(tokens[DATE_NOYEAR], tokens[DATE_YEAR]),
//            new Detail(tokens[ROCKET_NAME], tokens[PAYLOAD_FIRST], tokens[PAYLOAD_SECOND]),
//        return new Player(tokens[PLAYER_STAT_NAME], tokens[PLAYER_STAT_FULLNAME],
//            formatDate(tokens[PLAYER_STAT_BIRTHDATE]), Integer.parseInt(tokens[PLAYER_STAT_AGE]),
//            Double.parseDouble(tokens[PLAYER_STAT_HEIGHT]), Double.parseDouble(tokens[PLAYER_STAT_WEIGHT]),
//            Position.of(tokens[PLAYER_STAT_POSITIONS]), tokens[PLAYER_STAT_NATIONALITY],
//            Integer.parseInt(tokens[PLAYER_STAT_OVERALLRATING]), Integer.parseInt(tokens[PLAYER_STAT_POTENTIAL]),
//            Long.parseLong(tokens[PLAYER_STAT_VALUE]), Long.parseLong(tokens[PLAYER_STAT_WAGE]),
//            toEnum(tokens[PLAYER_STAT_FOOT]));
            return null;
    }
}
