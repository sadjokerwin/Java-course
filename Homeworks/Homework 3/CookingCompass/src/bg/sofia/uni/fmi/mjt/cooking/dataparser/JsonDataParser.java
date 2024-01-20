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
    private HttpResponse<String> responseFirstPage;
    private HttpResponse<String> responseSecondPage;
    private Gson gson;
    private JsonObject jsonObjectFirstPage;
    private JsonObject jsonObjectSecondPage;

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

    void setResponseFirstPage(HttpResponse<String> responseFirstPage) {
        this.responseFirstPage = responseFirstPage;
    }

    void setResponseSecondPage(HttpResponse<String> responseSecondPage) {
        this.responseSecondPage = responseSecondPage;
    }

    void setGson(Gson gson) {
        this.gson = gson;
    }

    void setJsonObjectFirstPage(JsonObject jsonObjectFirstPage) {
        this.jsonObjectFirstPage = jsonObjectFirstPage;

    }

    void setJsonObjectSecondPage(JsonObject jsonObjectSecondPage) {
        this.jsonObjectSecondPage = jsonObjectSecondPage;
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

        return result;
    }

    public HttpResponse<String> getResponseFirstPage() {
        return responseFirstPage;
    }

    public HttpResponse<String> getResponseSecondPage() {
        return responseSecondPage;
    }

    public JsonObject getJsonObjectFirstPage() {
        return jsonObjectFirstPage;
    }

    public JsonObject getJsonObjectSecondPage() {
        return jsonObjectSecondPage;
    }
}
