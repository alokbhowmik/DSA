package LeetCode.java.dp;

/**
 * Problem Name : 2 Keys Keyboard
 * Problem Link : https://leetcode.com/problems/2-keys-keyboard/description/
 * <p>
 * Problem Statement
 * <p>
 * There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
 * <p>
 * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class TwoKeyKeyboard {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int step = 0;
        int factor = 2;
        while (n > 1) {
            while (n % factor == 0) {
                step += factor;
                n /= factor;
            }
            factor++;
        }
        return step;
    }
}
