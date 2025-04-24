package slidingWindow;
import java.util.*;

/*
*Problem Name : Count Complete Subarrays in an Array
*
*Problem Link : https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-24
*
*Problem Statement : 
*
* You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.



Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2000
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class CountCompleteSubarraysInAnArray{
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            set.add(num);
        }
        int totalUniqueElement = set.size();
        set.clear();
        int l = 0, r = 0, ans = 0;
        int n = nums.length;

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(l <= r && totalUniqueElement == map.size()){
                ans += (n - r );
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            r++;
        }
        return ans;

    }
}