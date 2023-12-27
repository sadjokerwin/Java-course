package bg.sofia.uni.fmi.mjt.space.mission;

import bg.sofia.uni.fmi.mjt.space.rocket.RocketStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissionTest {

    @Test
    void testMissionIdNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission(null, "test", "test", null, null, null, null, null));
    }

    @Test
    void testMissionCompanyNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", null, "test", null, null, null, null, null));
    }

    @Test
    void testMissionLocationNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", "test", null, null, null, null, null, null));
    }

    @Test
    void testMissionDateNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", "test", "test", null, null, null, null, null));
    }

    @Test
    void testMissionDetailNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", "test", "test", LocalDate.of(2020, 1, 1), null, null, null, null));
    }

    @Test
    void testMissionRocketStatusNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", "test", "test", LocalDate.of(2020, 1, 1), new Detail("test", "test"), null, null,
                null));
    }

    @Test
    void testMissionMissionStatusNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Mission("test", "test", "test", LocalDate.of(2020, 1, 1), new Detail("test", "test"),
                RocketStatus.STATUS_ACTIVE, null, null));
    }

    @Test
    void testGetCountryLocationNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Mission.getCountry(null));
    }
}
