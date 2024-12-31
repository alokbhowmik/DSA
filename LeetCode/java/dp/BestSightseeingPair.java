/*
*
* Problem Name : Best Sightseeing Pair
* Problem Link : https://leetcode.com/problems/best-sightseeing-pair/?envType=daily-question&envId=2024-12-27
*
* Problem Statement
*
* You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.



Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2


Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000
* */

public class BestSightseeingPair {

    private int score = 0;
    private Integer[] dp;

    public int maxScoreSightseeingPair(int[] values) {
        dp = new Integer[values.length + 1];
        solve(values, values.length - 1);
        return score;
    }

    private int solve(int[] values, int i) {
        if (i < 0) return 0;
        if (dp[i] != null) return dp[i];
        int x = values[i];
        int prev = solve(values, i - 1);
        score = Math.max(score, prev + x - i);
        return dp[i] = Math.max(prev, x + i);
    }
}
