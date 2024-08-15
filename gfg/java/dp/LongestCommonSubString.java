package gfg.java.dp;

/**
 * 
 * Problem Name : Longest Common Substring
 * Problem Link : https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
 * Problem Statement
 * You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.

Examples:

Input: str1 = "ABCDGH", str2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" which has length 4.
Input: str1 = "ABC", str2 = "ACB"
Output: 1
Explanation: The longest common substrings are "A", "B", "C" all having length 1.
Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1<= str1.size(), str2.size()<=1000
Both strings may contain upper and lower case alphabets.
 */

public class LongestCommonSubString {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int m = str1.length();
        int n = str2.length();
        int maxLen = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
