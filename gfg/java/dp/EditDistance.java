package dp;

/*
*Problem Name : Edit Distance
*
*Problem Link : https://www.geeksforgeeks.org/problems/edit-distance3702/1
*
*Problem Statement :
*
* Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
Examples:

Input: s1 = "geek", s2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e' in s1.
Input: s1 = "gfg", s2 = "gfg"
Output: 0
Explanation: Both strings are same.
Input: s1 = "abcd", s2 = "bcfe"
Output: 3
Explanation: We can convert s1 into s2 by removing ‘a’, replacing ‘d’ with ‘f’ and inserting ‘e’ at the end.
Constraints:
1 ≤ s1.length(), s2.length() ≤ 103
Both the strings are in lowercase.
*
* Approach 1 
*--------------
*TC = O(n * m ) SC = O(n * m )
*/
public class EditDistance{
    public int editDistance(String s1, String s2) {
        // Code here
        Integer dp[][] = new Integer[s1.length() + 1][s2.length() + 1];
        return solve(0, 0, s1, s2, dp);
    }

    private int solve(int i, int j, String s1, String s2, Integer dp[][]){
        if(i == s1.length() ) return s2.length() - j;
        if(j == s2.length() ) return s1.length() - i;

        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i + 1, j + 1, s1, s2, dp);
        }
        int sol1 = 1 + solve(i, j + 1, s1, s2, dp); // insert
        int sol2 = 1 + solve(i + 1, j, s1, s2, dp);
        int sol3 = 1 + solve(i + 1, j + 1, s1, s2, dp);
        return dp[i][j] = Math.min(sol1, Math.min(sol2, sol3));
    }
}