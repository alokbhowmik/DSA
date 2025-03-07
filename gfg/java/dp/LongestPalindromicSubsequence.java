package dp;

/*
*Problem Name : Longest Palindromic Subsequence
*
*Problem Link : https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
*
*Problem Statement : 
*
* Given a string s, return the length of the longest palindromic subsequence.

A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.
Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
Constraints:
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.
*
* Approach 1 
*--------------
*TC = O(2 ^ n*m) SC = O(1)
*/
public class LongestPalindromicSubsequence{
    public int longestPalinSubseq(String s) {
        return solve(0, s.length(), s);
    }

    private int solve(int i, int j, String s){
        if(i > j ) return  0 ;
        if(i == j) return  1;
        if (s.charAt(i) == s.charAt(j)){
            return  2 + solve(i + 1, j - 1, s);
        }
        return Math.max(
                solve(i + 1, j, s),
                solve(i, j -1, s)
        );
    }
}