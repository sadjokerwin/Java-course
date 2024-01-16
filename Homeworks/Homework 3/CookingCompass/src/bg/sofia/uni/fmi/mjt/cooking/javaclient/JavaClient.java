package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import bg.sofia.uni.fmi.mjt.cooking.dataparser.CommandBuilder;
import bg.sofia.uni.fmi.mjt.cooking.dataparser.JsonDataParser;
import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class JavaClient {
    List<Recipe> recipes;
    private JsonDataParser dataParser;
    private final CommandBuilder commandBuilder = new CommandBuilder();
    private HTTPConnection connection;
    private static final String APP_ID = "77f6f16b";
    private static final String APP_KEY = "935af6a49a4bb529045fc619845bb7b3";

    private URI initURI() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the diet types you want to search for: ");
        String dietTypes = commandBuilder.constructDietType(s1.nextLine());

        System.out.println("Enter the meal types you want to search for: ");
        String mealTypes = commandBuilder.constructMealType(s1.nextLine());

        System.out.println("Enter the ingredients you want to search for: ");
        String ingredients = commandBuilder.constructTags(s1.nextLine());

        System.out.println(dietTypes);
        System.out.println(mealTypes);
        System.out.println(ingredients);


        // Build the URI with user input and API credentials
        URI uri =
            URI.create("https://api.edamam.com/api/recipes/v2?type=public&app_id=" + APP_ID + "&app_key=" + APP_KEY
                + dietTypes + mealTypes + ingredients);

        return uri;
    }

    private void initRecipes() throws IOException, InterruptedException {
        connection = new HTTPConnection();

        HttpResponse<String> response1 = connection.getResponse(initURI());

        Gson gson = new GsonBuilder().setLenient().create();

        int count = (gson.fromJson(response1.body(), JsonObject.class)).getAsJsonObject("count").getAsInt();

        if (count == 0) {
            System.out.println("No recipes found!");
            return;
        } else if (count >= 40) {
            String response2String =
                (gson.fromJson(response1.body(), JsonObject.class)).getAsJsonObject("_links").getAsJsonObject("next")
                    .get("href").toString();

            URI uri = URI.create(response2String.substring(1, response2String.length() - 1));
            HttpResponse<String> response2 = connection.getResponse(uri);
            dataParser = new JsonDataParser(response1, response2);
        } else {
            dataParser = new JsonDataParser(response1, null);
        }


        recipes = dataParser.createRecipes();
    }

    private List<Recipe> getRecipes() {
        return recipes;
    }

    public void runClass() throws IOException, InterruptedException {
        initRecipes();

        List<Recipe> recipeList = getRecipes();
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
        }
    }
}
