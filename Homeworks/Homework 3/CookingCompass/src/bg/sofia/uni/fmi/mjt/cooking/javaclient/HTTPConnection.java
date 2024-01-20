package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPConnection {
    private final HttpClient httpClient;

    HTTPConnection() throws IOException, InterruptedException {
        httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> getResponse(URI uri) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Accept", "application/json")
            .header("Accept-Language", "en")
            .build();

        try {
            // Send the request and retrieve the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
