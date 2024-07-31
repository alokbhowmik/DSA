package gfg.java;

/*
 * Problem Name : Longest Common Prefix of Strings
 * Problem Link : https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
 * 
 * Problem Statement
 * ------------------
 * Given an array of strings arr. Return the longest common prefix among all strings present in the array. If there's no prefix common in all the strings, return "-1".

Examples :

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: gee
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: -1
Explanation: There's no common prefix in the given strings.
Expected Time Complexity: O(n*min(|arri|))
Expected Space Complexity: O(min(|arri|))

Constraints:
1 ≤ |arr| ≤ 103
1 ≤ |arr[i]| ≤ 103


 */
public class LongestCommenPrefixString {
    public String longestCommonPrefix(String arr[]) {
        // code here
        int n = Integer.MAX_VALUE;
        String minStr = "";
        for(String s: arr){
            if(n > s.length()){
                n = s.length();
                minStr = s;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch = minStr.charAt(i);
            for(String s: arr){
                if(s.charAt(i) != ch){
                    return sb.length() == 0 ?"-1":sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
