/*
*Problem Name : Check if Number is a Sum Of Powers Of Three
*
*Problem Link : https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
*
*Problem Statement : 
*
* Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.



Example 1:

Input: n = 12
Output: true
Explanation: 12 = 31 + 32
Example 2:

Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 34
Example 3:

Input: n = 21
Output: false


Constraints:

1 <= n <= 10^7
*
* Approach 1 
*--------------
*TC = O(log(n)) SC = O(1)
*/
public class CheckIfNumberIsASumOfPowersOfThree{
    public boolean checkPowersOfThree(int n) {
        int[] dp = new int[17];
        for (int i = 0; i < 17; i++) {
            dp[i] = (int) Math.pow(3, i);
        }

        int i = 16;
        while (n != 0 && i >= 0) {
            while (dp[i] > n) {
                i--;
            }
            n -= dp[i];
            i--;
        }
        return n == 0;
    }
}