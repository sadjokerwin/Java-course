package bg.sofia.uni.fmi.mjt.cooking.dataparser;

import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JsonDataParser {
    private final HttpResponse<String> responseFirstPage;
    private final HttpResponse<String> responseSecondPage;
    private final Gson gson;
    private final JsonObject jsonObjectFirstPage;
    private final JsonObject jsonObjectSecondPage;


    public JsonDataParser(HttpResponse<String> responseFirstPage, HttpResponse<String> responseSecondPage) {
        this.responseFirstPage = responseFirstPage;
        this.responseSecondPage = responseSecondPage;
        gson = new GsonBuilder().setLenient().create();

        jsonObjectFirstPage = gson.fromJson(responseFirstPage.body(), JsonObject.class);

        if (responseSecondPage == null) {
            jsonObjectSecondPage = null;
            return;
        }
        jsonObjectSecondPage = gson.fromJson(responseSecondPage.body(), JsonObject.class);
    }

    public void createRecipes(List<Recipe> result, int page) {
        JsonObject object;

        if (page == 1) {
            object = jsonObjectFirstPage;
        } else if (responseSecondPage == null) {
            return;
        } else {
            object = jsonObjectSecondPage;
        }

        JsonArray hits = object.getAsJsonArray("hits");

        if (hits.isEmpty()) {
            return;
        }

        for (
            int i = 0; i < hits.size(); i++) {
            JsonObject hitObject = hits.get(i).getAsJsonObject();
            JsonObject recipeObject = hitObject.getAsJsonObject("recipe");
            Recipe recipe = gson.fromJson(recipeObject.toString(), Recipe.class);
            result.add(recipe);
        }
    }

    public List<Recipe> createRecipes() {
        List<Recipe> result = new ArrayList<>();

        createRecipes(result, 1);
        createRecipes(result, 2);
/*
        JsonArray hits = jsonObjectFirstPage.getAsJsonArray("hits");

        System.out.println(hits.size());


        if (hits.isEmpty()) {
            return result;
        }

        for (int i = 0; i < hits.size(); i++) {
            JsonObject hitObject = hits.get(i).getAsJsonObject();
            JsonObject recipeObject = hitObject.getAsJsonObject("recipe");

            Recipe recipe = gson.fromJson(recipeObject.toString(), Recipe.class);

            result.add(recipe);
        }

        hits = jsonObjectSecondPage.getAsJsonArray("hits");

        System.out.println(hits.size());

        if (hits.isEmpty()) {
            return result;
        }

        for (int i = 0; i < hits.size(); i++) {
            JsonObject hitObject = hits.get(i).getAsJsonObject();
            JsonObject recipeObject = hitObject.getAsJsonObject("recipe");

            Recipe recipe = gson.fromJson(recipeObject.toString(), Recipe.class);

            result.add(recipe);
        }*/
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
