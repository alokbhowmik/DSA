package LeetCode.java.dp;

/*
* Problem Name : Minimum Cost For Tickets
* Problem Link : https://leetcode.com/problems/minimum-cost-for-tickets/description/
*
* Problem Statement
* -----------------
*
* You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.



Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.


Constraints:

1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000
* */
public class MinimumCostsForTickets {
    private Integer dp[];

    // T.C = O(N) SC = O(N)
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        boolean[] travelDay = new boolean[maxDay + 1];
        dp = new Integer[maxDay + 1];
        for (int day : days) {
            travelDay[day] = true;
        }
        return solve(travelDay, costs, days[0], maxDay);
    }

    private int solve(boolean[] travelDay, int[] costs, int start, int maxDay) {
        if (start > maxDay) return 0;
        if (dp[start] != null) return dp[start];
        if (!travelDay[start]) return solve(travelDay, costs, start + 1, maxDay);
        int take_1_day = costs[0] + solve(travelDay, costs, start + 1, maxDay);
        int take_7_day = costs[1] + solve(travelDay, costs, start + 7, maxDay);
        int take_30_day = costs[2] + solve(travelDay, costs, start + 30, maxDay);
        return dp[start] = Math.min(take_1_day, Math.min(take_7_day, take_30_day));
    }
}
