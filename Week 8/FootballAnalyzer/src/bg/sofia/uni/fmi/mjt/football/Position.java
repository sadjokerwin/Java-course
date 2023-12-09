package bg.sofia.uni.fmi.mjt.football;

import java.util.ArrayList;
import java.util.List;

public enum Position {
    // Diagram: https://fifauteam.com/fifa-21-positions/

    ST, // Striker
    LM, // Left Midfielder
    CF, // Centre Forward
    GK, // Goalkeeper
    RW, // Right Winger
    CM, // Centre Midfielder
    LW, // Left Winger
    CDM, // Defensive Midfielder
    CAM, // Attacking midfielder
    RB, // Right back
    LB, // Left back
    LWB, // Left Wing-back
    RM, // Right Midfielder
    RWB, // Right Wing-back
    CB; // Centre Back

    private static final String PLAYER_STAT_DELIMETER = ",";

    public static List<Position> of(String data) {
        final String[] tokens = data.split(PLAYER_STAT_DELIMETER);
        List<Position> positions = new ArrayList<>();
        for (String token : tokens) {
            positions.add(Position.valueOf(token));
        }
        return positions;
    }
}
