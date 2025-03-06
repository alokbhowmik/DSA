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
*/
public class LongestCommonSubsequence{
    int lcs(String s1, String s2) {
        // code here
        return solve(s1, s2, 0, 0);
    }
    private int solve(String s1, String s2, int i, int j ){
        if(i >= s1.length() || j >= s2.length()) return  0 ;
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + solve(s1, s2, i + 1, j + 1);
        }
        return Math.max(solve(s1, s2, i + 1, j ), solve(s1, s2, i, j + 1));
    }
}