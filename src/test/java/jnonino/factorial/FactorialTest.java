package jnonino.factorial;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Julian on 28/1/2017.
 */
public class FactorialTest {

    @Test
    public void testFactorialZero() {
        int seedNumber = 0;
        int expected = 1;
        int actual = Factorial.calculateForInteger(seedNumber);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorialOne() {
        int seedNumber = 1;
        int expected = 1;
        int actual = Factorial.calculateForInteger(seedNumber);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorialThree() {
        int seedNumber = 3;
        int expected = 6;
        int actual = Factorial.calculateForInteger(seedNumber);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorialFive() {
        int seedNumber = 5;
        int expected = 120;
        int actual = Factorial.calculateForInteger(seedNumber);
        Assert.assertEquals(expected, actual);
    }

}
