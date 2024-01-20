package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JavaClientTest {
    JavaClient javaClient = new JavaClient();

    @Test
    void testInitUri() {
        String dietType = "vegetarian";
        String mealType = "breakfast";
        String tags = "salmon";

        URI uri = javaClient.initURI(dietType, mealType, tags);
        URI expected = URI.create(
            "https://api.edamam.com/api/recipes/v2?type=public&app_id=77f6f16b&app_key=935af6a49a4bb529045fc619845bb7b3&health=vegetarian&mealType=breakfast&tag=salmon");
        assertEquals(expected, uri);
    }

    @Test
    void testRunClass() throws IOException, InterruptedException {
        String dietType = "vegan fish-free fodmap-free immuno-supportive lupine-free low-sugar";
        String mealType = "breakfast brunch snack teatime";
        String tags = "salmon meat beef";

        HttpResponse<String> response = Mockito.mock(HttpResponse.class);
        JsonObject mockJsonObject = Mockito.mock(JsonObject.class);
        JsonElement mockJsonElement = Mockito.mock(JsonElement.class);

        when(mockJsonObject.get("count")).thenReturn(mockJsonElement);
        when(mockJsonElement.getAsInt()).thenReturn(0);

        HTTPConnection httpConnectionMock = Mockito.mock(HTTPConnection.class);

        Scanner mockScanner = Mockito.mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("vegan fish-free fodmap-free immuno-supportive lupine-free low-sugar",
            "breakfast brunch snack teatime", "salmon meat beef");

        javaClient.setScanner(mockScanner);
        Gson gson = new GsonBuilder().setLenient().create();
        when(gson.fromJson(response.body(), JsonObject.class)).thenReturn(mockJsonObject);

        assertEquals(0, javaClient.runClass().size());

    }
}
