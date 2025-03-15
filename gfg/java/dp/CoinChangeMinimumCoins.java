package dp;

/*
*Problem Name : Coin Change Minimum Coins
*
*Problem Link : https://www.geeksforgeeks.org/problems/number-of-coins1824/1
*
*Problem Statement : 
*
* You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5
Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1
Input: coins[] = [5, 1], sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin
Input: coins[] = [4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.

Constraints:
1 ≤ sum * coins.size() ≤ 10^6
0 <= sum <= 10^4
1 <= coins[i] <= 10^4
1 <= coins.size() <= 10^3
* Approach 1 
*--------------
*TC = O(2^(n * sum) SC = O(1)
*
* Approach 2 : Recursion + Memorization
*--------------
*TC = O(n * sum) SC = O(n * sum)
*/
public class CoinChangeMinimumCoins{
    private final int inf = 100000;
    public int minCoins(int coins[], int sum) {
        Integer dp[][] = new Integer[coins.length + 1][sum + 1];
        int ans = solve(0, sum, coins, dp);
        return ans == inf ? -1 : ans;
    }
    private int solve(int i, int sum, int[] coins, Integer[][] dp){
        if(sum == 0) return  0 ;
        if(sum < 0 || i >= coins.length ) return  inf;
        if(dp[i][sum] != null) return  dp[i][sum];
        int take = 1 + solve(i, sum - coins[i], coins, dp);
        int skip = solve(i + 1, sum, coins, dp);
        return dp[i][sum] = Math.min(take, skip);
    }
}