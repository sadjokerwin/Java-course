package bg.sofia.uni.fmi.mjt.football;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record Player(String name, String fullName, LocalDate birthDate, int age, double heightCm,
                     double weightKg, List<Position> positions, String nationality, int overallRating,
                     int potential, long valueEuro, long wageEuro, Foot preferredFoot) {
    private static final String PLAYER_STAT_DELIMETER = ";";


    private static LocalDate formatDate(String unformatted) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(unformatted, format);
    }

    public static Foot toEnum(String foot) {
        return foot.equals("left") ? Foot.LEFT : Foot.RIGHT;
    }
    public static Player of(String data) {
        final String[] tokens = data.split(PLAYER_STAT_DELIMETER);

        return new Player(tokens[0], tokens[1], formatDate(tokens[2]), Integer.parseInt(tokens[3]),
                Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Position.of(tokens[6]),
                tokens[7], Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]),
                Long.parseLong(tokens[10]), Long.parseLong(tokens[11]), toEnum(tokens[12]));
    }
}
