package bg.sofia.uni.fmi.mjt.space.mission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissionStatusTest {
    @Test
    void testToString() {
        MissionStatus missionStatus = MissionStatus.FAILURE;
        assert missionStatus.toString().equals("Failure");
    }

    @Test
    void testFromString() {
        MissionStatus missionStatus = MissionStatus.fromString("Failure");
        assert missionStatus.toString().equals("Failure");
    }

    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> MissionStatus.fromString("Invalid"));
    }


}
