package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTTPConnectionTest {
    @Test
     void testGetResponse() throws IOException, InterruptedException {
        HTTPConnection httpConnection = new HTTPConnection();
        URI uri = URI.create(
            "https://api.edamam.com/api/recipes/v2?type=public&app_id=77f6f16b&app_key=935af6a49a4bb529045fc619845bb" +
                "7b3&health=vegan&health=gluten-free&health=immuno-supportive&mealType=brunch&mealType=teatime&tag=m" +
                "eat&tag=beef");

          HttpResponse<String> response = httpConnection.getResponse(uri);
          assertEquals(200, response.statusCode());
    }
}
