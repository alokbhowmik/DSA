package bit;

/*
*
* Problem Name : Minimize XOR
* Problem Link : https://leetcode.com/problems/minimize-xor/description/
*
* Problem Statement
*
*Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.



Example 1:

Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
Example 2:

Input: num1 = 1, num2 = 12
Output: 3
Explanation:
The binary representations of num1 and num2 are 0001 and 1100, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.


Constraints:

1 <= num1, num2 <= 10^9
*
* */
public class MinimizeXOR {
    public int minimizeXor(int num1, int num2) {
        /**
         *
         * num1 = 1 => 0001
         *
         * num2 = 12 => 1100
         *
         * num1 = 25 = 11001
         */
        int cnt = 0;
        int temp = num2;
        while (temp > 0) {
            if (temp % 2 == 1)
                cnt++;
            temp /= 2;
        }
        int res = 0;
        for (int i = 31; i >= 0 && cnt > 0; i--) {
            if ((num1 & (1 << i)) > 0) {
                res |= (1 << i);
                cnt--;
            }

        }
        for (int i = 0; i < 32 && cnt > 0; i++) {
            if ((num1 & (1 << i)) == 0) {
                res |= (1 << i);
                cnt--;
            }
        }
        return res;
    }
}