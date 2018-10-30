package jnonino.codefights.companybots.dropbox;

import java.util.*;

/**
 * Created by jnonino on 31/01/2017.
 */
public class Challenges {

    /**
     * One Very Important User (VIU) has a Very Confidential Document (VCD) stored on his Dropbox
     * account. He doesn't let anyone see the VCD, especially his roommates who often have access to
     * his devices. Opening the Dropbox mobile app on the VIU's tablet requires a four-digit
     * passcode. To ensure the confidentiality of the stored information, the device is locked out
     * of Dropbox after 10 consecutive failed passcode attempts. We need to implement a function
     * that given an array of attempts made throughout the day and the correct passcode checks to
     * see if the device should be locked, i.e. 10 or more consecutive failed passcode attempts were
     * made.
     * Example
     * For
     *      passcode = "1111" and
     *      attempts = ["1111", "4444",
     *                  "9999", "3333",
     *                  "8888", "2222",
     *                  "7777", "0000",
     *                  "6666", "7285",
     *                  "5555", "1111"]
     *      the output should be
     *          incorrectPasscodeAttempts(passcode, attempts) = true.
     *      The first attempt is correct, so the user must have successfully logged in. However,
     *      the next 10 consecutive attempts are incorrect, so the device should be locked. Thus,
     *      the output should be true.
     * For
     *      passcode = "1234" and
     *      attempts = ["9999", "9999",
     *                  "9999", "9999",
     *                  "9999", "9999",
     *                  "9999", "9999",
     *                  "9999", "1234",
     *                  "9999", "9999"]
     *      the output should be
     *          incorrectPasscodeAttempts(passcode, attempts) = false.
     *      There are only 9 consecutive incorrect attempts, so there's no need to lock the device.
     *
     * Input/Output
     *      [time limit] 3000ms (java)
     *      [input] string passcode
     *      String consisting of exactly 4 digits representing the correct passcode.
     *      [input] array.string attempts
     *      Array representing the passcode attempts in the order they were made. Each element of
     *      attempts is a string consisting of exactly 4 digits.
     * Constraints:
     *      0 ≤ attempts.length ≤ 20.
     * [output] boolean
     *      true if 10 or more consecutive failed passcode attempts were made, false otherwise.
     */
    public static boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
        boolean shouldLock = false;
        int attemptCount = 0;
        for (String attempt : attempts) {
            if (attempt.equalsIgnoreCase(passcode)) {
                attemptCount = 0;
            } else {
                attemptCount++;
                if (attemptCount == 10) {
                    shouldLock = true;
                    break;
                }
            }
        }
        return shouldLock;
    }

    /**
     * In its effort to push the limits of file compression, Dropbox recently developed a lossless
     * compression algorithm for H.264 and JPEG files. Since you are thinking about applying for a
     * job at Dropbox, you decided to experiment with simple lossless compression as part of your
     * interview prep.
     * One of the most widely known approaches in the field of compression algorithms is sliding
     * window compression. It works as follows:
     *  - Consider characters one by one. Let the current character index be i.
     *  - Take the last width characters before the current one (i.e. s[i - width, i - 1],
     *  where s[i, j] means the substring of s from index i to index j, both inclusive), and call it
     *  the window.
     *  - Find such startIndex and length that s[i, i + length - 1] = s[startIndex, startIndex + length - 1]
     *  and s[startIndex, startIndex + length - 1] is contained within the window. If there are
     *  several such pairs, choose the one with the largest length. If there still remains more than
     *  one option, choose the one with the smallest startIndex.
     *  If the search was successful, append "(startIndex,length)" to the result and move to the
     *  index i + length.
     *  Otherwise, append the current character to the result and move on to the next one.
     *  Given a string, apply sliding window compression to it.
     *  Example
     *      For inputString = "abacabadabacaba" and width = 7, the output should be
     *      losslessDataCompression(inputString, width) = "ab(0,1)c(0,3)d(4,3)c(8,3)".
     *      Step 1: i = 0, inputString[i] = 'a', window = "". 'a' is not contained within the window, so it is appended to the result.
     *      Step 2: i = 1, inputString[i] = 'b', window = "a". 'b' is not contained within the window, so it is appended to the result.
     *      Step 3: i = 2, inputString[i] = 'a', window = "ab". 'a' can be found in the window. 'a' in the window corresponds to the inputString[0], so (0,1) representing the substring "a" is appended to the result.
     *      Step 4: i = 3, inputString[i] = 'c', window = "aba". The same situation as in the first two steps.
     *      Step 5: i = 4, inputString[i] = 'a', window = "abac". Consider startIndex = 0, length = 3. inputString[startIndex, startIndex + length - 1] = "aba" and it is contained within the window, inputString[i, i + length - 1] = "aba". Therefore, "(0,3)" should be added to the result. i += length.
     *      Step 6: i = 7, inputString[i] = 'd', window = inputString[0, 6] = "abacaba". The same situation as in the first two steps.
     *      Step 7: i = 8, inputString[i] = 'a', window = inputString[1, 7] = "bacabad". Consider length = 3 again. inputString[i, i + b - 1] = "aba", window[3, 5] = "aba", and it corresponds to inputString[4, 6] since inputString[0, 2] is no longer within the window. So, "(4,3)" should be appended. i += length.
     *      Step 8: i = 11, inputString[i] = 'c', window = "abadaba". The same situation as at the first two steps.
     *      Step 9: i = 12, inputString[i] = 'a', window = "badabac". length = 3, inputString[i, i + length - 1] = "aba", window[3, 5] = "aba", and it corresponds to inputString[8, 10]. So, "(8,3)" should be appended. i += length.
     * For inputString = "abacabadabacaba" and width = 8, the output should be
     *      losslessDataCompression(inputString, width) = "ab(0,1)c(0,3)d(0,7)".
     * In both of the above examples the resulting "compressed" string becomes even longer than the
     * initial one. In fact, sliding window compression proves to be efficient for longer inputs. E.g.:
     * For inputString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa" and width = 12, the output should be
     *      losslessDataCompression(inputString, width) = "a(0,1)(0,2)(0,4)(0,8)(4,12)".
     * In the last example the resulting string is one character shorter than the input one. It is
     * the shortest possible example of the efficient work of sliding window compression. If the
     * input contained even more letters 'a', then the effect of this approach would be even more
     * considerable.
     * Input/Output
     *      [time limit] 3000ms (java)
     *      [input] string inputString: A non-empty string of lowercase letters.
     *          Constraints:
     *          1 ≤ inputString.length ≤ 40.
     *      [input] integer width: A positive integer.
     *          Constraints:
     *          1 ≤ width ≤ 108.
     *      [output] string
     *          Compressed inputString.
     */

    public static String losslessDataCompression(String inputString, int width) {
        StringBuilder result = new StringBuilder();

        for (int i = 0 ; i < inputString.length() ; i++) {

            String character = String.valueOf(inputString.charAt(i));

            int windowStart = (i - width > 0) ? (i - width) : 0;
            int windowEnd = (i - 1 >= 0) ? (i - 1) : -1;
            String window = inputString.substring(windowStart, windowEnd+1);

            if (!window.contains(character)) {
                result.append(character);
                continue;
            } else {
                int startIndex = 0;
                int length = 0;
                List<int[]> findings = new ArrayList<int[]>();

                for (startIndex = windowStart ; startIndex <= windowEnd+1 ; startIndex++) {
                    for (length = 0 ; length <= windowEnd+2 ; length++) {
                        try {
                            String compareOne = inputString.substring(i, i+length-1);
                            String compareTwo = inputString.substring(startIndex, startIndex+length-1);
                            boolean addResult = compareOne.equalsIgnoreCase(compareTwo) &&
                                                window.contains(compareTwo);
                            if (addResult) {
                                findings.add(new int[] {startIndex, length-1});
                            }
                        } catch (StringIndexOutOfBoundsException ignored) { }
                    }
                }

                findings.sort((op1, op2) -> {
                    Integer lengthOp1 = op1[1];
                    Integer lengthOp2 = op2[1];
                    int lengthComparision = lengthOp2.compareTo(lengthOp1);
                    if (lengthComparision != 0) {
                        return lengthComparision;
                    } else {
                        Integer startIndexOp1 = op1[0];
                        Integer startIndexOp2 = op2[0];
                        return startIndexOp1.compareTo(startIndexOp2);
                    }
                });
                int[] element = findings.get(0);
                result.append("(");
                result.append(element[0]);
                result.append(",");
                result.append(element[1]);
                result.append(")");
                if (element[1]>1) {
                    i += element[1]-1;
                }
            }
        }
        return result.toString();
    }

    String losslessDataCompressionBESTSOLUTION(String inputString, int width) {
        int n = inputString.length();
        StringBuilder b = new StringBuilder();
        char[] x = inputString.toCharArray();
        b.append(""+x[0]);
        for(int i = 1; i < n; i++) {
            String window = inputString.substring(Math.max(0,i-width), i);
            int bestLength = 0, bestIndex = 0;
            for(int startIndex = 0; startIndex < width; startIndex++) {
                int length = 0;
                int s1 = Math.max(0, i-width+startIndex), s2 = i;
                while (s1 < i && s2 < n && x[s1] == x[s2]) {
                    length++;
                    s1++;
                    s2++;
                }
                if (length > bestLength) {
                    bestLength = length;
                    bestIndex = Math.max(0,i-width+startIndex);
                }
            }
            if (bestLength == 0) {
                b.append(""+x[i]);
            } else {
                b.append("(" + bestIndex+"," + bestLength+")");
                i += bestLength-1;
            }
        }
        return b.toString();
    }

    /**
     * When a file in a user's Dropbox folder is changed, while synchronizing Dropbox tries to only
     * upload the parts of the file that are different. The first step to accomplish this involves
     * building a representation of the difference between the two versions of the same file.
     * As part of Dropbox's engineering team, you've decided to implement a function that will
     * represent the difference between two strings in the following format:
     * - Two strings are merged into one.
     * - Text that is present in both versions is left untouched.
     * - Text that is present only in the old version is enclosed in parentheses ((, )).
     * - Text that is present only in the new version is enclosed in brackets ([, ]).
     * - Among all possible representations, your function returns the shortest one (brackets and parentheses do not count).
     * - Among representations of minimal length, your function returns the lexicographically smallest one.
     *      For this task, please, assume that any other character < '(' < ')' < '[' < ']'.
     * Now all you have to do is to implement this function.
     * Example
     *      For oldVersion = "same_prefix_1233_same_suffix"
     *      and newVersion = "same_prefix23123_same_suffix", the output should be
     *      displayDiff(oldVersion, newVersion) = "same_prefix(_1)23[12]3_same_suffix".
     * Input/Output
     *      [time limit] 3000ms (java)
     *      [input] string oldVersion
     *          Constraints:
     *          1 ≤ oldVersion.length ≤ 35.
     *      [input] string newVersion
     *          It is guaranteed that neither oldVersion nor newVersion contains parentheses or brackets.
     *          Constraints:
     *          1 ≤ newVersion.length ≤ 35.
     *      [output] string
     *          A string built from oldVersion and newVersion satisfying all of the conditions mentioned above.
     */
    public static String displayDiff(String oldVersion, String newVersion) {
        StringBuilder result = new StringBuilder();
        if (oldVersion.equals(newVersion)) {
            result.append(oldVersion);
        } else {
            List<Integer> differences = new ArrayList<Integer>();
//            for (int index = 0 ; index < oldVersion.length() && index < newVersion.length() ; index++) {
//                if (oldVersion.charAt(index) != newVersion.charAt(index) ) {
//                    if (index < oldVersion.length() || index < newVersion.length()) {
//                        differences.add(index);
//                    }
//                }
//            }

            for (int indexNew = 0 ; indexNew < newVersion.length() ; indexNew++) {
                for (int indexOld = indexNew ; indexOld < oldVersion.length() ; indexOld++) {
                    if (oldVersion.charAt(indexOld) != newVersion.charAt(indexNew)) {
                        differences.add(indexNew);
                    }
                }
            }


            StringBuilder onlyInFirstString = new StringBuilder();
            StringBuilder onlyInSecondString = new StringBuilder();
        }


        return result.toString();
    }
}
