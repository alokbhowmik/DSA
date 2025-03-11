package dp;

/*
*Problem Name : Ways to Reach the n_th Stair
*
*Problem Link : https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
*
*Problem Statement : 
*
* There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair.
Input: n = 2
Output: 2
Explanation: There are 2 ways to reach 2th stair: {1, 1} and {2}.
Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.
Constraints:
1 ≤ n ≤ 44
* Approach 1 : Recurtion
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2 : Recurtion + Memorization
*--------------
*TC = O(n) SC = O(n)
*
* Approach 3 : Bottom up
*--------------
*TC = O(n) SC = O(1)
*/
public class WaysToReachTheN_thStair{
    int countWays(int n) {
        int[] dp = new int[n + 1];
       dp[0] = 1;
       for(int i = 1; i <= n; i++){
           dp[i] += dp[i - 1];
           if(i - 2 >= 0) dp[i] += dp[i - 2] ;
       }
       return dp[n];
    }

}