package bg.sofia.uni.fmi.mjt.cooking.dataparser;

import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class JsonDataParserTest {
    //        //(GET https://api.edamam.com/api/recipes/v2?type=public&app_id=77
    //        f6f16b&app_key=935af6a49a4bb529045fc619845bb7b3&health=vegan&mealType=snack&tag=meat) 200
    HttpResponse<String> responseFirstPage = Mockito.mock(HttpResponse.class);
    HttpResponse<String> responseSecondPage = Mockito.mock(HttpResponse.class);
    Gson gson = Mockito.mock(Gson.class);
    JsonObject jsonObjectFirstPage = Mockito.mock(JsonObject.class);
    JsonObject jsonObjectSecondPage = Mockito.mock(JsonObject.class);
    JsonDataParser jsonDataParser = new JsonDataParser(
        responseFirstPage,
        responseSecondPage
    );

    @Test
    void testSetResponseFirstPage() {
        jsonDataParser.setResponseFirstPage(responseFirstPage);
        assertEquals(responseFirstPage, jsonDataParser.getResponseFirstPage());
    }

    @Test
    void getResponseFirstPage() {
        assertEquals(responseFirstPage, jsonDataParser.getResponseFirstPage());
    }

    @Test
    void testCreateRecipesEmpty() {

        jsonDataParser.setGson(gson);
        jsonDataParser.setJsonObjectFirstPage(jsonObjectFirstPage);
        jsonDataParser.setJsonObjectSecondPage(jsonObjectSecondPage);

        List<Recipe> result = new ArrayList<>();
        int page = 1;

        JsonArray hits = Mockito.mock(JsonArray.class);
        when(jsonObjectFirstPage.getAsJsonArray("hits")).thenReturn(hits);
        when(hits.isEmpty()).thenReturn(true);
        jsonDataParser.createRecipes(result, page);

    }

    @Test
    void testCreateRecipesSecondNull() {
        jsonDataParser.setResponseSecondPage(null);

        List<Recipe> result = new ArrayList<>();
        int page = 2;
        jsonDataParser.createRecipes(result, page);
    }

    @Test
    void testCreateRecipesSecondNotNull() {
        List<Recipe> result = new ArrayList<>();
        int page = 2;

        jsonDataParser.setGson(gson);
        jsonDataParser.setJsonObjectFirstPage(jsonObjectFirstPage);
        jsonDataParser.setJsonObjectSecondPage(jsonObjectSecondPage);

        JsonArray hitsPage = initHits();
        when(jsonObjectSecondPage.getAsJsonArray("hits")).thenReturn(hitsPage);

        jsonDataParser.createRecipes(result, page);
        assertEquals(1, result.size());
    }

    private JsonArray initHits() {
        Recipe recipe = new Recipe(
            "label",
            List.of("dietLabels"),
            List.of("healthLabels"),
            List.of("ingredientLines"),
            1.0,
            List.of("cuisineType"),
            List.of("mealType"),
            List.of("dishType")
        );
        JsonObject hitObject1 = new JsonObject();
        JsonObject recipeObject1 = new JsonObject();

        hitObject1.add("recipe", recipeObject1);
        recipeObject1.add("label", gson.toJsonTree("label"));
        recipeObject1.add("dietLabels", gson.toJsonTree(List.of("dietLabels")));
        recipeObject1.add("healthLabels", gson.toJsonTree(List.of("healthLabels")));
        recipeObject1.add("ingredientLines", gson.toJsonTree(List.of("ingredientLines")));
        recipeObject1.add("totalWeight", gson.toJsonTree(1.0));
        recipeObject1.add("cuisineType", gson.toJsonTree(List.of("cuisineType")));
        recipeObject1.add("mealType", gson.toJsonTree(List.of("mealType")));
        recipeObject1.add("dishType", gson.toJsonTree(List.of("dishType")));

        JsonArray hits = new JsonArray();
        hits.add(hitObject1);
        return hits;
    }

    @Test
    void testCreateRecipesMainFunc() {
        jsonDataParser.setGson(gson);
        jsonDataParser.setJsonObjectFirstPage(jsonObjectFirstPage);
        jsonDataParser.setJsonObjectSecondPage(jsonObjectSecondPage);

        JsonArray hitsPage1 = initHits();
        when(jsonObjectFirstPage.getAsJsonArray("hits")).thenReturn(hitsPage1);
        when(jsonObjectSecondPage.getAsJsonArray("hits")).thenReturn(new JsonArray());

        List<Recipe> recipes = jsonDataParser.createRecipes();
        assertEquals(1, recipes.size());
    }

    @Test
    void testGetResponseSecondPage() {
        assertEquals(responseSecondPage, jsonDataParser.getResponseSecondPage());
    }

    @Test
    void testGetJsonObjectFirstPage() {
        jsonDataParser.setJsonObjectFirstPage(null);
        assertNull(jsonDataParser.getJsonObjectFirstPage());
    }

    @Test
    void testGetJsonObjectSecondPage() {
        jsonDataParser.setJsonObjectSecondPage(null);
        assertNull(jsonDataParser.getJsonObjectSecondPage());
    }
}


