import java.util.HashMap;
import java.util.Map;

/*
*Problem Name : Shortest Common Supersequence 
*
*Problem Link : https://leetcode.com/problems/shortest-common-supersequence/description/
*
*Problem Statement : 
*
* Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.



Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"


Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
* Approach 1 
*--------------
*TC = O(2^n) SC = O(2^n)  // due to internal stack
* TC = (n + m) SC = (m *n) // due to memorization
*/
public class ShortestCommonSupersequence{
    private Map<String, String> map;

    private String solve(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty())
            return "";
        if (str1.isEmpty())
            return str2;
        if (str2.isEmpty())
            return str1;
        String key = str1 + "@" + str2;
        if (map.containsKey(key))
            return map.get(key);
        if (str1.charAt(0) == str2.charAt(0)) {
            String val = str1.charAt(0) + solve(
                    str1.substring(1),
                    str2.substring(1));
            map.put(key, val);
            return val;
        } else {
            String pickStr1 = str1.charAt(0) + solve(str1.substring(1), str2);
            String pickStr2 = str2.charAt(0) + solve(str1, str2.substring(1));
            // System.out.println(pickStr1 +" : "+ pickStr2);
            if (pickStr1.length() < pickStr2.length()) {
                map.put(key, pickStr1);
            } else {
                map.put(key, pickStr2);
            }
            return map.get(key);
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        map = new HashMap<>();
        return solve(str1, str2);
    }
}