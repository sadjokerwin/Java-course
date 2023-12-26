package bg.sofia.uni.fmi.mjt.space.mission;

import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;

import javax.swing.text.html.HTMLDocument;
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
    private final static String pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";


    public static LocalDate formatDate(String date) {
//        Fri Aug 07, 2020
        String[] dateTokens = date.split(",");
        String[] dateAndMonthTokens = dateTokens[0].split(" ");
        String month = monthConverter.convert(dateAndMonthTokens[1]);

        String day = dateAndMonthTokens[2];
        dateTokens[1] = dateTokens[1].substring(1, 5);
        return LocalDate.parse(dateTokens[1] + "-" + month + "-" + day);
    }

    public static Optional<Double> formatCost(String cost) {
        if (cost.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(Double.valueOf(cost.substring(1, cost.length() - 1).trim().replace(",", "")));
        }
    }

    public static String getCountry(String location) {
        String[] tokens = location.split(",");
        return tokens[tokens.length-1].trim();
    }
    //
    public static Mission of(String data) {
        final String[] tokens = data.split(pattern);

        return new Mission(tokens[ID], tokens[COMPANY],
            tokens[LOCATION_SITE].substring(1, tokens[LOCATION_SITE].length() - 1),
            formatDate(tokens[DATE]), Detail.of(tokens[ROCKET_NAME_PAYLOAD]),
            RocketStatus.fromString(tokens[ROCKET_STATUS]),
            formatCost(tokens[MISSION_COST]),
            MissionStatus.fromString(tokens[MISSION_STATUS]));
    }
}
