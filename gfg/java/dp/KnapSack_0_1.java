
package gfg.java.dp;

/**
 * KnapSak_0_1
 * 
 * Problem Name : 0 - 1 Knapsack Problem
 * Problem Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * Problem Statement 
 * 
 * You are given weights and values of items, and put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val and wt which represent values and weights associated with items respectively. Also given an integer W which represents knapsack capacity, find out the maximum sum values subset of val[] such that the sum of the weights of the corresponding subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don't pick it (0-1 property).

Examples :

Input: W = 4, val[] = {1,2,3}, wt[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 
Input: W = 3, val[] = {1,2,3}, wt[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
2 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ val[i] ≤ 1000

Time Complexity : O(N*W)
Space Complexity : O(N * W)
 */
public class KnapSack_0_1 {

    int solve(int i, int W, int wt[], int val[], Integer[][] dp){
        if(i >= wt.length || W == 0) return 0;
        if(dp[i][W] != null) return dp[i][W];
        int skip = solve(i + 1, W, wt, val, dp);
        int take = 0;
        if(W >= wt[i]){
            take = val[i] + solve(i + 1, W - wt[i], wt, val, dp);
        }
        return dp[i][W] = Math.max(take, skip);
        
    }
    int knapSack(int W, int wt[], int val[]) {
        // your code here
        Integer[][] dp = new Integer[wt.length + 1][W + 1];
        return solve(0, W, wt, val, dp);
    }
}