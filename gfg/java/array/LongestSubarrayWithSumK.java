package array;

import java.util.*;

/*
*
* Problem Name : Longest Subarray with Sum K
* Problem Link : https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
*
* Problem Statement :
*
* Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 10^5
-10^4 ≤ arr[i] ≤ 10^4
-10^9 ≤ k ≤ 10^9
*
*
*
* */
public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        // code here

        /*                    j
             0   1  2  3  4   5
            [10, 5, 2, 7, 1, -10]
         0   10  15 17 24 25 15      i
            sum = 15 - k (15)
            ans = 6
            {0 : -1, 10 : 0, 15 : 1, 17 : 2, 24 : 3}
        */

        int n = arr.length;
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if(map.get(sum) == null){
                map.put(sum, i);
            }
        }
        return ans;
    }
}
