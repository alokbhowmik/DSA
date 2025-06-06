package array;

/*
*Problem Name : Number of Sub arrays With Odd Sum
*
*Problem Link : https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/
*
*Problem Statement :
*
* Given an array of integers arr, return the number of subarrays with an odd sum.

Since the answer can be very large, return it modulo 109 + 7.



Example 1:

Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
Example 2:

Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.
Example 3:

Input: arr = [1,2,3,4,5,6,7]
Output: 16


Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 100
*
* Approach 1 
*--------------
*TC = O(n) SC = O(1)
*/
public class NumberOfSubArraysWithOddSum{
    private final int mod = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1;
        int count = 0, prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }
            count %= mod;
        }
        return count;
    }
}