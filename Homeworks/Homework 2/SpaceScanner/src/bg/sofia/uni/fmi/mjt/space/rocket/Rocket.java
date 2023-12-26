package bg.sofia.uni.fmi.mjt.space.rocket;

import java.util.Optional;

public record Rocket(String id, String name, Optional<String> wiki, Optional<Double> height) {
    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int WIKI = 2;
    private static final int HEIGHT = 3;
//    Double.valueOf(tokens[3].substring(0, tokens[3].length() - 2).trim())

    public Rocket {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id is null or empty");
        } else if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
    }

    public static Optional<String> formatWiki(String wiki) {
        if (wiki.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(wiki);
        }
    }

    public static Optional<Double> formatHeight(String height) {
        if (height.isEmpty() || height.equals("\n")) {
            return Optional.empty();
        } else {
            return Optional.of(Double.valueOf(height.substring(0, height.length() - 2).trim()));
        }
    }

    public static Rocket of(String data) {
        final String[] tokens = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        return new Rocket(tokens[ID], tokens[NAME], formatWiki(tokens[WIKI]), formatHeight(tokens[HEIGHT]));
    }
}
