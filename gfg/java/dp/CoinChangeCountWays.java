package dp;

/*
*Problem Name : Coin Change Count Ways
*
*Problem Link : https://www.geeksforgeeks.org/problems/coin-change2448/1
*
*Problem Statement : 
*
* Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer.

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].
Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
Constraints:
1 <= sum <= 10^3
1 <= coins[i] <= 10^4
1 <= coins.size() <= 10^3
* Approach 1 : Recurtion
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2 : Recurtion + Memorization
*--------------
*TC = O(sum*n) SC = O(1)
*
* Approach 3 : Bottom Up
*--------------
*TC = O(sum*n) SC = O(1)
*/
public class CoinChangeCountWays{
    public int count(int coins[], int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];

        for(int i = 0; i<coins.length; i++){
            dp[i][sum] = 1;
        }
        for(int i = coins.length -1; i>= 0; i--){
            for(int curr = sum -1; curr >= 0; curr--){
                dp[i][curr] += dp[i + 1][curr];
                if(curr + coins[i] <= sum){
                    dp[i][curr] += dp[i][curr + coins[i]];
                }
            }
        }
        return dp[0][0];
    }

    private int solve(int i, int curr, int[] coins, int sum, Integer[][] dp){
        if(curr == sum) return 1;
        if(curr > sum || i > coins.length) return  0 ;
        if (dp[i][curr] != null) return  dp[i][curr];
        int take = solve(i, curr + coins[i], coins, sum, dp);
        int skip = solve(i + 1, curr, coins, sum, dp );
        return dp[i][curr] = take  + skip ;
    }
}