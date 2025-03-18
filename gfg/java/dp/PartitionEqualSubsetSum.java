package dp;

/*
*Problem Name : Partition Equal Subset Sum
*
*Problem Link : https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
*
*Problem Statement : 
*Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.
Constraints:
1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200
* Approach 1 
*--------------
*TC = O(2 ^ (sum * n) SC = O(1)
*
* Approach 2 : Recurtion + memorization
*--------------
*TC = O((sum * n) SC = O(n * sum)
*
* Approach 3 : Bottom - up
*--------------
*TC = O(2 ^ (sum * n) SC = O(1)
*/
public class PartitionEqualSubsetSum{
    boolean equalPartition(int arr[]) {
        int sum = 0;
        for(int num : arr) sum += num;
        if(sum % 2 == 1) return false;

        boolean dp[][] = new boolean[arr.length + 1][sum/ 2 + 1];
        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = true;
        }
        for(int i = arr.length - 1; i>= 0; i--){
            for(int s = 1 ; s <= sum/2; s++){
                dp[i][s] = dp[i + 1][s]; // skip
                if(s - arr[i] >= 0){
                    dp[i][s] |= dp[i + 1][s - arr[i]];
                }
            }
        }
        return dp[0][sum/2];
//        Boolean[][] dp = new Boolean[arr.length + 1][sum/2 + 1];
//        return solve(0, sum/2, arr, dp);
    }
    private boolean solve(int i, int sum, int[] arr, Boolean[][] dp){
        if(sum == 0) return true;
        if(sum < 0 || i >= arr.length) return  false;
        if(dp[i][sum] != null) return  dp[i][sum];
        return dp[i][sum] = solve(i + 1, sum - arr[i], arr, dp) || solve(i + 1, sum, arr, dp);
    }
}