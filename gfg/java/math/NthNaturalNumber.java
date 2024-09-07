package gfg.java.math;


/**
 * 
 * Problem Name : Nth Natural Number
 * Problem Link : https://www.geeksforgeeks.org/problems/nth-natural-number/1
 * Problem Statement 
 * =============================
 * 
 * Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.

Examples :

Input: n = 8
Output: 8
Explanation: After removing natural numbers which contains digit 9, first 8 numbers are 1,2,3,4,5,6,7,8 and 8th number is 8.
Input: n = 9
Output: 10
Explanation: After removing natural numbers which contains digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10 and 9th number is 10.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 10^9

Time Complexity : O(log(n))
Space Complexity : O(1)
 */
public class NthNaturalNumber {
    long findNth(long n) {
        // code here
        String res = "";
        while(n > 0){
            res = (n % 9) + res;
            n /= 9;
        }
        return Long.parseLong(res);
    }
}
