package dp;

/*
*Problem Name : Total Decoding Messages
*
*Problem Link : https://www.geeksforgeeks.org/problems/total-decoding-messages1235/1
*
*Problem Statement : 
*A message containing letters A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

You are given a string digits. You have to determine the total number of ways that message can be decoded.

Examples:

Input: digits = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(1, 2, 3), "LC"(12, 3) and "AW"(1, 23).
Input: digits = "90"
Output: 0
Explanation: "90" cannot be decoded, as it's an invalid string and we cannot decode '0'.
Input: digits = "05"
Output: 0
Explanation: "05" cannot be mapped to "E" because of the leading zero ("5" is different from "05"), the string is not a valid encoding message.
Constraints:
1 ≤ digits.size() ≤ 10^3
* Approach 1 : Recursive
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2 : Recursive + Memorization
*--------------
*TC = O(n) SC = O(n)
*
* Approach 3 : Top Down
*--------------
*TC = O(n) SC = O(n)
*
* Approach 4 : Modified Top Down
*--------------
*TC = O(n) SC = O(n)
*/
public class TotalDecodingMessages{


    // User function Template for Java
    class Solution {
        public int countWays(String digits) {
            // code here
            int[] dp = new int[digits.length() + 1];
            dp[digits.length()] = 1;
            for(int i = digits.length() - 1; i>= 0; i--){
                if(digits.charAt(i) == '0'){
                    dp[i] = 0;
                    continue;
                }
                int digit1 = digits.charAt(i) - '0';
//                int single = dp[i + 1];
                dp[i] = dp[i + 1];
//                int doubl = 0;
                if(i + 1 < digits.length()){
                    int digit2 = digit1 * 10 + (digits.charAt(i + 1) - '0');
                    if(digit2 >= 10 && digit2 <= 26){
//                        doubl = dp[i + 2];
                        dp[i] += dp[i + 2];
                    }
                }
//                dp[i] = single + doubl;
            }
            return dp[0];
        }

        private int solve(int i, String digits, Integer[] dp ){
            if(i >= digits.length() ) return 1;
            if(digits.charAt(i) == '0') return 0 ;
            int digit1 = digits.charAt(i) - '0';
            if(dp[i] != null) return dp[i];
            int single = solve(i + 1, digits, dp);
            int doubl  =0;
            if(i + 1 < digits.length()){
                int digit2 = digit1 * 10 + (digits.charAt(i + 1) - '0');
                if(digit2 >= 10 && digit2 <= 26){
                    doubl = solve(i + 2, digits, dp);
                }
            }
            return dp[i] = single + doubl;
        }
    }
}