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
*/
public class MinCostClimbingStairs{
    int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length + 1];
        return Math.min(
                solve(0, cost.length, cost, dp),
                solve(1, cost.length, cost, dp)
        );
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