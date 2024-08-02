package gfg.java.dp;

/**
 * 
 * Problem Name : Edit Distance
 * Problem Link : https://www.geeksforgeeks.org/problems/edit-distance3702/1
 * 
 * 
 * Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
Examples:

Input: str1 = "geek", srt2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e'.
Input : str1 = "gfg", str2 = "gfg"
Output: 0
Explanation: Both strings are same.

Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 ≤ str1.length(), str2.length() ≤ 100
Both the strings are in lowercase.

Time Complexity  : O(n*m)
Space Complexity : O(n*m)
 */
public class EditDistance3702 {
    private String str1, str2;
    private int n, m;
    
    int solve(int i, int j, Integer dp[][]){
        if(i == n) return m - j;
        if(j == m) return n - i;
        if(dp[i][j] != null) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = solve(i+1, j+1, dp); // same character
        }else{
            int t1 = 1 + solve(i+1, j, dp); // delete
            int t2 = 1 + solve(i, j+1, dp); // insert
            int t3 = 1 + solve(i+1, j+1, dp); // update
            return dp[i][j] = Math.min(t1, Math.min(t2, t3));
        }
    }
    public int editDistance(String str1, String str2) {
        // Code here
        this.str1 = str1;
        this.str2 = str2;
        this.n = str1.length();
        this.m = str2.length();
        Integer dp[][] = new Integer[this.n][this.m];
        return solve(0, 0, dp);
    }
}
