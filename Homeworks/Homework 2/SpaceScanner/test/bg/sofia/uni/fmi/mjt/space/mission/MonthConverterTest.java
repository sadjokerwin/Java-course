package bg.sofia.uni.fmi.mjt.space.mission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonthConverterTest {
    @Test
    void testConvertJan() {
        MonthConverter monthConverter = new MonthConverter();

        assert "01".equals(monthConverter.convert("Jan"));
    }

    @Test
    void testConvertNull() {
        MonthConverter monthConverter = new MonthConverter();

        assertThrows(IllegalArgumentException.class, () -> monthConverter.convert(null));
    }

    @Test
    void testConvertEmpty() {
        MonthConverter monthConverter = new MonthConverter();

        assertThrows(IllegalArgumentException.class, () -> monthConverter.convert(""));
    }

}
