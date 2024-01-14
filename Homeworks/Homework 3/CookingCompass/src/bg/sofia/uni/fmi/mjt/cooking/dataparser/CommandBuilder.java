package bg.sofia.uni.fmi.mjt.cooking.dataparser;

import bg.sofia.uni.fmi.mjt.cooking.exception.NotSupportedDietTypeException;

import java.util.HashSet;
import java.util.Set;

public class CommandBuilder {
    private static Set validDietTypes = new HashSet<>() {
        {
            add("alcohol-cocktail");
            add("alcohol-free");
            add("celery-free");
            add("crustacean-free");
            add("dairy-free");
            add("egg-free");
            add("fish-free");
            add("fodmap-free");
            add("gluten-free");
            add("immuno-supportive");
            add("keto-friendly");
            add("kidney-friendly");
            add("kosher");
            add("low-sugar");
            add("low-potassium");
            add("lupine-free");
            add("Mediterranean");
            add("mollusk-free");
            add("mustard-free");
            add("no-oil-added");
            add("paleo");
            add("peanut-free");
            add("pescatarian");
            add("pork-free");
            add("red-meat-free");
            add("sesame-free");
            add("shellfish-free");
            add("soy-free");
            add("sugar-conscious");
            add("sulfate-free");
            add("tree-nut-free");
            add("vegan");
            add("vegetarian");
            add("wheat-free");
        }
    };
    private static Set validMealTypes = new HashSet<>() {
        {
            add("breakfast");
            add("brunch");
            add("lunch/dinner");
            add("snack");
            add("teatime");
        }
    };

    public String constructDietType(String scannerDietTypesLine) {
        String[] dietTokens = scannerDietTypesLine.split(" ");

        StringBuilder dietTypesResult = new StringBuilder();

        for (String iter : dietTokens) {
            if (validDietTypes.contains(iter)) {
                dietTypesResult.append("&health=");
                dietTypesResult.append(iter);
            } else {
                throw new NotSupportedDietTypeException(iter + "isn't a supported diet type");
            }
        }

        return dietTypesResult.toString();
    }

    public String constructMealType(String scannerMealTypesLine) {
        String[] mealTokens = scannerMealTypesLine.split(" ");

        StringBuilder mealTypesResult = new StringBuilder();

        for (String iter : mealTokens) {
            if (validMealTypes.contains(iter)) {
                mealTypesResult.append("&mealType=");
                mealTypesResult.append(iter);
            } else {
                throw new NotSupportedDietTypeException(iter + "isn't a supported meal type");
            }
        }

        return mealTypesResult.toString();
    }

    public String constructTags(String scannerTagsLine) {
        String[] tagTokens = scannerTagsLine.split(" ");

        StringBuilder tagResult = new StringBuilder();
        for (String iter : tagTokens) {
            tagResult.append("&tag=");
            tagResult.append(iter);
        }

        return tagResult.toString();
    }


    public void func1() {
        System.out.println();
    }
}

