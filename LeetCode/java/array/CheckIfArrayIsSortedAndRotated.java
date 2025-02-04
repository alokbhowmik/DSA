package array;
import java.util.*;
/*
*
*
* @Problem Name : Check if Array Is Sorted and Rotated
* @Problem Link : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2025-02-02
*
* @Problem Statement
*
* Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.



Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
* */
public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
//        int n = nums.length ;
//        Queue<Integer> que = new LinkedList<>();
//        for(int num : nums) que.offer(num);
//        while(n-- > 0){
//            int num = -1;
//            boolean isSorted = true;
//            for(int ele : que){
//                if(ele >= num){
//                    num = ele;
//                }else {
//                    isSorted = false;
//                    break;
//                }
//            }
//            if(isSorted) return true;
//            int first = que.poll();
//            que.offer(first);
//        }
//        return false;

        int inversion = 0;
        //  4 5 1 2 3
        for(int i = 1; i < nums.length ; i++){
            if(nums[i - 1] > nums[i]){
                inversion++;
            }
        }
        if(nums[0] < nums[nums.length - 1]) {
            inversion++;
        }
        return inversion <= 1;

    }
}
