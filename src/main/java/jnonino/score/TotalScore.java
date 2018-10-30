package jnonino.score;

/**
 * Created by Julian on 28/1/2017.
 */
public class TotalScore {

    /**
     * The user plays this gaming throwing darts to a target, the target have integer values, and characters that act
     * as operators which are "X", "+", "Z".
     * - Int block: the integer indicated in the block is added to the total score.
     * - "X" block: the last score is doubled and added to the total score.
     * - "+" block: the last two scored are added and the result is added to the total score.
     * - "Z" block: the last score is removed from the total score.
     *
     * @param blocks A string array containing the score obtained by the user on each throw.
     * @param n The number of throws.
     * @return int Return an integer number obtained by the user.
     */
    public static int totalScore(String[] blocks, int n) {

        int nextToLast = 0;
        int lastScore = 0;
        int totalScore = 0;

        for (String block : blocks) {
            if (block != null && !block.equalsIgnoreCase("")) {
                if(block.matches("[-+]?\\d*\\.?\\d+")) {
                    nextToLast = lastScore;
                    lastScore = Integer.parseInt(block);
                    totalScore += lastScore;
                } else if (block.equalsIgnoreCase("X")) {
                    nextToLast = lastScore;
                    lastScore = lastScore * 2;
                    totalScore += lastScore;
                } else if (block.equalsIgnoreCase("+")) {
                    int tmp = nextToLast + lastScore;
                    nextToLast = lastScore;
                    lastScore = tmp;
                    totalScore += lastScore;
                } else if (block.equalsIgnoreCase("Z")) {
                    totalScore = totalScore - lastScore;
                    lastScore = nextToLast;
                }
            }
        }
        return totalScore;
    }

}
