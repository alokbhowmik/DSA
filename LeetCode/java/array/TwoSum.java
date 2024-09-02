package LeetCode.java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem Name : TWO Sum 
 * Problem Link : https://leetcode.com/problems/two-sum/description/?envType=daily-question&envId=2024-08-27
 * Problem Statement 
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-109 <= nums[i] <= 10^9
-109 <= target <= 10^9
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 * 
 * Solution 1 
 * ================
 * Time Complexity : O(nlog(n))
 * Space Complexity : O(n) 
 *  
 * Solution 2
 * =================
 * Time Complexity : O(n)
 * Space Complexity : O(n) // due to Map
 */
public class TwoSum {
    // Solution 1
    class Pair implements Comparable<Pair> {
        int num, idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            return this.num - p.num;
        }
    }

    private int[] solution1(int[] nums, int t) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int l = 0, r = n - 1;
        while (l < r) {
            int total = pairs[l].num + pairs[r].num;
            if (total == t) {
                return new int[] { pairs[l].idx, pairs[r].idx };
            } else if (total > t) {
                r--;
            } else {
                l++;
            }
        }
        return new int[2];
    }

    private int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(map.get(target - nums[i]) != null){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
    public int[] twoSum(int[] nums, int t) {
        // return solution1(nums, t);
        return solution2(nums, t);
    }
}
