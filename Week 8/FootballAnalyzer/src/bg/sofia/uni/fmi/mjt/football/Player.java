package bg.sofia.uni.fmi.mjt.football;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record Player(String name, String fullName, LocalDate birthDate, int age, double heightCm,
                     double weightKg, List<Position> positions, String nationality, int overallRating,
                     int potential, long valueEuro, long wageEuro, Foot preferredFoot) {
    private static final String PLAYER_STAT_DELIMETER = ";";
    private static final int PLAYER_STAT_NAME = 0;
    private static final int PLAYER_STAT_FULLNAME = 1;
    private static final int PLAYER_STAT_BIRTHDATE = 2;
    private static final int PLAYER_STAT_AGE = 3;
    private static final int PLAYER_STAT_HEIGHT = 4;
    private static final int PLAYER_STAT_WEIGHT = 5;
    private static final int PLAYER_STAT_POSITIONS = 6;
    private static final int PLAYER_STAT_NATIONALITY = 7;
    private static final int PLAYER_STAT_OVERALLRATING = 8;
    private static final int PLAYER_STAT_POTENTIAL = 9;
    private static final int PLAYER_STAT_VALUE = 10;
    private static final int PLAYER_STAT_WAGE = 11;
    private static final int PLAYER_STAT_FOOT = 12;

    private static LocalDate formatDate(String unformatted) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(unformatted, format);
    }

    public static Foot toEnum(String foot) {
        return foot.equals("left") ? Foot.LEFT : Foot.RIGHT;
    }

    public static Player of(String data) {
        final String[] tokens = data.split(PLAYER_STAT_DELIMETER);

        return new Player(tokens[PLAYER_STAT_NAME], tokens[PLAYER_STAT_FULLNAME],
                formatDate(tokens[PLAYER_STAT_BIRTHDATE]), Integer.parseInt(tokens[PLAYER_STAT_AGE]),
                Double.parseDouble(tokens[PLAYER_STAT_HEIGHT]), Double.parseDouble(tokens[PLAYER_STAT_WEIGHT]),
                Position.of(tokens[PLAYER_STAT_POSITIONS]), tokens[PLAYER_STAT_NATIONALITY],
                Integer.parseInt(tokens[PLAYER_STAT_OVERALLRATING]), Integer.parseInt(tokens[PLAYER_STAT_POTENTIAL]),
                Long.parseLong(tokens[PLAYER_STAT_VALUE]), Long.parseLong(tokens[PLAYER_STAT_WAGE]),
                toEnum(tokens[PLAYER_STAT_FOOT]));
    }
}
