package example.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class GameIoTest {
  private GameIo gameIo;
  private Io mockIo;

  @Before
  public void setUp() {
    String guess1  = "azza";
    String guess2  = "abcd";
    String guess3  = "aaag";
    String guess4  = "abcd";
    String guess5  = "abcd";
    String guess6  = "abcd";
    String guess7  = "abcd";
    String guess8  = "abcd";
    String guess9  = "abcd";
    String guess10 = "abcd";
    String guess11 = "abcd";
    String guess12 = "aaaa";
    String[] guesses = new String[] { guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12 };


    String playAgain1  = "yes";
    String playAgain2  = "no";
    String playAgain3  = ".";
    String playAgain4  = "AAA";
    String playAgain5  = "rrr";
    String playAgain6  = "N";
    String[] playAgainResponses = new String[] { playAgain1, playAgain2, playAgain3, playAgain4, playAgain5, playAgain6 };

    mockIo = new MockIo(guesses, playAgainResponses);
    gameIo = new GameIo(mockIo);
  }

  @Test
  public void testWelcomeMessageDisplay() {
    gameIo.displayWelcomeMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "\nWelcome to Mastermind!  Get ready to play!");
  }

  @Test
  public void testGuessInput() {
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(0), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
  }

  @Test
  public void test2GuessInputs() {
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(0), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertArrayEquals(gameIo.guess(12, new String[]{ "a", "b", "c", "d", "e", "f" }, 4), new String[]{ "a", "b", "c", "d" } );
    assertEquals(((MockIo)mockIo).messages.get(3), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
    assertEquals(((MockIo)mockIo).messages.get(4), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(5), "You have 12 guesses remaining.\nPlease enter your guess from the following options:\n[a, b, c, d, e, f] (Example: rgyb)\n");
  }

  @Test
  public void testInvalidInputMessageDisplay() {
    gameIo.displayInvalidInputMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "Your input was invalid.  Please try again.");
  }

  @Test
  public void testWinMessageDisplay() {
    gameIo.displayWinMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "Woohoo!  You win!");
  }

  @Test
  public void testLoseMessageDisplay() {
    gameIo.displayLoseMessage();
    assertEquals(((MockIo)mockIo).messages.get(0), "You lose.  Better luck next time.");
  }

  @Test
  public void testPlayAgainInput() {
    assertEquals(gameIo.playAgain(), "n");
    assertEquals(((MockIo)mockIo).messages.get(0), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(1), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(2), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(3), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(4), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(5), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(6), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(7), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(8), "Would you like to play again? (y/n)\n");
    assertEquals(((MockIo)mockIo).messages.get(9), "Your input was invalid.  Please try again.");
    assertEquals(((MockIo)mockIo).messages.get(10), "Would you like to play again? (y/n)\n");
  }

  @Test
  public void testGameboardDisplay() {
    String[][] move  = new String[][] { {"p", "p", "p", "p"}, {" ", " ", " ", " "} };
    String[][] move2 = new String[][] { {"r", "r", "r", "r"}, {"b", "b", "b", "b"} };

    ArrayList<String[][]> moveHistory = new ArrayList<String[][]>();
    moveHistory.add(move);
    moveHistory.add(move2);

    gameIo.displayGameboard(moveHistory);
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|             o888o o888o o888o o888o o888o o888o  oY8bod8o             |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|                TURN               |             FEEDBACK              |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|      p      p      p      p       |                                   |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString("|      r      r      r      r       |      b      b      b      b       |\n"));
    assertThat(((MockIo) mockIo).messages.get(0), containsString(" ----------------------------------------------------------------------- \n"));
  }

}
