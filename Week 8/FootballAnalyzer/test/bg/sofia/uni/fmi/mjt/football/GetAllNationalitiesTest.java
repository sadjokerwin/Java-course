package bg.sofia.uni.fmi.mjt.football;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public Set<String> getAllNationalities() {
//        return players.stream()
//        .map(Player::nationality)
//        .collect(Collectors.toSet());
//        }
@ExtendWith(MockitoExtension.class)
public class CurrencyExchangeTest {
    public class GetAllNationalitiesTest {
        @Mock
        private FootballAnalyzer footballAnalyzer;

        @Test
        void testGetAllNationalities() throws FileNotFoundException {
            when(footballAnalyzer.getAllNationalities().size).



        }
    }
}