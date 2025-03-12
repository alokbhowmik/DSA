package dp;

/*
*Problem Name : Min Cost Climbing Stairs
*
*Problem Link : https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/1
*
*Problem Statement : 
*
* Approach 1 : Recursion
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2 : Recursion + Memorization
*--------------
*TC = O(n) SC = O(n)
*Approach 3 : Top-Down
*--------------
*TC = O(n) SC = O(n)
*/
public class MinCostClimbingStairs{
    int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        dp[cost.length] = 0 ;
        dp[cost.length + 1] = 1000 ;
        for(int i = cost.length - 1; i>= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    private int solve(int i, int n, int[] cost, Integer[] dp){
        if(i > n) return 1000;
        if(i == n) return 0 ;
        return cost[i] + Math.min(
                solve(i + 1, n, cost, dp),
                solve(i + 2, n, cost, dp)
        );
    }
}