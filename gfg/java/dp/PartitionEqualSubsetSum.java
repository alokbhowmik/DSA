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
*/
public class PartitionEqualSubsetSum{
    boolean equalPartition(int arr[]) {
        int sum = 0;
        for(int num : arr) sum += num;
        if(sum % 2 == 1) return false;
        return solve(0, sum/2, arr);
    }
    private boolean solve(int i, int sum, int[] arr){
        if(sum == 0) return true;
        if(sum < 0 || i >= arr.length) return  false;
        return solve(i + 1, sum - arr[i], arr) || solve(i + 1, sum, arr);
    }
}