package LeetCode.java.slidingWindow;
/**
 * MinSwapToGroupOne2134
 * 
 * Problem Name : Minimum Swaps to Group All 1's Together II
 * Problem Link : https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/
 * 
 * 
 * A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.

 

Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.
Example 2:

Input: nums = [0,1,1,1,0,0,1,1,0]
Output: 2
Explanation: Here are a few of the ways to group all the 1's together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1's together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
Example 3:

Input: nums = [1,1,0,0,1]
Output: 0
Explanation: All the 1's are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.


Time Complexity = O(n)
Space Complexity = O(1)
 */
public class MinSwapToGroupOne2134 {
    /*
     * 
     * 
     * 
     *  Approach 1
     * 
     */
    public int minSwaps1(int[] nums) {
        int ones = 0, n = nums.length, x = 0, onesInWindow = 0;
        for (int num : nums) {
            ones += num;
        }
        int nums2[] = new int[2 * n];
        for (int i = 0; i < n * 2; i++) {
            nums2[i] = nums[i % n];
        }
        for (int i = 0; i < n * 2; i++) {
            if (i >= ones && nums2[i - ones] == 1)
                x--;
            if (nums2[i] == 1)
                x++;
            onesInWindow = Math.max(x, onesInWindow);
        }
        return ones - onesInWindow;
    }
    
    /*
     * Approach 2
     */
    public int minSwaps(int[] nums) {
        int ones = 0;
        int n = nums.length;

        for(int num: nums) ones+= num;
        if(ones == 0 || ones == 1) return 0;
        int minSwap = Integer.MAX_VALUE;
        int zeros = 0, aZeros = 0;
        int i=0, j=0;
        for(; j<ones; j++){
            if(nums[j] == 0) zeros++;
        }
        minSwap = Math.min(minSwap, zeros);
        i = j -1;
        j = ones;
        while(j != i){
            if(nums[(n + j)%n] == 0) zeros++;
            if(nums[(j - ones + n)%n] == 0) zeros--;
            j++;
            j = j %n;
            minSwap = Math.min(minSwap, zeros);
        }
        return minSwap;
    }
}
