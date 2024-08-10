package gfg.java.strings;

/**
 * 
 * Problem Name : Validate An IP Address 
 * Problem Link : https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1
 * 
 * Problem Statement : 
 * You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1

A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)

Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

Examples :

Input: str = 222.111.111.111
Output: true
Explanation: Here, the IPv4 address is as per the criteria mentioned and also all four decimal numbers lies in the mentioned range.
Input: str = 5555..555
Output: false
Explanation: 5555..555 is not a valid. IPv4 address, as the middle two portions are missing.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1<=str.length() <=15


Time Complexity : O(n)
Space Complexity : O(1)
 */
public class ValidIP4Address {
    public boolean isValid(String str) {
        // Write your code here
        int i = 0, j = 0, dots = 0, n = str.length();
        long ip = 0;
        while(j < n){
            ip = 0;
            if(str.charAt(i) == '.') return false;
            while(j < n && str.charAt(j) != '.'){
                ip = ip * 10 + (str.charAt(j) - '0');
                if(ip > 255) return false;
                j++;
            }
            if(str.charAt(i) == '0' && j - i > 1) return false;
            j++;
            i = j;
            dots++;
        }
        return dots == 4;
    }
}
