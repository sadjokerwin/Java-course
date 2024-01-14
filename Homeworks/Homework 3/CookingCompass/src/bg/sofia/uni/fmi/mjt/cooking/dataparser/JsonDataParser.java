package bg.sofia.uni.fmi.mjt.cooking.dataparser;

import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDataParser {
    private final String response;

    private final Gson gson;

    private final JsonObject jsonObject;

    public JsonDataParser(String response) {
        this.response = response;
        gson = new GsonBuilder().setLenient().create();
        jsonObject = gson.fromJson(response, JsonObject.class);
    }

    public List<Recipe> createRecipes() {
        JsonArray hits = jsonObject.getAsJsonArray("hits");

        List<Recipe> result = new ArrayList<>();

        if (hits.isEmpty()) {
            return result;
        }

        for (int i = 0; i < hits.size(); i++) {
            JsonObject hitObject = hits.get(i).getAsJsonObject();
            JsonObject recipeObject = hitObject.getAsJsonObject("recipe");

            Recipe recipe = gson.fromJson(recipeObject.toString(), Recipe.class);

            result.add(recipe);
        }
/*
            for (int i = 0; i < hitsArray.size(); i++) {
//                JsonObject hitObject = hitsArray.get(i).getAsJsonObject();
                JsonObject hitObject = hitsArray.get(i).getAsJsonObject();
                JsonObject recipeObject = hitObject.getAsJsonObject("recipe");
                System.out.println(recipeObject.get("label"));
                System.out.println(recipeObject.get("dietLabels"));
                System.out.println(recipeObject.get("healthLabels"));
                System.out.println(recipeObject.get("totalWeight"));
                System.out.println(recipeObject.get("cuisineType"));
                System.out.println(recipeObject.get("mealType"));
                System.out.println(recipeObject.get("dishType"));
                System.out.println(recipeObject.get("ingredientLines"));

                System.out.println('\n');
            }*/

        return result;
    }

}
