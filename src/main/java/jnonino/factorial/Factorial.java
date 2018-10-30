package jnonino.factorial;

/**
 * Created by Julian on 28/1/2017.
 */
public class Factorial {

    public static int calculateForInteger(int seedNumber) {
        int result = 0;
        if (seedNumber < 0) {
            result = 0;
        } else if (seedNumber < 2) {
            result = 1;
        } else {
            result = seedNumber * calculateForInteger(seedNumber - 1);
        }
        return result;
    }
}
