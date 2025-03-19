package slidingWindow;

/*
*Problem Name : Minimum Operations to Make Binary Array Elements Equal to One I
*
*Problem Link : https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=daily-question&envId=2025-03-19
*
*Problem Statement : 
*
* You are given a binary array nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.



Example 1:

Input: nums = [0,1,1,1,0,0]

Output: 3

Explanation:
We can do the following operations:

Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
Example 2:

Input: nums = [0,1,1,1]

Output: -1

Explanation:
It is impossible to make all elements equal to 1.



Constraints:

3 <= nums.length <= 10^5
0 <= nums[i] <= 1
* Approach 1 : Sliding Window
*--------------
*TC = O(n) SC = O(1)
*/
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI{
    public int minOperations(int[] nums) {
        int op = 0, k = 3;
        int r = 0, l = 0;
        while(r < nums.length){
            while(r - l + 1 == k) {
                if(nums[l] == 0){
                    op++;
                    for(int i = l; i<=r; i++){
                        nums[i] ^= 1;
                    }
                }
                l++;
            }
            r++;
        }
        while(l < nums.length){
            if(nums[l] == 0) return -1;
            l++;
        }
        return op;
    }
}