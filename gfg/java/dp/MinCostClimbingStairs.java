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
*/
public class MinCostClimbingStairs{
    int minCostClimbingStairs(int[] cost) {
        return Math.min(
                solve(0, cost.length, cost),
                solve(1, cost.length, cost)
        );
    }

    private int solve(int i, int n, int[] cost){
        if(i > n) return 1000;
        if(i == n) return 0 ;
        return cost[i] + Math.min(
                solve(i + 1, n, cost),
                solve(i + 2, n, cost)
        );
    }
}