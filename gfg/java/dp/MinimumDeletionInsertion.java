package gfg.java.dp;

/**
 * 
 * 
 * Problem Name : Minimum number of deletions and insertions
 * Problem Link : https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
 * 
 * Problem Statement 
 * ======================
 * 
 * Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Examples :

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion.
p and h deleted from heap. Then, p is inserted at the beginning.
One thing to note, though p was required yet it was removed/deleted first from its position and then it is inserted to some other position. Thus, p contributes one to the deletion_count and one to the insertion_count.
Input : str1 = "geeksforgeeks", str2 = "geeks"
Output: 8
Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 ≤ |str1|, |str2| ≤ 1000
All the characters are lowercase English alphabets
 * 
 * Time Complexity : O(n * m)
 * Space Complexity : O(n * m)
 */
public class MinimumDeletionInsertion {
    private String str1, str2;
    int lcs(int i, int j, Integer dp[][]){
        if(j >= str2.length() || i >= str1.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)){
            return 1 + lcs(i+1, j + 1, dp);
        }
        return dp[i][j] = Math.max(lcs(i+1, j, dp), lcs(i, j+1, dp));
    }
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int m = str1.length();
	    int n = str2.length();
	    this.str1 = str1;
	    this.str2 = str2;
	    Integer[][] dp = new Integer[m+1][n+1];
	    int len = lcs(0, 0, dp);
	    return (n - len) + (m - len);
	} 
}
