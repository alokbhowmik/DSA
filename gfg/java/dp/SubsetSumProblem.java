package dp;

/*
*Problem Name : Subset Sum Problem
*
*Problem Link : https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
*
*Problem Statement : 
*
* Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 10^4
* Approach 1  : Recurtion
*--------------
*TC = O(2^(sum + n) SC = O(1)
*
* Approach 2  : Recurtion + Memorization
*--------------
*TC = O(sum * n) SC = O(sum * n)
*
* Approach 3  : Bottom - up
*--------------
*TC = O(sum * n) SC = O(sum * n)
*
* Approach 4  : Optimize
*--------------
*TC = O(sum * n) SC = O(sum)
*/
public class SubsetSumProblem{

    Boolean isSubsetSum(int arr[], int sum) {
        // code here
//        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
//        return solve(0, sum, arr, dp);

        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;

        for(int i = arr.length - 1; i>= 0; i--){
            for(int s = sum ; s > 0; s--){
                //dp[i][s] = dp[i + 1][s]; // skip
                if(s - arr[i] >= 0){
                    dp[s] |= dp[s - arr[i]];
                }
            }

        }
        return dp[sum];
    }
    private boolean solve(int i, int sum, int[] arr, Boolean[][] dp){
        if(sum == 0) return true;
        if(sum < 0 || i >= arr.length ) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean take = solve(i + 1, sum - arr[i], arr, dp);
        boolean skip = solve(i + 1, sum, arr, dp);
        return dp[i][sum] = take || skip ;
    }
}