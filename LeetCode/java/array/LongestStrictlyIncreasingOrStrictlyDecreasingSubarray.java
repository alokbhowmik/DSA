package array;

/*
*
* Problem Name : Longest Strictly Increasing or Strictly Decreasing Subarray
*
* Problem Link : https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/
*
* Problem Statement
*
* You are given an array of integers nums. Return the length of the longest
subarray
 of nums which is either
strictly increasing
 or
strictly decreasing
.



Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.



Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 50
* */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        // Tc = O(n) SC = O(1)
        int ans = 1;
        int prev = nums[0];
        int inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i]; // prev = 3 num = 2
            if (num > prev) { // inc = 1
                inc++;
            } else {
                inc = 1;
            }

            if (num < prev) { // 2 < 3
                dec++;
            } else {
                dec = 1;  // dec = 2;
            }
            ans = Math.max(ans, Math.max(inc, dec)); // 2
            prev = num;
        }
        return ans;
    }
}
