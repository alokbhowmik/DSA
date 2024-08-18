package LeetCode.java.dp;

/**
 * 
 * Problem Name : Maximum Number of Points with Cost 1937
 * Problem Link : https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
 * 
 * Problem Description :
 * 
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0.
 

Example 1:


Input: points = [[1,2,3],[1,5,1],[3,1,1]]
Output: 9
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
You add 3 + 5 + 3 = 11 to your score.
However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
Your final score is 11 - 2 = 9.
Example 2:


Input: points = [[1,5],[2,3],[4,2]]
Output: 11
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
You add 5 + 3 + 4 = 12 to your score.
However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
Your final score is 12 - 1 = 11.
 

Constraints:

m == points.length
n == points[r].length
1 <= m, n <= 105
1 <= m * n <= 105
0 <= points[r][c] <= 105

* Solution 1 
-------------
Time Complexity :O(n*m)
Space Complexity : O(m*n)
This Approach Show TLE 

Solution 2
---------------
Time Complexity O(m*n)
Space Complexity O(m)
 
 */
public class MaximumNoOfPointsWithCost {
    // Solution 1 Wth Time Complexity O(n*m) Space Complexity O(m * n)
    long solve(int r, int c, int[][] points, Long[][] dp){
        if(r == points.length) return 0;
        if(dp[r][c] != null) return dp[r][c];
        long sum = 0, diff = 0, maxPoint = 0;
        for(int i=0; i<points[0].length; i++){
            if(r > 0){
                diff = Math.abs(c - i);
            }
            sum = points[r][i] - diff + solve(r + 1, i, points, dp);
            maxPoint = Math.max(maxPoint, sum);
        }
        return dp[r][c] = maxPoint;
    }
    public long maxPoints(int[][] points) {
        // Long[][] dp = new Long[points.length][points[0].length];
        // return solve(0, 0, points, dp);
        // Solution 2
        int n = points.length;
        int m = points[0].length;

        // dp array to store the maximum points up to each row
        long[] dp = new long[m];

        // Initialize dp with the values of the first row
        for (int j = 0; j < m; j++) {
            dp[j] = points[0][j];
        }

        // Iterate over the rows starting from the second row
        for (int i = 1; i < n; i++) {
            // Create a new array to store the current row's maximum points
            long[] newDp = new long[m];

            // Left to right pass
            long maxLeft = Long.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                maxLeft = Math.max(maxLeft, dp[j] + j);
                newDp[j] = points[i][j] + maxLeft - j;
            }

            // Right to left pass
            long maxRight = Long.MIN_VALUE;
            for (int j = m - 1; j >= 0; j--) {
                maxRight = Math.max(maxRight, dp[j] - j);
                newDp[j] = Math.max(newDp[j], points[i][j] + maxRight + j);
            }

            // Update dp array
            dp = newDp;
        }

        // Find the maximum value in the last row
        long result = Long.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.max(result, dp[j]);
        }

        return result;
    }
}
