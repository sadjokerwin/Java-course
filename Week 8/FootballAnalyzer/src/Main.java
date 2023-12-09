import bg.sofia.uni.fmi.mjt.football.FootballPlayerAnalyzer;
import bg.sofia.uni.fmi.mjt.football.Player;
import bg.sofia.uni.fmi.mjt.football.Position;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Player> players;
//        System.out.println(System.getProperty("user.dir"));
        Reader dataInput = new FileReader("./FootballAnalyzer/src/fifa_players_clean.csv");
        FootballPlayerAnalyzer analyzer = new FootballPlayerAnalyzer(dataInput);
//        analyzer.getPlayersByFullNameKeyword("essi");

        System.out.println(analyzer.getTopProspectPlayerForPositionInBudget(Position.RW, 10000000));
//        return players.stream()
//                .filter(playerLambda ->
//                Math.abs(playerLambda.overallRating() - player.overallRating()) <= MAX_DIFFERENCE
//                || playerLambda.preferredFoot().equals(player.preferredFoot())
//                || playerLambda.positions().stream()
//                .anyMatch(position -> player.positions().contains(position))).collect(Collectors.toSet());
    }
}
