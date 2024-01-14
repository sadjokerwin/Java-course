package bg.sofia.uni.fmi.mjt.cooking.javaclient;

import bg.sofia.uni.fmi.mjt.cooking.dataparser.CommandBuilder;
import bg.sofia.uni.fmi.mjt.cooking.dataparser.JsonDataParser;
import bg.sofia.uni.fmi.mjt.cooking.recipe.Recipe;

import java.util.List;

public class JavaClient extends Thread{
    List<Recipe> recipes;
    private final JsonDataParser dataParser = new JsonDataParser("ads");
    private final CommandBuilder commandBuilder = new CommandBuilder();

    @Override
    public void run() {

    }

}
