package gfg.java.array;

/**
 * 
 * Problem Name : Product array puzzle
 * Problem Link : https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
 * 
 * Problem Statement 
 * 
 * Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].

Examples:

Input: nums[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Input: nums[] = [12,0]
Output: [0, 12]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= nums.size() <= 1000
0 <= nums[i] <= 200
nums[i] may contain duplicates.

Time Complexity : O(n)
Space Complexity : O(1)
 */
public class ProdctArrayPuzzle {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long product = 1;
        long zero = 0;
        long[] res = new long[nums.length];
        for(int num: nums){
            if(num > 0)
            product *= num;
            else zero++;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0 && zero > 0){
                res[i] = 0;
            }else if(nums[i] == 0 && zero > 1){
                res[i] = 0;
            }else if(nums[i] == 0 && zero == 1){
                res[i] = product;
            }
            else{
                res[i] = product / nums[i];   
            }
        }
        return res;
    }
}
