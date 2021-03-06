package example.mastermind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class FeedbackTest {
  private Feedback f;

  @Before
  public void setUp() {
    f = new Feedback();
  }

  @Test
  public void testAllPerfectMatches() {
    String[] result = f.get(new String[] {"c","c","c","c"}, new String[] {"c","c","c","c"});
    assertArrayEquals(new String[] {"b", "b", "b", "b"}, result);
  }

  @Test
  public void testThreePerfectMatches() {
    String[] result = f.get(new String[] {"c","c","c","d"}, new String[] {"c","c","c","c"});
    assertArrayEquals(new String[] {"b","b","b","x"}, result);
  }

  @Test
  public void testTwoPerfectMatches() {
    String[] result = f.get(new String[] {"c","c","d","d"}, new String[] {"c","c","c","c"});
    assertArrayEquals(new String[] {"b","b","x","x"}, result);
  }

  @Test
  public void testOnePerfectMatch() {
    String[] result = f.get(new String[] {"c","d","d","d"}, new String[] {"c","c","c","c"});
    assertArrayEquals(new String[] {"b","x","x","x"}, result);
  }

  @Test
  public void testAllNoMatches() {
    String[] result = f.get(new String[] {"d","d","d","d"}, new String[] {"c","c","c","c"});
    assertArrayEquals(new String[] {"x","x","x","x"}, result);
  }

  @Test
  public void test1NearMatchAnd3NoMatches() {
    String[] result = f.get(new String[] {"d","d","d","b"}, new String[] {"c","c","c","d"});
    assertArrayEquals(new String[] {"w","x","x","x"}, result);
  }

  @Test
  public void test2NearMatchAnd2NoMatches() {
    String[] result = f.get(new String[] {"d","d","d","b"}, new String[] {"b","c","c","d"});
    assertArrayEquals(new String[] {"w","w","x","x"}, result);
  }

  @Test
  public void test3NearMatchAnd1NoMatches() {
    String[] result = f.get(new String[] {"d","d","b","c"}, new String[] {"b","c","c","d"});
    assertArrayEquals(new String[] {"w","w","w","x"}, result);
  }

  @Test
  public void test4NearMatch() {
    String[] result = f.get(new String[] {"d","d","b","b"}, new String[] {"b","b","d","d"});
    assertArrayEquals(new String[] {"w","w","w","w"}, result);
  }

  @Test
  public void test1ExactMatch2NearMatchesAnd1NoMatch() {
    String[] result = f.get(new String[] {"b","r","y","g"}, new String[] {"y","r","b","p"});
    assertArrayEquals(new String[] {"b","w","w","x"}, result);
  }

  @Test
  public void test1ExactMatch1NearMatchAnd2NoMatch() {
    String[] result = f.get(new String[] {"l","r","y","g"}, new String[] {"y","r","b","p"});
    assertArrayEquals(new String[] {"b","w","x","x"}, result);
  }

  @Test
  public void test2ExactMatches1NearMatchAnd1NoMatch() {
    String[] result = f.get(new String[] {"y","r","p","g"}, new String[] {"y","r","b","p"});
    assertArrayEquals(new String[] {"b","b","w","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessButNotSecretCode() {
    String[] result = f.get(new String[] {"b","r","r","p"}, new String[] {"y","r","b","p"});
    assertArrayEquals(new String[] {"b","b","w","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessButNotSecretCode2() {
    String[] result = f.get(new String[] {"r","r","r","r"}, new String[] {"y","r","b","p"});
    assertArrayEquals(new String[] {"b","x","x","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode() {
    String[] result = f.get(new String[] {"y","g","g","r","r"}, new String[] {"y","r","r","p","b"});
    assertArrayEquals(new String[] {"b","w","w","x","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode2() {
    String[] result = f.get(new String[] {"y","g","g","r","r"}, new String[] {"g","r","r","g","g"});
    assertArrayEquals(new String[] {"w","w","w","w","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode3() {
    String[] result = f.get(new String[] {"b","o","o","g"}, new String[] {"b","g","o","p"});
    assertArrayEquals(new String[] {"b","b","w","x"}, result);
  }

  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode4() {
    String[] result = f.get(new String[] {"a","a","a","c"}, new String[] {"a","a","a","a"});
    assertArrayEquals(new String[] {"b","b","b","x"}, result);
  }


  @Test
  public void testDuplicateSymbolsinGuessAndNotSecretCode5() {
    String a = "aaaa";
    String[] b = new String[] {"a","a","a","a"};
    assert(Arrays.equals(a.split("(?!^)"), b));
  }

//  for (int i=0; i< expectedFeedbackValues.size(); i++) {
//    String[] actualFeedback = theGame.moveHistory.get(i)[1];
//    String expectedFeedback = expectedFeedbackValues.get(i);
//
//    if (expectedFeedback.split("(?!^)").equals(actualFeedback))
//      return true;
//  }
//
//  return false;

}
