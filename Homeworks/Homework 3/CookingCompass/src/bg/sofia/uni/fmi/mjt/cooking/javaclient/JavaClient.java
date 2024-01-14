package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import bg.sofia.uni.fmi.mjt.cooking.dataparser.JsonDataParser;
import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;

import java.util.List;

public class JavaClient extends Thread{
    List<Recipe> recipes;
    JsonDataParser dataParser;
    CommandBuilder commandBuilder;

    @Override
    public void run() {

    }

}
