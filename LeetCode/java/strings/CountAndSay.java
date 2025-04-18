package strings;

/*
*Problem Name : Count and Say
*
*Problem Link : https://leetcode.com/problems/count-and-say/description/?envType=daily-question&envId=2025-04-18
*
*Problem Statement : 
*
* The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.



Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

Explanation:

This is the base case.



Constraints:

1 <= n <= 30
*
* Approach 1 
*--------------
*TC = O(n * m) SC = O(n)
*/
public class CountAndSay{
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            // count consicutive char
            StringBuilder temp = new StringBuilder();
            int l = 0, r = 0;
            while (l < ans.length()) {
                while (r < ans.length() && ans.charAt(l) == ans.charAt(r)) {
                    r++;
                }
                //temp += (r - l) + ""+ans.charAt(l);
                temp.append(r - l).append(ans.charAt(l));
                l = r;
            }
            ans = temp;
        }
        return ans.toString();
    }
}