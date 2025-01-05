package strings;

/**
 * Problem Name : Shifting Letters II
 * Problem Link : https://leetcode.com/problems/shifting-letters-ii/description/
 * <p>
 * Problem Statement
 * <p>
 * You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.
 * <p>
 * Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').
 * <p>
 * Return the final string after all such shifts to s are applied.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
 * Output: "ace"
 * Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
 * Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
 * Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
 * Example 2:
 * <p>
 * Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
 * Output: "catz"
 * Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
 * Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, shifts.length <= 5 * 10^4
 * shifts[i].length == 3
 * 0 <= start_i <= end_i < s.length
 * 0 <= direction_i <= 1
 * s consists of lowercase English letters.
 */
public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] count = new int[n + 1];
        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1], dir = shift[2];
            int val = dir == 1 ? 1 : -1;
            count[l] += val;
            count[r + 1] -= val;
        }
        int temp = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            temp += count[i];
            int sum = ((arr[i] - 'a' + temp) % 26 + 26) % 26;
            arr[i] = (char) ('a' + sum);
        }
        return new String(arr);
    }
}
