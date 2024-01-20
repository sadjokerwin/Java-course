package bg.sofia.uni.fmi.mjt.cooking.dataparser;

import bg.sofia.uni.fmi.mjt.cooking.exception.NotSupportedDietTypeException;
import bg.sofia.uni.fmi.mjt.cooking.exception.NotSupportedMealTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandBuilderTest {

    CommandBuilder commandBuilder = new CommandBuilder();

    @Test
    void testConstructDietTypeEmpty() {
        assertEquals("", commandBuilder.constructDietType(""));
    }

    @Test
    void testConstructDietType() {
        assertEquals("&health=vegetarian&health=fish-free", commandBuilder.constructDietType("vegetarian fish-free"));
    }

    @Test
    void testConstructInvalidDietType() {
        assertThrows(NotSupportedDietTypeException.class, () -> commandBuilder.constructDietType("invalid"));
    }

    @Test
    void testConstructMealTypeEmpty() {
        assertEquals("", commandBuilder.constructMealType(""));
    }

    @Test
    void testConstructMealType() {
        assertEquals("&mealType=breakfast&mealType=snack", commandBuilder.constructMealType("breakfast snack"));
    }

    @Test
    void testConstructInvalidMealType() {
        assertThrows(NotSupportedMealTypeException.class, () -> commandBuilder.constructMealType("invalid"));
    }

    @Test
    void testConstructTagsEmpty() {
        assertEquals("", commandBuilder.constructTags(""));
    }

    @Test
    void testConstructTags() {
        assertEquals("&tag=salmon&tag=fish", commandBuilder.constructTags("salmon fish"));
    }

}
