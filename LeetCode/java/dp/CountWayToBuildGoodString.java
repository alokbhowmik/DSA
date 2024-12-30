package LeetCode.java.dp;
/*
 * 
 * Problem Link : https://leetcode.com/problems/count-ways-to-build-good-strings/description/
 * Problem Name : Count Ways To Build Good Strings ( 2466 )
 * Problem description : 
 * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

 

Example 1:

Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation: 
One possible valid good string is "011". 
It can be constructed as follows: "" -> "0" -> "01" -> "011". 
All binary strings from "000" to "111" are good strings in this example.
Example 2:

Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".
 

Constraints:

1 <= low <= high <= 105
1 <= zero, one <= low
 * 
 */

class CountWayToBuildGoodString {
    private int MOD = (int)1e9 + 7;
    private Integer dp[];
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        dp = new Integer[high + 1];
        for(int len = low ; len <= high ; len++){
            ans = (ans % MOD + dfs(zero, one, len) % MOD) % MOD;
        }
        return ans;
        // TC = O((high - low+ 1) * high) S.C = O(high + 1)
    }
    
    private int dfs(int zero, int one, int len){
        if(len == 0) return 1;
        if(len < 0) return 0;
        if(dp[len] != null) return dp[len];
        int addZero = dfs(zero, one, len - zero);
        int addOne  = dfs(zero, one, len - one);
        return dp[len] = (addZero % MOD + addOne % MOD) % MOD;
    }
}