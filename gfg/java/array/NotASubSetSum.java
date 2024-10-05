package gfg.java.array;

/**
 * 
 * Problem Name : Not a subset sum
 * Problem Link : https://www.geeksforgeeks.org/problems/smallest-number-subset1220/1
 * 
 * Problem Statement
 * 
 * Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

Examples:

Input: arr[] = [1, 2, 3]
Output: 7
Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
Input: arr[] = [3, 6, 9, 10, 20, 28]
Output: 1
Explanation: 1 is the smallest positive number for which no subset is there with sum 1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints
1 <= arr.size() <= 10^6
0 <= arr[i] <= 10^8

Time Complexity : O(n)
Space Complexity : O(1)
 */
public class NotASubSetSum {
    public long findSmallest(int[] arr) {
        // Your code goes here
        int num = 1;
        for(int a : arr){
            if(a > num ) return num;
            num += a;
        }
        return num;
    }
}
