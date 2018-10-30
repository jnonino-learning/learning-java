package jnonino.codefights.companybots.dropbox;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jnonino on 31/01/2017.
 */
public class ChallengesTest {

    @Test
    public void incorrectPasscodeAttemptsTestOne() {
        String passcode = "1111";
        String [] attempts = {"1111",
        "4444",
                        "9999",
                        "3333",
                        "8888",
                        "2222",
                        "7777",
                        "0000",
                        "6666",
                        "7285",
                        "5555",
                        "1111"};
        boolean expected = true;
        boolean actual = Challenges.incorrectPasscodeAttempts(passcode, attempts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void incorrectPasscodeAttemptsTestTwo() {
        String passcode = "1234";
        String[] attempts = {"9999",
                        "9999",
                        "9999",
                        "9999",
                        "9999",
                        "9999",
                        "9999",
                        "9999",
                        "9999",
                        "1234",
                        "9999",
                        "9999"};
        boolean expected = false;
        boolean actual = Challenges.incorrectPasscodeAttempts(passcode, attempts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void losslessDataCompressionTestOne() {
        String inputString = "abacabadabacaba";
        int width = 7;
        String expected = "ab(0,1)c(0,3)d(4,3)c(8,3)";
        String actual = Challenges.losslessDataCompression(inputString, width);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void losslessDataCompressionTestTwo() {
        String inputString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int width = 12;
        String expected = "a(0,1)(0,2)(0,4)(0,8)(4,12)";
        String actual = Challenges.losslessDataCompression(inputString, width);
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void displayDiffTestOne() {
//        String oldVersion = "same_prefix_1233_same_suffix";
//        String newVersion = "same_prefix23123_same_suffix";
//        String expected = "same_prefix(_1)23[12]3_same_suffix";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }

//    @Test
//    public void displayDiffTestTwo() {
//        String oldVersion = "a";
//        String newVersion = "b";
//        String expected = "(a)[b]";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }

//    @Test
//    public void displayDiffTestThree() {
//        String oldVersion = "a";
//        String newVersion = "a";
//        String expected = "a";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void displayDiffTestFour() {
//        String oldVersion = "ab";
//        String newVersion = "bb";
//        String expected = "(a)b[b]";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }

//    @Test
//    public void displayDiffTestFive() {
//        String oldVersion = "a2_3b42c_78d";
//        String newVersion = "a_34c27_8ed";
//        String expected = "a(2)_3(b)4(2)c(_)[2]7[_]8[e]d";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void displayDiffTestSix() {
//        String oldVersion = "same_prefix_12533_same_suffix";
//        String newVersion = "same_prefix23123_same_suffix";
//        String expected = "same_prefix(_1)2(5)3[12]3_same_suffix";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void displayDiffTestSeven() {
//        String oldVersion = "same_prefix_1233_same_suffix";
//        String newVersion = "same_prefix231233_same_suffix";
//        String expected = "same_prefix(_)[23]1233_same_suffix";
//        String actual = Challenges.displayDiff(oldVersion, newVersion);
//        Assert.assertEquals(expected,actual);
//    }

    @Test
    public void displayDiffTestEight() {
        String oldVersion = "ab";
        String newVersion = "bc";
        String expected = "(a)b[c]";
        String actual = Challenges.displayDiff(oldVersion, newVersion);
        Assert.assertEquals(expected,actual);
    }
}
