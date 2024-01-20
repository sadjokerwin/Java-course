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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaClient {
    List<Recipe> recipes;
    private Scanner scanner = new Scanner(System.in);
    private JsonDataParser dataParser;
    private final CommandBuilder commandBuilder = new CommandBuilder();
    private HTTPConnection connection;
    private static final String APP_ID = "77f6f16b";
    private static final String APP_KEY = "935af6a49a4bb529045fc619845bb7b3";
    private static final int MAX_RECIPES_PER_PAGE = 20;

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    URI initURI(String dietTypes, String mealTypes, String tags) {
        String dietTypesCommand = commandBuilder.constructDietType(dietTypes);
        String mealTypesCommand = commandBuilder.constructMealType(mealTypes);
        String tagsCommand = commandBuilder.constructTags(tags);

        URI uri =
            URI.create("https://api.edamam.com/api/recipes/v2?type=public&app_id=" + APP_ID + "&app_key=" + APP_KEY
                + dietTypesCommand + mealTypesCommand + tagsCommand);

        return uri;
    }

    private URI getUserInputURI() {
        System.out.println("Enter the diet types you want to search for: ");
        String dietTypes = scanner.nextLine();

        System.out.println("Enter the meal types you want to search for: ");
        String mealTypes = scanner.nextLine();

        System.out.println("Enter the ingredients you want to search for: ");
        String ingredients = scanner.nextLine();

        return initURI(dietTypes, mealTypes, ingredients);
    }

    private void initRecipes() throws IOException, InterruptedException {
        connection = new HTTPConnection();

        HttpResponse<String> response1 = connection.getResponse(getUserInputURI());

        Gson gson = new GsonBuilder().setLenient().create();

        int count = gson.fromJson(response1.body(), JsonObject.class).get("count").getAsInt();

        if (count == 0) {
            System.out.println("No recipes found!");
            recipes = new ArrayList<>();
            return;
        } else if (count > MAX_RECIPES_PER_PAGE) {
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

    public List<Recipe> runClass() throws IOException, InterruptedException {
        initRecipes();

        List<Recipe> recipeList = getRecipes();
        if (recipeList == null) {
            System.out.println("No recipes found!");
            return recipeList;
        }
        return recipeList;
    }
}
