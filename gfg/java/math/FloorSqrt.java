package gfg.java.math;

/**
 * 
 * Problem Name : Square root of a number
 * Problem Link : https://www.geeksforgeeks.org/problems/square-root/1
 * Problem Statement 
 * 
 * Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number

Examples:

Input: n = 5
Output: 2
Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 107
 */
public class FloorSqrt {
    long floorSqrt(long n) {
        // Your code here
        return (long)Math.sqrt(n);
    }
}
