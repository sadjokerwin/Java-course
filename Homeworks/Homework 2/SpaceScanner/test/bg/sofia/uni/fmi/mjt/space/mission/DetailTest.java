package bg.sofia.uni.fmi.mjt.space.mission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DetailTest {

    @Test
    void testDetailRocketNameNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Detail(null, "test"));
    }

    @Test
    void testDetailPayloadNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Detail("test", null));
    }
}
