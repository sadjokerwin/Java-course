import bg.sofia.uni.fmi.mjt.football.Player;

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


        try (var reader = new BufferedReader(dataInput)) {
            players = reader.lines().skip(1).map(Player::of).toList();
        } catch (IOException e) {
            throw new UncheckedIOException("A problem occurred while reading from the file", e);

        }
        System.out.println(players.stream()
                .filter(player -> player.age()>28)
                .map(Player::name)
                .toList());
    }
}
