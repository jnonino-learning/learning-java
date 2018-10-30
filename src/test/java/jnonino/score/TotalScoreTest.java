package jnonino.score;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Julian on 28/1/2017.
 */
public class TotalScoreTest {

    @Test
    public void testTotalScore() {
        String[] blocks = {"5", "-2" , "4", "Z", "X", "9", "+", "+"};
        int expected = 27;
        int actual = TotalScore.totalScore(blocks, 8);
        Assert.assertEquals(expected, actual);
    }

}
