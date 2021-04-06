import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GameTest {

    static Stream<Arguments> stringProvider(){
        return Stream.of(
                //player 1 win case
                Arguments.of(new String[]{"rock", "scissors"}, new String[]{"Player 1 win!"}),
                Arguments.of(new String[]{"paper", "rock"}, new String[]{"Player 1 win!"}),
                Arguments.of(new String[]{"scissors", "paper"}, new String[]{"Player 1 win!"}),
                //player 2 win case
                Arguments.of(new String[]{"rock", "paper"}, new String[]{"Player 2 win!"}),
                Arguments.of(new String[]{"paper", "scissors"}, new String[]{"Player 2 win!"}),
                Arguments.of(new String[]{"scissors", "rock"}, new String[]{"Player 2 win!"}),
                //draw
                Arguments.of(new String[]{"rock", "rock"}, new String[]{"Draw!"}),
                Arguments.of(new String[]{"paper", "paper"}, new String[]{"Draw!"}),
                Arguments.of(new String[]{"scissors", "scissors"}, new String[]{"Draw!"})
        );
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    public void WinOrLoseTest(String [] play, String[] result) {
        Game game = new Game();
        assertEquals(game.WinOrLose(play), result[0]);
    }

    @Test
    public void whenExceptionThrown_valid_case(){
        assertDoesNotThrow(()->{
            Game game = new Game();
            game.validation("rock");
            game.validation("paper");
            game.validation("scissors");
        });
    }
    
    @Test
    public void whenExceptionThrown_invalid_case() {
        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validation("peko");
        });
    }
}
