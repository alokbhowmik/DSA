package gfg.java.array;

/**
 * SplitAnArrayIntoTwoEqualSumSubarray
 * 
 * Problem Name : Split an array into two equal Sum subarrays
 * Problem Link : https://www.geeksforgeeks.org/problems/split-an-array-into-two-equal-sum-subarrays/1
 * 
 * Problem Statement 
 * 
 * Given an array of integers arr, return true if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays are equal. If it is not possible then return false.

Examples:

Input: arr = [1, 2, 3, 4, 5, 5]
Output: true
Explanation: In the above example, we can divide the array into two subarrays with eqaul sum. The two subarrays are: [1, 2, 3, 4] and [5, 5]. The sum of both the subarrays are 10. Hence, the answer is true.
Input: arr = [4, 3, 2, 1]
Output: false
Explanation: In the above example, we cannot divide the array into two subarrays with eqaul sum. Hence, the answer is false.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1<=arr.size()<=10^5 
1<=arr[i]<=10^6

Time Complexity = O(n)
Space Complexity = O(1)
 */
public class SplitAnArrayIntoTwoEqualSumSubarray {

    public boolean canSplit(int arr[]) {
        // code here
        int total = 0;
        for(int num : arr){
            total += num;
        }
        if(total %2 == 1) return false;
        total /= 2;
        
        for(int num : arr){
            total -= num;
            if(total == 0) return true;
        }
        return false;
    }
}
