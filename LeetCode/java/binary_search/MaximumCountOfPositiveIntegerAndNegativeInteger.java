package binary_search;

/*
*Problem Name : Maximum Count of Positive Integer and Negative Integer
*
*Problem Link : https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=daily-question&envId=2025-03-12
*
*Problem Statement : 
*
* Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.



Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
Example 2:

Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
Example 3:

Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.


Constraints:

1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums is sorted in a non-decreasing order.


Follow up: Can you solve the problem in O(log(n)) time complexity?
* Approach 1 
*--------------
*TC = O(n) SC = O(1)
*
* Approach 2 : binary Search
*--------------
*TC = O(log(n)) SC = O(1)
*/
public class MaximumCountOfPositiveIntegerAndNegativeInteger{
    public int maximumCount(int[] nums) {
        int negCount = 0, posCount = 0;
//        for(int num : nums){
//            if(num > 0){
//                posCount++;
//            }else if(num < 0){
//                negCount++;
//            }
//        }
        negCount = findNegative(nums);
        posCount = findPositive(nums);
        return Math.max(negCount,posCount );
    }

    private int findNegative(int[] nums){

        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/ 2;
            if(nums[mid]< 0){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l ;
    }

    private int findPositive(int[] nums){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] > 0){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return nums.length - r - 1;
    }
}