package LeetCode.java.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem Name : Find the Closest Palindrome
 * Problem Link : https://leetcode.com/problems/find-the-closest-palindrome/description/
 * 
 * Problem Statement 
 * 
 * Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].

Time Complexity : O(N)
Space Complexity : O(1)

Process 
-------------------------------------------
Lets understand the process by an example. For example we have a number 
num = 12345 
palindromes can be done from this number are mentioned below 

by changing the last half that is 12321
by increasin the middle value we got one palindrome i.e. 12421
by decresing the middle value we got one palindrome i.e. 12221

let suppose the given number is 99 
nearest palindrom we can got from this are 88 and 101
As we can clearly see the 101 is nearest. The point is how to reach 101 if we check the length of the 
given number which is  2 so we can say 10^2 + 1  = 101. we can use the formula(10^lenOfTheString + 1) 



 */
public class NearestPalindrom {
    public String nearestPalindromic(String n) {
        int size = n.length();
        int mid = size / 2;
        boolean isOdd = (size % 2 == 1);
        if (isOdd)
            mid++;
        List<Long> cases = new ArrayList<>();
        long num = Long.parseLong(n.substring(0, mid));
        cases.add(getPalindrom(num, isOdd)); // By adding the first half in reverse Order
        cases.add(getPalindrom(num + 1, isOdd)); // By incresing the middle value
        cases.add(getPalindrom(num - 1, isOdd)); // By decersing the middle value 
        cases.add((long) Math.pow(10, size - 1) - 1); // Incase of already palindrom 
        cases.add((long) Math.pow(10, size) + 1);    // In case of palindrom 
        long minDiff = Long.MAX_VALUE;
        long originalNum = Long.parseLong(n);
        long ans = Long.MAX_VALUE;
        for (long ops : cases) {
            if (ops == originalNum)
                continue;
            long diff = Math.abs(originalNum - ops);
            if (diff < minDiff) {
                minDiff = diff;
                ans = ops;
            } else if (diff == minDiff) {
                ans = Math.min(ans, ops);
            }
        }
        return "" + ans;
    }
    
    private long getPalindrom(long num, boolean isOdd){
        long res = num;
        if(isOdd) num /= 10;
        while(num > 0){
            res = (res * 10) + (num % 10);
            num /= 10;
        }
        return res;
    }
}
