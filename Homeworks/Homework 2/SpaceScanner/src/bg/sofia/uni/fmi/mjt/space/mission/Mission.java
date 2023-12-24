package bg.sofia.uni.fmi.mjt.space.mission;

import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;

import java.time.LocalDate;
import java.util.Optional;

public record Mission(String id, String company, String location, LocalDate date, Detail detail,
                      RocketStatus rocketStatus, Optional<Double> cost, MissionStatus missionStatus) {

    private final static int ID = 0;
    private final static int COMPANY = 1;
    private final static int LOCATION_SITE = 2;
    private final static int LOCATION_NAME = 3;
    private final static int LOCATION_COUNTRY = 4;
    private final static int DATE_NOYEAR = 5;
    private final static int DATE_YEAR = 6;
    private final static int ROCKET_NAME = 7;
    private final static int PAYLOAD_FIRST = 8;
    private final static int PAYLOAD_SECOND = 9;
    private final static int ROCKET_STATUS = 9;
    private final static int MISSION_COST = 10;
    private final static int MISSION_STATUS = 11;
    private final static int INDEX_IF_2_PAYLOADS = 1;


    public static LocalDate formatDate(String dateAndMonth, String year) {
//        Fri Aug 07, 2020
        String[] dateAndMonthTokens = dateAndMonth.split(" ");
        String month = dateAndMonthTokens[1];
        String day = dateAndMonthTokens[2].substring(0, dateAndMonthTokens[2].length() - 1);
        return LocalDate.parse(year + "-" + month + "-" + day);
    }
//
//    public static Mission of(String data) {
//
//    }
}
