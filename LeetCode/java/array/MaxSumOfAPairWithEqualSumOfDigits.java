package array;

import java.util.*;

/*
*
* Problem Name : Max Sum of a Pair With Equal Sum of Digits
*
* Problem Link : https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
*
* Problem Statement
*
*You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.



Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
* */
public class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        int n = nums.length ;
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int ds = digitSum(num);
            if(map.containsKey(ds)){
                ans = Math.max(ans, map.get(ds) + num);
                map.put(ds, Math.max(num, map.get(ds)));
            }else{
                map.put(ds, num);
            }
        }
        return ans;
    }
    private int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
