package dp;

/*
*Problem Name : Stickler Thief
*
*Problem Link : https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
*
*Problem Statement : 
*
* Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
Determine the maximum amount he can loot.

Examples:

Input: arr[] = [6, 5, 5, 7, 4]
Output: 15
Explanation: Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6 + 5 + 4 = 15.
Input: arr[] = [1, 5, 3]
Output: 5
Explanation: Loot only 2nd house and get maximum amount of 5.
Input: arr[] = [4, 4, 4, 4]
Output: 8
Explanation: The optimal choice is to loot every alternate house. Looting the 1st and 3rd houses, or the 2nd and 4th, both give a maximum total of 4 + 4 = 8.
Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4
*
* Approach 1 
*--------------
*TC = O(2 ^ n) SC = O(1)
*
* Approach 2 : Recurtion + Memorization
*--------------
*TC = O(n) SC = O(n)
*
* Approach 3 : Iterative
*--------------
*TC = O(n) SC = O(n)
*
* Approach 4 : Iterative
*--------------
*TC = O(n) SC = O(1)
*/
public class SticklerThief{
    public int findMaxSum(int arr[]) {
//        Integer dp[] = new Integer[arr.length + 1];
//        return solve(0, arr, dp);
        int a = 0;  // i + 1
        int b = 0 ; // i + 2
        for(int i = arr.length - 1; i>= 0; i--){
            // dp[i] = dp[i + 1];
            // dp[i] = Math.max(dp[i + 1], arr[i] + dp[i + 2]);
            int sum = Math.max(a, arr[i] + b);
            b = a;
            a = sum;
        }
        return a;
    }

    private int solve(int i, int[] arr, Integer dp[]){
        if(i >= arr.length ) return 0 ;
        if(dp[i] != null) return dp[i];
        int skip = solve(i + 1, arr, dp);
        int take = arr[i] + solve(i + 2, arr, dp);
        return dp[i] = Math.max(take, skip );
    }
}