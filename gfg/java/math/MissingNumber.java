package gfg.java.math;

/**
 * 
 * 
 * Problem Name : Missing in Array
 * Problem Link : https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
 * 
 * Problem Statement 
 * =======================
 * 
 * Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing. Return the missing element.

Examples:

Input: n = 5, arr[] = [1,2,3,5]
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4.
Input: n = 2, arr[] = [1]
Output: 2
Explanation : All the numbers from 1 to 2 are present except 2.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 10^5
1 ≤ arr[i] ≤ n

Time Complexity : O(n) 
Space Complexity : O(1)
 */
public class MissingNumber {
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        int total = n * (n + 1)/2;
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return total - sum;
    }
}
