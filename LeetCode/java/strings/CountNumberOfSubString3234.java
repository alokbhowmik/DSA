package LeetCode.java.strings;

/**
 * CountNumberOfSubString3234
 * 
 * Problem Name : Count the Number of Substrings With Dominant Ones 3234
 * 
 * Problem Link : https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/description/
 * 
 * 
 * You are given a binary string s.

Return the number of 
substrings
 with dominant ones.

A string has dominant ones if the number of ones in the string is greater than or equal to the square of the number of zeros in the string


Example 1:

Input: s = "00011"

Output: 5

Explanation:

The substrings with dominant ones are shown in the table below.

i	j	s[i..j]	Number of Zeros	Number of Ones
3	3	1	0	1
4	4	1	0	1
2	3	01	1	1
3	4	11	0	2
2	4	011	1	2
Example 2:

Input: s = "101101"

Output: 16

Explanation:

The substrings with non-dominant ones are shown in the table below.

Since there are 21 substrings total and 5 of them have non-dominant ones, it follows that there are 16 substrings with dominant ones.

i	j	s[i..j]	Number of Zeros	Number of Ones
1	1	0	1	0
4	4	0	1	0
1	4	0110	2	2
0	4	10110	2	3
1	5	01101	2	3
 

Constraints:

1 <= s.length <= 4 * 104
s consists only of characters '0' and '1'.



 */
public class CountNumberOfSubString3234 {

    // Solution 1
    // Time Complexity = O(n^2)
    // Space Complexity = O(n^2)
    // This solution show TLE 
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ones[][] = new int[n][n];
        int zeros[][] = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros[i][i] = 1;
            } else {
                ones[i][i] = 1;
            }
            if (ones[i][i] >= zeros[i][i] * zeros[i][i]) {
                cnt++;
            }
        }
    // System.out.println(cnt);
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = len - 1; i < n && j < n; i++, j++) {
                if (s.charAt(j) == '0') {
                    zeros[i][j] = zeros[i][j - 1] + 1;
                    ones[i][j] = ones[i][j - 1];
                } else {
                    ones[i][j] = ones[i][j - 1] + 1;
                    zeros[i][j] = zeros[i][j - 1];
                }
                if (ones[i][j] >= zeros[i][j] * zeros[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}