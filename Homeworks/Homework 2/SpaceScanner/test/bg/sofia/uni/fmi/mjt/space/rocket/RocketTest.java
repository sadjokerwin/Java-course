package bg.sofia.uni.fmi.mjt.space.rocket;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RocketTest {
    @Test
    void testRocketIdNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Rocket(null, "test", Optional.empty(), Optional.empty()));
    }

    @Test
    void testRocketNameNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Rocket("test", null, Optional.empty(), Optional.empty()));
    }

    @Test
    void testFormatWiki() {
        assertEquals(Optional.empty(), Rocket.formatWiki(""));
    }

}
