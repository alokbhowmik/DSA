package gfg.java.array;

/**
 * 
 * Problem Name : Kadane's Algorithm
 * Problem Link : https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 * 
 * Problem Statement
 * =======================
 * 
 * Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.

Examples:

Input: arr[] = [1, 2, 3, -2, 5]
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
Input: arr[] = [-1, -2, -3, -4]
Output: -1
Explanation: Max subarray sum is -1 of element (-1)
Input: arr[] = [5, 4, 7]
Output: 16
Explanation: Max subarray sum is 16 of element (5, 4, 7)
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 10^5
-10^7 ≤ arr[i] ≤ 10^7
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 *
 */
public class KadaneAlgo {
     // Function to find the sum of contiguous subarray with maximum sum.
     int maxSubarraySum(int[] arr) {

        // Your code here
        int max = arr[0], curr = arr[0];
        for(int i=1; i<arr.length; i++){
            curr = Math.max(curr + arr[i], arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
