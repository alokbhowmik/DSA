package dp;

/*
*Problem Name : Longest Common Subsequence
*
*Problem Link : https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
*
*Problem Statement : 
*
* Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

Examples:

Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
Input: s1 = "ABC", s2 = "AC"
Output: 2
Explanation: The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.
Input: s1 = "XYZW", s2 = "XYWZ"
Output: 3
Explanation: The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.
Constraints:
1<= s1.size(), s2.size() <=10^3
Both strings s1 and s2 contain only uppercase English letters.
* Approach 1 
*--------------
*TC = O(2 ^ (m * n)) SC = O(1)
*
* Approach 2
*--------------
*TC = O(n * m) SC = O(n * m )
*
* Approach 3 : Top Down
*--------------
* TC = O(m * n) SC = O(m * n )
*/
public class LongestCommonSubsequence{
    int lcs(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    private int solve(String s1, String s2, int i, int j, Integer[][] dp ){
        if(i >= s1.length() || j >= s2.length()) return  0 ;
        if (dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1, s2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(solve(s1, s2, i + 1, j, dp ), solve(s1, s2, i, j + 1, dp));
    }
}